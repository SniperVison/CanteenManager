package com.vison.canteen.biz.util;

import com.vison.canteen.core.exception.CanteenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author huangwenshen 2018/4/10 14:31
 */
@Slf4j
@Component
public class FileUtil {

    private  static String fileUploadPath;

    private  static Boolean haveCreatePath = false;

    public static  String getFileUploadPath() {
        //如果没有写文件上传路径,保存到临时目录
        if (ToolUtils.isEmpty(fileUploadPath)) {
            return ToolUtils.getTempPath();
        } else {
            //判断有没有结尾符,没有得加上
            if (!fileUploadPath.endsWith(File.separator)) {
                fileUploadPath = fileUploadPath + File.separator;
            }
            //判断目录存不存在,不存在得加上
            if (!haveCreatePath) {
                File file = new File(fileUploadPath);
                file.mkdirs();
                haveCreatePath = true;
            }
            return fileUploadPath;

        }
    }

    /**
     * NIO way
     */
    public static byte[] toByteArray(String filename) throws CanteenException {

        File f = new File(filename);
        if (!f.exists()) {
            log.error("文件未找到！" + filename);
            throw CanteenException.FILE_NOT_FOUND_EXCEPTION;
        }
        FileChannel channel = null;
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(f);
            channel = fs.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            while ((channel.read(byteBuffer)) > 0) {
                // do nothing
                // System.out.println("reading");
            }
            return byteBuffer.array();
        } catch (IOException e) {
            throw CanteenException.FILE_READING_ERROR_EXCEPTION;
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                throw CanteenException.FILE_READING_ERROR_EXCEPTION;
            }
            try {
                fs.close();
            } catch (IOException e) {
                throw CanteenException.FILE_READING_ERROR_EXCEPTION;
            }
        }
    }

    /**
     * 删除目录
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}
