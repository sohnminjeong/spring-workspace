package com.semi.coupang.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pick {
	
	private int pickCode;
	private String id;
	private int prodCode;
	private Date pickDate;
}
