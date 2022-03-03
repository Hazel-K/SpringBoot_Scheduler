package kr.co.ex.biz.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.co.ex.biz.wem.WEMSchedule;

@Component
public class ProcessMain {
	private static final Logger log = LoggerFactory.getLogger(ProcessMain.class);
	
	@Autowired
	private WEMSchedule wem;

	@Scheduled(cron = "0/5 * * * * *")
	public void getAWSH() {
		log.info("getAWSH Running... 방재기상정보시스템 데이터 수집");
		wem.requestAWSH();
	}
}