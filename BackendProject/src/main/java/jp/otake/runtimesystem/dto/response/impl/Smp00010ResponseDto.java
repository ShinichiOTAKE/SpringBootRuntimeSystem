package jp.otake.runtimesystem.dto.response.impl;

import java.math.BigDecimal;

import jp.otake.runtimesystem.dto.response.TransformableJson;
import lombok.Data;

@Data
public class Smp00010ResponseDto implements TransformableJson {

	private String bsbscd;
	
	private String bsckcd;
	
	private String bsbsrn;
	
	private String bsbskn;
	
	private String bsbsjn;
	
	private BigDecimal bscdkb;

}
