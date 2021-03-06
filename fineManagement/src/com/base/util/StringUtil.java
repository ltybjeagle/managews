/**
 * 项目名称：com.base.util
 * 创建日期：2016-3-18
 * 修改历史：
 *    1、[2016-3-18]创建文件    by liutianyang
 */
package com.base.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

/**
 * 提供字符串处理的实用方法集
 * @author liutianyang
 */
public class StringUtil {

	public StringUtil() {
	}

	public static final String escapeForIntro(String string) {
		String str = string;
		str = replace(str, "\r\n", "<br>");
		str = replace(str, "\n", "<br>");
		str = replace(str, "'", "\\'");
		return replace(str, "\r", "");
	}
	
	/**
	 * 得到非空的字符串，若字符串对象为null，则返回""。
	 * @param objValue Object待转换的原字符串对象
	 * @return String 转换后的字符串
	 */
	public static String getNotNullStr(Object objValue) {
		return (objValue == null ? "" : objValue.toString());
	}

	/**
	 * 得到非空的字符串，若字符串为null，则返回""。
	 * @param strValue String待转换的原字符串
	 * @return String 转换后的字符串
	 */
	public static String getNotNullStr(String strValue) {
		return (strValue == null ? "" : strValue.trim());
	}
	
	/**
	 * 用"0"补足一个字符串到指定长度
	 * @param str - 源字符串
	 * @param size - 补足后应达到的长度
	 * @return - 补零后的结果
	 */
	public static String fillZero(String str, int size) {
		String result;
		if (str.length() < size) {
			char[] s = new char[size - str.length()];
			for (int i = 0; i < (size - str.length()); i++) {
				s[i] = '0';
			}
			result = new String(s) + str;
		} else {
			result = str;
		}
		return result;
	}

	/**
	 * 根据字符串（文件类型或者多行输入类型）获取字符串数组
	 * @param str1 String 输入字符串
	 * @return String[] 返回结果
	 */
	public static String[] getStrArryByString(String str1) {
		if (str1.indexOf("\t") > 0) {
			for (int i = 0; i < str1.length(); i++) {
				if (str1.substring(i, i + 1).equals("\t")) {
					str1 = str1.substring(0, i) + " " + str1.substring(i + 1, str1.length());
				}
			}
		}
		StringTokenizer stringTokenizer = new StringTokenizer(str1, "\r\n");
		String[] strId = new String[stringTokenizer.countTokens()];
		int i = 0;
		while (stringTokenizer.hasMoreTokens()) {
			strId[i] = stringTokenizer.nextToken();
			i++;
		}
		return strId;
	}
	
