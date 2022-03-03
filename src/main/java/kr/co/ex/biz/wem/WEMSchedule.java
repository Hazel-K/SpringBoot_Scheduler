package kr.co.ex.biz.wem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import kr.co.ex.biz.constant.WEMConstant;
import kr.co.ex.biz.process.RestTemplateUtil;
import kr.co.ex.biz.utility.TimeUtils;

@Component
public class WEMSchedule {
	
	private static final Logger log = LoggerFactory.getLogger(WEMSchedule.class);
	
	@Autowired
	private RestTemplateUtil restTemplate;
	
	@Autowired
	private WEMSqlService wemSql;
	
	public void requestAWSH() {
		log.info("requestAWSH Running...");
		String[] timeArray = TimeUtils.get21to9Time();
		HashMap<String, String> parameter = new HashMap<String, String>();
		// 강수 정시자료
		parameter.put("authKey", WEMConstant.AFSOAPIKEY);
		parameter.put("tm", timeArray[0]);
		
		HttpHeaders header = new HttpHeaders();
		header.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		ResponseEntity<String> resultSet = restTemplate.excuteGetExchange(WEMConstant.AFSOAWSH, parameter, header);
		log.debug(resultSet.toString());
		
		Map<String,Object> param = new HashMap<String,Object>();
		List<Map<String, Object>> sqlResult = wemSql.selectTest(param);
		for (Map<String, Object> item : sqlResult) {
			log.debug(item.toString());
		}
		// 적설 기간
	}
	
}