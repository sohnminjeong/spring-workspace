package com.kh.api.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.kh.api.model.vo.Sample;

public class EXCELParsingTest {

	public static void main(String[] args) {
		try {
			
			Reader r = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r); 
			SqlSession session = factory.openSession();
			
			
			String fileName = "강남구.xls";
			List<Map<Object, Object>> excelData = readExcel(fileName);
			
			for(int i=1; i<excelData.size(); i++) {
				Sample sample = new Sample();
				//System.out.println(excelData.get(i));
//				Set<Object> keySet = excelData.get(i).keySet();
//				for(Object key : keySet) {
//					System.out.println(key + " : " + excelData.get(i).get(key));
//				}
//				System.out.println();
				
				Map<Object, Object> map = excelData.get(i);
				System.out.println("명칭 : " + map.get("명칭"));
				System.out.println("주소 : " + map.get("주소"));
				System.out.println("개요 : " + map.get("개요"));
				System.out.println("이용시간 : " + map.get("이용시간"));
				System.out.println("상세정보 : " + map.get("상세정보"));
				
				
				sample.setName((String)map.get("명칭"));
				sample.setAddr((String)map.get("주소"));
				sample.setOutline((String)map.get("개요"));
				sample.setUseHour((String)map.get("이용시간"));
				sample.setDetail((String)map.get("상세정보"));
				
				session.insert("sampleMapper.insertSample", sample);
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Map<Object, Object>> readExcel(String fileName) throws IOException{
		List<Map<Object, Object>> list = new ArrayList<>();
		
		FileInputStream fis = new FileInputStream(new File(fileName));
		Workbook workbook = new HSSFWorkbook(fis); //xls버전  (xlsx : XSSFWorkbook 사용)
		if(workbook!=null) {
			Sheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			
			for(int i=0; i<rows; i++) {
				Row row = sheet.getRow(i);
				if(row!=null) {
					int cells = row.getPhysicalNumberOfCells();
					list.add(getCell(row, cells));
				}
			}
		}

		return list;
	}
	
	public static Map<Object, Object> getCell(Row row, int cells){
		Map<Object, Object> map = new HashMap<>();
		String[] columns = {"명칭", "우편번호", "관리자", "전화번호", "주소", "위도", "경도", 
			"개요", "유산구분", "문의 및 안내", "개장일", "쉬는날", "체험안내", "체험가능연령", 
			"수용인원", "이용시기", "주차시설", "유모차 대여 여부", "애완동물 동반 가능 여부", "신용카드 가능 여부", "상세정보"};
		
		for(int i=0; i < cells; i++) {
			if(i >= columns.length) {
				break;
			}
			
			Cell cell = row.getCell(i);
			if(cell!=null) {
				switch(cell.getCellType()) {
					case STRING:
						map.put(columns[i], cell.getStringCellValue());
						break;
					case NUMERIC:
						if(DateUtil.isCellDateFormatted(cell)) {
							map.put(columns[i], cell.getDateCellValue());
						} else {
							map.put(columns[i], cell.getStringCellValue());
						}
						break;
					default:
						map.put(columns[i], "");
						break;
				}
			}
			
		}
		return map;
	}
	
}
