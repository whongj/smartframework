package org.smart4j.framework.helper;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.bean.FileParam;
import org.smart4j.framework.bean.FormParam;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.util.CollectionUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 文件上传助手类
 * Created by wanghongjie on 2017/10/24.
 */
public class UploadHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadHelper.class);

    /**
     * Apache Commons FileUpload 提供的Servlet 文件上传对象
     */
    private static ServletFileUpload servletFileUpload;

    /**
     * 初始化
     */
    public static void init(ServletContext servletContext) {
//需要复习一下java EE 基础的知识点
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        servletFileUpload = new ServletFileUpload(new DiskFileItemFactory(DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD, repository));

        int uploadLimit = ConfigHelper.getAppUploadLimit();
        if (uploadLimit != 0) {
            servletFileUpload.setFileSizeMax(uploadLimit * 1024 * 1024);
        }
    }

    /**
     * 判断是否为multipart类型
     */
    public static boolean isMultipart(HttpServletRequest request) {
        return ServletFileUpload.isMultipartContent(request);
    }

    /**
     * 创建请求对象
     */
    public static Param createParam(HttpServletRequest request) throws IOException {

        List<FormParam> formParamsList = new ArrayList<FormParam>();
        List<FileParam> fileParamList = new ArrayList<FileParam>();
        try {
            Map<String, List<FileItem>> fileItemListMap = servletFileUpload.parseParameterMap(request);
            if (CollectionUtil.isNotEmpty(fileItemListMap)) {
                for (Map.Entry<String, List<FileItem>> fileItemListEntry : fileItemListMap.entrySet()) {

                    String filedName = fileItemListEntry.getKey();
                    List<FileItem> fileItemList = fileItemListEntry.getValue();
                    if (CollectionUtil.isNotEmpty(fileItemListMap)) {
                        for (FileItem fileItem : fileItemList) {
                            if (fileItem.isFormField()) {
                                String fieldValue = fileItem.getString("UTF-8");
                                formParamsList.add(new FormParam(filedName, fieldValue));

                            } else {
                                String fileName = FileUtil.
                            }
                        }
                    }


                }
            }
        }
    }

}
