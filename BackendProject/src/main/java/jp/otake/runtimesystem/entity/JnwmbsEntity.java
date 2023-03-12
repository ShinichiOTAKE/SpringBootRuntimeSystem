package jp.otake.runtimesystem.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class JnwmbsEntity {

	private String bsbscd;
	
	private String bsckcd;
	
	private String bsbsrn;
	
	private String bsbskn;
	
	private String bsbsjn;
	
	private BigDecimal bscdkb;
	
	private String bsaucd;
	
	private String bsuucd;
	
	private BigDecimal bsaday;
	
	private BigDecimal bsuday;
	
	private BigDecimal bsatim;
	
	private BigDecimal bsutim;

}