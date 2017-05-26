package com.handx.java;

/**
 * @ClassName: JavaCmd
 * @Description: java調用cmd命令
 * @author handx 908716835@qq.com
 * @date 2017年5月26日 下午4:52:24
 *
 */
public class JavaCmd {

	public static void main(String[] args) {
		try {
			Runtime.getRuntime().exec("wmic process where name=\"chromedriver.exe\" call terminate");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
