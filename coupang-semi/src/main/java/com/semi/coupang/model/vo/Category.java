package com.semi.coupang.model.vo;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class Category {
	
	private int cateCode;
	private String cateIcon;
	private String cateName;
	private String cateUrl;
	private int parentCode;
	
	// 하위 카테고리가 리스트 형식으로 보여야 함
	// subList가 mapper에서 collection property에 해당
	private List<Category> subList;
	
	// 하위 카테고리의 코드와 이름 -> mapper에서 collection 안에 들어감(id, result로 작성) 
	private int subCode;
	private String subName;
}
