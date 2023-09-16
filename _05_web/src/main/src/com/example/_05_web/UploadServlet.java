package com.example._05_web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建fileItemFactor实现类
        FileItemFactory fileItemFactor = new DiskFileItemFactory();
        // 创建解析上传的fileUpload对象
        FileUpload fileUpload = new FileUpload(fileItemFactor);
        // 判断是普通上传类型还是multipart-content
        if (FileUpload.isMultipartContent(req)) {
            try {
                // 获取所有表单项
                List<FileItem> list = fileUpload.parseRequest(req);
                // 遍历所有表单项
                for (FileItem fileItem : list) {
                    // 判断是普通类型还是文件类型
                    if (fileItem.isFormField()) {
                        // 普通类型获取字段名与字段值
                        String fieldName = fileItem.getFieldName();
                        // 传入编码格式防止中文乱码
                        String value = fileItem.getString("UTF-8");
                        System.out.println("字段：" + fieldName + "->" + value);
                    } else {
                        // 文件类型获取字段名与文件名
                        String fieldName = fileItem.getFieldName();
                        // 传入编码格式防止中文乱码
                        String fileName = fileItem.getName();
                        System.out.println("字段：" + fieldName + ",文件名:" + fileName);
                        // 将文件写入本地磁盘
                        fileItem.write(new File("/Users/haonan/Desktop/" + fileName));
                    }
                }
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {

        }
    }
}
