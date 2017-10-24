package org.smart4j.framework;

import org.smart4j.framework.helper.*;
import org.smart4j.framework.util.ClassUtil;

/**
 *
 * 为了让加载更为集中
 * 加载相应的Helper类
 *
 *
 * 注意AopHelper 要在IocHelper之前加载，因为首先需要通过AopHelper获取代理对象，然后才能通过IocHelper进行依赖注入
 * Created by wanghongjie on 2017/8/30.
 */
public class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,

        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), true);

        }
    }
}
