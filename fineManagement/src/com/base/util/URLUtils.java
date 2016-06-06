/**
 * 项目名称：com.base.util
 * 创建日期：2016-3-19
 * 修改历史：
 *    1、[2016-3-19]创建文件    by liutianyang
 */
package com.base.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author liutianyang
 */
public class URLUtils {

	
	public static String getReqUri(String reqUrl) {
		try {
			URL url  = new URL(reqUrl);
			return url.getPath();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 组装按钮下URL
	 * @param menuUrl
	 * @param actionUrls
	 * @return
	 */
	public static void getBtnAccessUrls(String menuUrl, String actionUrls, List<String> accessUrls) {
		if (menuUrl == null || actionUrls == null || accessUrls == null ) {
			return;
		}
		String[] actions = StringUtils.split(actionUrls , "|");
		String menuUri = StringUtils.substringBeforeLast(menuUrl, "/");
		for (String action : actions) {
			action = StringUtils.trim(action);
			if (action.startsWith("/"))
				accessUrls.add(action);
			else
				accessUrls.add(menuUri + "/" + action);
		}
	}
}
