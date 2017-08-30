package org.smart4j.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 *
 *
 * Q:MMP嘞，为啥非要搞这么一个？？？？？？？
 * Created by wanghongjie on 2017/8/28.
 */
public class ArrayUtil {
    /**
     * 判断数组是否为非空
     */
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }

    /**
     * 判断数组是否为空
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }

}
