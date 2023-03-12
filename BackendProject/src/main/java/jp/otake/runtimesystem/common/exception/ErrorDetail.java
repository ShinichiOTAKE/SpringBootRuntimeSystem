package jp.otake.runtimesystem.common.exception;

import jp.otake.runtimesystem.dto.response.TransformableJson;
import lombok.Data;

@Data
public class ErrorDetail implements TransformableJson {

	private String elementId;
	
	private String text;

}
