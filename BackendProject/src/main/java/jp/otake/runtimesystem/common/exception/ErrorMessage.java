package jp.otake.runtimesystem.common.exception;

import jp.otake.runtimesystem.dto.response.TransformableJson;
import lombok.Data;

@Data
public class ErrorMessage implements TransformableJson {

	private String code;
	
	private String text;

}
