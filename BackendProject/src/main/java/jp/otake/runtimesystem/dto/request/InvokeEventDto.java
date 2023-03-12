package jp.otake.runtimesystem.dto.request;

import lombok.Data;

@Data
public class InvokeEventDto {
    
	private String screenId;
	private String elementId;
	private String eventName;

}