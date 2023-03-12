package jp.otake.runtimesystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.otake.runtimesystem.dto.request.RequestDto;
import jp.otake.runtimesystem.dto.response.impl.Smp00010ResponseDto;
import jp.otake.runtimesystem.entity.JnwmbsEntity;
import jp.otake.runtimesystem.repository.JnwmbsRepository;
import jp.otake.runtimesystem.service.BusinessScreenService;

@Service("Smp00010Service")
public class Smp00010Service implements BusinessScreenService {
	
	private JnwmbsRepository jnwmbsRepository;

	public Smp00010Service (JnwmbsRepository jnwmbsRepository) {
	
		this.jnwmbsRepository = jnwmbsRepository;
	
	}
	
	public List<Smp00010ResponseDto> base_onLoad(RequestDto request) {
		
		List<JnwmbsEntity> entities = jnwmbsRepository.findByRequest(request);
		
		var results = new ArrayList<Smp00010ResponseDto>();
	
		for (JnwmbsEntity entity: entities) {
			
			var result = new Smp00010ResponseDto();
			
			result.setBsbscd(entity.getBsbscd());
			result.setBsckcd(entity.getBsckcd());
			result.setBsbsrn(entity.getBsbsrn());
			result.setBsbskn(entity.getBsbskn());
			result.setBsbsjn(entity.getBsbsjn());
			result.setBscdkb(entity.getBscdkb());
			
			results.add(result);
		}
		
		return results;
	}

}