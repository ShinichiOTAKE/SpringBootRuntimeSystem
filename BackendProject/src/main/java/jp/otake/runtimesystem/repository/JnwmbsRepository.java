package jp.otake.runtimesystem.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.otake.runtimesystem.dto.request.RequestDto;
import jp.otake.runtimesystem.entity.JnwmbsEntity;

@Repository
public class JnwmbsRepository {
	
	private final String FIND_ALL_SQL = 
		        	"SELECT *" +
		        	"  FROM JNWMBS" +
		        	" WHERE BSBSCD = :bsbscd" +
		        	"  WITH UR";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<JnwmbsEntity> findByRequest(RequestDto request) {
		
		return jdbcTemplate.query(FIND_ALL_SQL,
				new BeanPropertySqlParameterSource(request), 
				new BeanPropertyRowMapper<JnwmbsEntity>(JnwmbsEntity.class));
	
	}
	
}