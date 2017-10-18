package org.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;

/**字符串工具类
 * Created by ${wanghongjie} on 2017/8/19.
 */
public final class StringUtil {
    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String string) {
        if (string != null) {
            string = string.trim();

        }
        return StringUtils.isEmpty(string);
    }

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }


    /**
     * 分割字符串
     */
    public static String[] splitString(String string, String c) {
        return StringUtils.split(string, c);
    }

}
