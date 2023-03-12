package jp.otake.runtimesystem.service;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import jp.otake.runtimesystem.dto.request.InvokeEventDto;
import jp.otake.runtimesystem.dto.request.RequestDto;
import jp.otake.runtimesystem.dto.response.impl.Smp00010ResponseDto;

@Service
public class BusinessScreenProxy implements BusinessScreenService {

	private final String SUFFIX_SERVICE_CLASS_NAME = "Service";
	private final String SEPARATOR_METHOD_NAME = "_";
	
	private final BeanFactory beanFactory;

	private BusinessScreenProxy(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public List<Smp00010ResponseDto>  excute(InvokeEventDto event, RequestDto request) throws Throwable {
	
		checkRequest(event, request);
		
		BusinessScreenService service = 
				this.beanFactory.getBean(getBeanName(event), BusinessScreenService.class);
		
		Class<?> serviceClass = service.getClass();
		Method method = serviceClass.getMethod(getInvocationTargetName(event), RequestDto.class);
		
		return (List<Smp00010ResponseDto>) method.invoke(service, request);
	}
	
	private void checkRequest(InvokeEventDto event, RequestDto reqest) throws Throwable {
		;
	}
	
	private String getBeanName(InvokeEventDto event) {
		return StringUtils.capitalize(event.getScreenId() + SUFFIX_SERVICE_CLASS_NAME);
	}
	
	private String getInvocationTargetName(InvokeEventDto event) {
		return event.getElementId().trim() + SEPARATOR_METHOD_NAME + event.getEventName().trim();
	}
}
