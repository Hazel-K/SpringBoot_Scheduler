package kr.co.ex.biz.wem;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WEMMapper {
	List<Map<String, Object>> selectTest(Map<String, Object> params);
}