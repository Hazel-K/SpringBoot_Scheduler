package kr.co.ex.biz.wem;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WEMSqlService {
	
	@Autowired
	private WEMMapper wemMapper;
	
	List<Map<String, Object>> selectTest(Map<String, Object> params) {
		return wemMapper.selectTest(params);
	}
}