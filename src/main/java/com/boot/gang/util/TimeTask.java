package com.boot.gang.util;

import com.boot.gang.entity.Config;
import com.boot.gang.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeTask {

	@Autowired
	private ConfigService configService;

//	public static void main(String[] args) {
//		getJson();
//	}
	// 每4小时执行一次
	@Scheduled(cron = "0 0 */4 * * ?")
	public void getJson() {
		System.out.println("===getJson for config===");
		String excutePostClient = HttpUtil.excutePostClient("https://api.huisteel.cn/api/price/index", "", 2);
//		System.out.println(excutePostClient);
		Config config = new Config();
		config.setcId("volume_price_list");
		config.setcValue(excutePostClient);
		configService.upVolumePriceList(config);
	}

//	// 每天0点执行
//	@Scheduled(cron = "0 0 0 * * ?")
//	public void clearDeptCountTodayByCronCount() {
//		System.out.println("===clearDeptCountTodayByCronCount===");
//		deptHamsService.redDeptCount(PropertiesUtils.getProperties(PropertiesUtils.FILEPATH).getProperty("com.lingqiu.excel.month"));
//	}
}
