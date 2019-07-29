package com.sumnear.utils;

/**
 * @authore sumnear
 * @create 2019-7-24 11:15
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 提供过滤，只转换JAVA文件
 * */
class JavaFileFilter implements FileFilter{

    public boolean accept(File pathname) {
        if(pathname.isDirectory()||pathname.getName().endsWith(".java"))
            return true;
        return false;
    }

}

public class GBKtoUTF8 {

    public void visit(File source,File dest){
        if(source.isDirectory()){//如果是目录，则在dest目录下创建相同的目录
            new File(dest.getAbsolutePath()+File.separator+source.getName()).mkdirs();

            File[] files=source.listFiles(new JavaFileFilter());
            for (File file : files) {
                visit(file,new File(dest.getAbsolutePath()+File.separator+source.getName()));
            }
        }else{
            //如果是文件，则进行转换
            transform(source,dest);
        }
    }
    public void transform(File source,File dest){
        try {
            BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(source),"GB2312"));
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(dest.getAbsolutePath()+File.separator+source.getName())),"utf-8"));
            String line=null;
            while((line=reader.readLine())!=null){
                writer.write(line+"\n");
            }
            reader.close();
            writer.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        new GBKtoUTF8().visit(new File("D:\\随书源码\\designPatternn"),new File("D:\\随书源码\\target"));
    }
}