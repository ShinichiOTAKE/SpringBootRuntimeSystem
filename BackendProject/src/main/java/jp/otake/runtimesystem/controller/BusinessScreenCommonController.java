package jp.otake.runtimesystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.otake.runtimesystem.dto.request.InvokeEventDto;
import jp.otake.runtimesystem.dto.request.impl.Smp00010RequestDto;
import jp.otake.runtimesystem.dto.response.impl.Smp00010ResponseDto;
import jp.otake.runtimesystem.service.BusinessScreenProxy;

@RestController
@RequestMapping("/v1/screens/{screenId}/{elementId}/{eventName}")
public class BusinessScreenCommonController {
	
	private BusinessScreenProxy proxy;
	
	public BusinessScreenCommonController(BusinessScreenProxy proxy) {
		this.proxy = proxy;
	}
    
	@PostMapping(headers = {"X-HTTP-Method-Override=GET"})
	@ResponseBody
	public List<Smp00010ResponseDto> GetRequestHandle(InvokeEventDto event, @RequestBody final Smp00010RequestDto request) throws Throwable {	
		//var event = new InvokeEventDto();
		
		//event.setScreenId("Smp00010");
		///event.setElementId("searchButton");
		//event.setEventName("onClick");
		
		return (List<Smp00010ResponseDto>) this.proxy.excute(event, request);
	}
}