package com.wanxi.demo0713;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class demo1 {
    public static void main(String[] args) {


        File source = new File("D:\\IdeaProjects\\demo0713\\src\\com\\wanxi\\demo0713\\text");
        File target = new File("D:\\IdeaProjects\\demo0713\\src\\com\\wanxi\\demo0713\\text");
        boolean copyReuslt = copyFile(source,target);
        System.out.println(copyReuslt);
    }

    /**
     * 字符流复制文件
     */
    public static boolean copyFile(File source, File target) {
        boolean isCopySuccess = false;
        if (!source.exists()) {
            return false;
        }
        try {
            if (!target.exists()) {
                File parentFile = target.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                target.createNewFile();
            }
            FileReader fileReader = new FileReader(source);
            FileWriter fileWriter = new FileWriter(target);
            char[] buffer = new char[1024];
            int size = 0;
            while ((size = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, size);
            }
            fileReader.close();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


}
