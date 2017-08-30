package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手类
 * 实现依赖注入最简单的方式：
 * 先通过BeanHelper 获取所有Bean Map （是一个Map<Class<?>,Object>结构 记录了类与对象的映射关系）然后遍历这个映射关系，分别取出Bean 类 与bean实例，进而通过反射获取类中
 * 所有的成成员变量。继续遍历这些成员变量，在循环中判断当前成员变量是否带有Inject注解，若带有该注解，则从Bean Map 中根据Bean 类取出Bean实例。最后通过
 * ReflectionUtil#setField方法来修改当前成员变量的值
 * Created by wanghongjie on 2017/8/28.
 */
public final class IocHelper {
    static{
        //获取所有的Bean类与bean实例之间的映射关系（简称 Bean Map）
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            //遍历Bean Map
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                //从BeanMap中获取Bean 类与Bean 实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取Bean类定义的所有成员变量（简称 Bean Field）
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    //遍历Bean Field
                    for (Field beanField : beanFields) {
                        //判断当前bean Field 是否带有Inject 注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            //在Bean Map中获取Bean Field对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                //通过反射初始化BeanField的值
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);

                            }
                        }
                    }
                }
            }
        }
    }

}
