package org.smart4j.framework.bean;

/**
 *
 * 封装表单参数
 * Created by wanghongjie on 2017/10/24.
 */
public class FormParam {
    private String fieldName;
    private Object fieldValue;

    public FormParam(String fieldName, Object fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

}
