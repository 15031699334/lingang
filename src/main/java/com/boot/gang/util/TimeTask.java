package com.boot.gang.util;

import com.boot.gang.entity.Config;
import com.boot.gang.service.CommonService;
import com.boot.gang.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeTask {

	@Autowired
	private ConfigService configService;
	@Autowired
	private CommonService commonService;
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
		config.setcComment(excutePostClient);
		configService.upVolumePriceList(config);
	}
	// 每4小时执行一次
	@Scheduled(cron = "0 */30 * * * ?")
	public void checkOrder() {
		System.out.println("=== 订单筛查 ===");
		try {
			commonService.checkOrder();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	// 每天0点执行
//	@Scheduled(cron = "0 0 0 * * ?")
//	public void clearDeptCountTodayByCronCount() {
//		System.out.println("===clearDeptCountTodayByCronCount===");
//		deptHamsService.redDeptCount(PropertiesUtils.getProperties(PropertiesUtils.FILEPATH).getProperty("com.lingqiu.excel.month"));
//	}
}
