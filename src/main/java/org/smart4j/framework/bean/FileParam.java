package org.smart4j.framework.bean;

import java.io.InputStream;

/**
 * Created by wanghongjie on 2017/10/24.
 */
public class FileParam {
//    字段名
    private String fieldName;
//    文件名
    private String fileName;
    private long fileSize;
    private String contentType;
    private InputStream inputStream;

    public FileParam(String fieldName, String fileName, long fileSize, String contentType,
                     InputStream inputStream) {
        this.fieldName = fieldName;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.contentType = contentType;
        this.inputStream = inputStream;

    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getContentType() {
        return contentType;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