	/**
	 * 判断一个字符串是否为 NUll 或为空
	 * @param inStr inStr
	 * @return boolean
	 */
	public static boolean isValid(String inStr) {
		if (inStr == null) {
			return false;
		} else if (inStr.equals("")) {
			return false;
		} else if (inStr.equals("null")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 判断一个字符串是否为 NUll 或为空
	 * @param inStr inStr
	 * @return boolean
	 */
	public static boolean checkNotNull(String str) {
		boolean flag = false;
		if (str != null && str.trim().length() != 0)
			flag = true;
		return flag;
	}

	/**
	 * 获得指定长度的空格
	 * @param spaceNum spaceNum
	 * @return String
	 */
	public static String getStrSpace(int spaceNum) {
		return getStrWithSameElement(spaceNum, " ");
	}

	/**
	 * 获得指定长度的字符串
	 * @param num int
	 * @param element String
	 * @return String
	 */
	public static String getStrWithSameElement(int num, String element) {
		if (num <= 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++) {
			sb.append(element);
		}
		return sb.toString();
	}
	
	/**
	 * 从右或左加空格
	 * @param strIn String
	 * @param totalLength int
	 * @param isRightAlign boolean
	 * @return String
	 */
	public static String getFillString(String strIn, int totalLength, boolean isRightAlign) {
		int spaceLength = 0;
		String spaces = null;
		String strOut = null;
		if (strIn == null) {
			strIn = "";
		}
		spaceLength = totalLength - strIn.length();
		if (spaceLength < 0) {
			spaceLength = 0;
		}
		spaces = StringUtil.getStrSpace(spaceLength);
		if (isRightAlign) {
			strOut = spaces + strIn;
		} else {
			strOut = strIn + spaces;
		}
		return strOut;
	}
	
	/**
	 * 以String类型返回错误抛出的堆栈信息
	 * @param t Throwable
	 * @return String
	 */
	public static String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		return sw.toString();
	}

	/**
	 * 转换字符串第一个字符为大写
	 * @param str String
	 * @return String
	 */
	public static String getStrByUpperFirstChar(String str) {
		try {
			return str.substring(0, 1).toUpperCase() + str.substring(1);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 转换字符串第一个字符为小写
	 * @param str String
	 * @return String
	 */
	public static String getStrByLowerFirstChar(String str) {
		try {
			return str.substring(0, 1).toLowerCase() + str.substring(1);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 通过字符串转换成相应的整型，并返回。
	 * @param strValue String 待转换的字符串
	 * @return int 转换完成的整型
	 */
	public static int getStrToInt(String strValue) {
		if (null == strValue) {
			return 0;
		}
		int iValue = 0;
		try {
			iValue = new java.lang.Integer(strValue.trim()).intValue();
		} catch (Exception ex) {
			iValue = 0;
		}
		return iValue;
	}
	
	/**
	 * 通过字符串转换成相应的DOUBLE，并返回。
	 * @param strValue String 待转换的字符串
	 * @return double 转换完成的DOUBLE
	 */
	public static double getStrToDouble(String strValue) {
		if (null == strValue) {
			return 0;
		}
		double dValue = 0;
		try {
			dValue = Double.parseDouble(strValue.trim());
		} catch (Exception ex) {
			dValue = 0;
		}
		return dValue;
	}

	/**
	 * 通过字符串转换成相应的短整型，并返回。
	 * @param strValue String 待转换的字符串
	 * @return short 转换完成的短整型
	 */
	public static short getStrToShort(String strValue) {
		if (null == strValue) {
			return 0;
		}
		short iValue = 0;
		try {
			iValue = new java.lang.Short(strValue.trim()).shortValue();
		} catch (Exception ex) {
			iValue = 0;
		}
		return iValue;
	}

	/**
	 * 通过字符串转换成相应的长整型，并返回。
	 * @param strValue String 待转换的字符串
	 * @return long 转换完成的长整型
	 */
	public static long getStrToLong(String strValue) {
		if (null == strValue) {
			return 0;
		}
		long lValue = 0;
		try {
			lValue = new java.lang.Long(strValue.trim()).longValue();
		} catch (Exception ex) {
			lValue = 0;
		}
		return lValue;
	}

	public static String toLengthForEn(String str, int length) {
		if (null != str) {
			if (str.length() <= length) {
				return str;
			} else {
				str = str.substring(0, length - 2);
				str = str + "..";
				return str;
			}
		} else {
			return "";
		}
	}
	
	/**
	 * 降字符串转换成给定长度的字符串，如超出的话截断，并在最后以两个点结尾
	 * @param str String
	 * @param length int
	 * @return String
	 */
	public static String toLengthForIntroduce(String str, int length) {
		str = delTag(str);
		byte[] strByte = str.getBytes();
		int byteLength = strByte.length;
		char[] charArray;
		StringBuffer buff = new StringBuffer();
		if (byteLength > (length * 2)) {
			charArray = str.toCharArray();
			int resultLength = 0;
			for (int i = 0; i < charArray.length; i++) {
				resultLength += String.valueOf(charArray[i]).getBytes().length;
				if (resultLength > (length * 2)) {
					break;
				}
				buff.append(charArray[i]);
			}
			buff.append("..");
			str = buff.toString();
		}
		str = replace(str, "\"", "\\\"");
		str = replace(str, "，", ",");
		return str;
	}

	public static String delTag(String str) {
		str = str + "<>";
		StringBuffer buff = new StringBuffer();
		int start = 0;
		int end = 0;
		while (str.length() > 0) {
			start = str.indexOf("<");
			end = str.indexOf(">");
			if (start > 0) {
				buff.append(str.substring(0, start));
			}
			if (end > 0 && end <= str.length()) {
				str = str.substring(end + 1, str.length());
			} else {
				str = "";
			}
		}
		String result = buff.toString();
		while (result.startsWith(" ")) {
			result = result.substring(result.indexOf(" ") + 1, result.length());
		}
		return result;
	}

	public static final String replace(String line, String oldString, String newString) {
		if (line == null) {
			return null;
		}
		int i = 0;
		if ((i = line.indexOf(oldString, i)) >= 0) {
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = line.indexOf(oldString, i)) > 0) {
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			return buf.toString();
		}
		return line;
	}
	
	//	Replace
	public static String Replace(String source, String oldString, String newString) {
		if (source == null) {
			return null;
		}
		StringBuffer output = new StringBuffer();
		int lengOfsource = source.length();
		int lengOfold = oldString.length();
		int posStart = 0;
		int pos;
		while ((pos = source.indexOf(oldString, posStart)) >= 0) {
			output.append(source.substring(posStart, pos));
			output.append(newString);
			posStart = pos + lengOfold;
		}
		if (posStart < lengOfsource) {
			output.append(source.substring(posStart));
		}
		return output.toString();
	}

	// 判断是否含有中文，如果含有中文返回ture
	public static boolean containsChinese(String str) throws UnsupportedEncodingException {
		if (str.length() < (str.getBytes()).length)
			return true;
		return false;
	}
	
	public static boolean isEmpty(String str) {
		if (str == null)
			return true;
		return "".equals(str.trim());
	}

	public static String[] split(String str1, String str2) {
		return StringUtils.split(str1, str2);
	}
	
	/**
	 * 将字符串转成list
	 * @param exp 分割符 如","
	 * @param value
	 * @return
	 */
	public static List<String> StringToList(String value, String exp) {
		List<String> resultList = new ArrayList<String>();
		String[] vals = split(value, exp);
		for (String val : vals) {
			resultList.add(val);
		}
		return resultList;
	}

	/**
	 * 数字转换成字符串
	 * @param arrs
	 * @return
	 */
	public static String arrayToString(String[] arrs) {
		StringBuffer result = new StringBuffer("");
		if (arrs != null && arrs.length > 0) {
			for (int i = 0; i < arrs.length; i++) {
				if (!result.toString().equals("")) {
					result.append(",");
				}
				if (arrs[i] != null && !"".equals(arrs[i].trim())) {
					result.append(arrs[i]);
				}
			}
		}
		return result.toString();
	}

	/**
	 * 数字转换成字符串
	 * @param arrs
	 * @return
	 */
	public static String arrayToString(Object[] arrs) {
		StringBuffer result = new StringBuffer("");
		if (arrs != null && arrs.length > 0) {
			for (int i = 0; i < arrs.length; i++) {
				if (!result.toString().equals("")) {
					result.append(",");
				}
				if (arrs[i] != null && !"".equals(arrs[i].toString().trim())) {
					result.append(arrs[i]);
				}
			}
		}
		return result.toString();
	}

	/**
	 * 替换回车
	 * @param str
	 * @return
	 */
	public static String replaceHuiche(String str) {
		String after = str.replaceAll("\r\n", "");
		return after;
	}

	/**
	 * 返回string型的字节数
	 * @param str
	 * @return
	 */
	public static int getByteLength(String str) {
		if (str == null) {
			return 0;
		}
		return str.getBytes().length;
	}

	/**
	 * 
	 * @param str 字符
	 * @param limitLen 长度
	 * @return
	 */
	public static String getByteStr(String str, int limitLen) {
		StringBuffer sb = new StringBuffer();
		char[] chars = getNotNullStr(str).toCharArray();
		int len = 0;
		for (char c : chars) {
			len += getByteLength(String.valueOf(c));
			if (len <= limitLen) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * @param content 内容
	 * @param length 指定长度。 超出这个长度就截取字符串。
	 * @param padding 超出长度后，尾加上字符，如"..."，可以为空
	 * @return 返回结果 如果内容没有超出指定的长度。则返回原字符串，超出长度后则截取到指定的长度的内容
	 */
	public static String subStr(String content, Integer length, String padding) throws UnsupportedEncodingException {
		String str = "";
		int paddSize = StringUtils.isBlank(padding) ? 0 : padding.length();
		// 如果内容为空，或者小于指定的长度。则返回原内容
		if (StringUtils.isBlank(content) || content.length() <= length) {
			return content;
		}
		str = content.substring(0, length - paddSize);
		if (StringUtils.isNotBlank(padding)) {
			str += padding;
		}
		return str;
	}
}
