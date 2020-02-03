package com.boot.gang.util;
 
/**
 * <p>Title: money</p>
 * <p>Description: 
 *   *该类是把阿拉伯数字转换成中文大写的类。根据王大庆兄的C++程序稍做修改而成，后面附有王大庆兄的C++
 *   *程序，如果对所附的C++程序有什么问题请与王大庆兄联系email: wang_daqing@21cn.com
 *   *如果对java部分有什么看法和建议请与小弟联系，杨璇 email：netfalcon@263.net
 *   *类名：money
 *   *函数：String PositiveIntegerToHanStr(String NumStr)   负责把小数点前面的数转换为大写中文
 *    *函数:?String NumToRMBStr(double val)   负责把输入的double型的数转换为大写中文
 *   *注意java程序转换的范围是：小数点前面15位（已测试通过），C＋＋程序是24位（我没有测试）
 * </p>
 * <p>Copyright: Copyright (c) 2003 你可以对本程序随意修改，复制，使用，但请保留这里注释声明！！！</p>
 * <p>Company: </p>
 * @author 王大庆、杨璇
 * @version 1.0
 */
 
import java.lang.Math;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
 
public class MoneyUtils {


	static String HanDigiStr[] = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

	static String HanDiviStr[] = new String[]{"", "拾", "佰", "仟", "万", "拾", "佰", "仟",
			"亿", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万",
			"拾", "佰", "仟"};

	public static void main(String[] args) {
		System.out.println(NumToRMBStr(123214.123));;
	}

	public static String PositiveIntegerToHanStr(String NumStr) { // 输入字符串必须正整数，只允许前导空格(必须右对齐)，不宜有前导零
		String RMBStr = "";
		boolean lastzero = false;
		boolean hasvalue = false; // 亿、万进位前有数值标记
		int len, n;
		len = NumStr.length();
		if (len > 15)
			return "数值过大!";
		for (int i = len - 1; i >= 0; i--) {
			if (NumStr.charAt(len - i - 1) == ' ')
				continue;
			n = NumStr.charAt(len - i - 1) - '0';
			if (n < 0 || n > 9)
				return "输入含非数字字符!";

			if (n != 0) {
				if (lastzero)
					RMBStr += HanDigiStr[0]; // 若干零后若跟非零值，只显示一个零
				// 除了亿万前的零不带到后面
				// if( !( n==1 && (i%4)==1 && (lastzero || i==len-1) ) ) //
				// 如十进位前有零也不发壹音用此行
				//if (!(n == 1 && (i % 4) == 1 && i == len - 1)) // 十进位处于第一位不发壹音
				RMBStr += HanDigiStr[n];
				RMBStr += HanDiviStr[i]; // 非零值后加进位，个位为空
				hasvalue = true; // 置万进位前有值标记

			} else {
				if ((i % 8) == 0 || ((i % 8) == 4 && hasvalue)) // 亿万之间必须有非零值方显示万
					RMBStr += HanDiviStr[i]; // “亿”或“万”
			}
			if (i % 8 == 0)
				hasvalue = false; // 万进位前有值标记逢亿复位
			lastzero = (n == 0) && (i % 4 != 0);
		}

		if (RMBStr.length() == 0)
			return HanDigiStr[0]; // 输入空字符或"0"，返回"零"
		return RMBStr;
	}

	public static String NumToRMBStr(double val) {
		String SignStr = "";
		String TailStr = "";
		long fraction, integer;
		int jiao, fen;
		if (val < 0) {
			val = -val;
			SignStr = "负";
		}
		if (val > 99999999999999.999 || val < -99999999999999.999)
			return "数值位数过大!";
		// 四舍五入到分
		long temp = Math.round(val * 100);
		integer = temp / 100;
		fraction = temp % 100;
		jiao = (int) fraction / 10;
		fen = (int) fraction % 10;
		if (jiao == 0 && fen == 0) {
			TailStr = "整";
		} else {
			TailStr = HanDigiStr[jiao];
			if (jiao != 0)
				TailStr += "角";
			if (integer == 0 && jiao == 0) // 零元后不写零几分
				TailStr = "";
			if (fen != 0)
				TailStr += HanDigiStr[fen] + "分";
		}

		// 下一行可用于非正规金融场合，0.03只显示“叁分”而不是“零元叁分”
		// if( !integer ) return SignStr+TailStr;

		return SignStr + PositiveIntegerToHanStr(String.valueOf(integer))
				+ "元" + TailStr;
	}

	public static String NumToCHSStr(double val) {
		long integer;
		if (val > 99999999999999.999 || val < -99999999999999.999)
			return "数值位数过大!";
		// 四舍五入到分
		long temp = Math.round(val * 100);
		integer = temp / 100;
		return PositiveIntegerToHanStr(String.valueOf(integer));
	}

	public static BigDecimal sswr(BigDecimal ddd) {
//		DecimalFormat df1 = new DecimalFormat("#");
//		String temp1 = df1.format(ddd);
//		ddd = new BigDecimal(temp1);
		if (ddd == null) {
			return new BigDecimal(0);
		}
		DecimalFormat df2 = new DecimalFormat("#.####");
		String temp2 = df2.format(ddd);
		return new BigDecimal(temp2);
	}

	public static BigDecimal sswr1(BigDecimal ddd) {
		if (ddd == null) {
			return new BigDecimal(0);
		}
		DecimalFormat df2 = new DecimalFormat("#.00");
		String temp2 = df2.format(ddd);
		return new BigDecimal(temp2);
	}

	public static BigDecimal sswr2(BigDecimal ddd) {
//		DecimalFormat df1 = new DecimalFormat("#");
//		String temp1 = df1.format(ddd);
//		ddd = new BigDecimal(temp1);
		if (ddd == null) {
			return new BigDecimal(0);
		}
		DecimalFormat df2 = new DecimalFormat("#.####");
		String temp2 = df2.format(ddd);
		return new BigDecimal(temp2);
	}

	/**
	 * 显示结果为：千万元
	 *
	 * @param ddd
	 * @return
	 */
	public static String sswr3(BigDecimal ddd) {
//		DecimalFormat df1 = new DecimalFormat("#");
//		String temp1 = df1.format(ddd);
//		ddd = new BigDecimal(temp1);
		ddd = ddd.divide(new BigDecimal(1000), 7, BigDecimal.ROUND_HALF_DOWN);
		DecimalFormat df2 = new DecimalFormat("#.####");
		String temp2 = df2.format(ddd);
		return temp2;
	}
}