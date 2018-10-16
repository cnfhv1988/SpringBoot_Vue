package cn.machao.persist.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

public class FileUtils {

    public static void upload(byte[] file, String filePath, String fileName) throws Exception{

        File dest = new File(filePath);
        if(!dest.exists()) {
            dest.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + "\\" + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public static String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static String generateNewFileName(String fileName) {
        return UUID.randomUUID().toString().replace("-", "") + "." + getSuffix(fileName);
    }
}
