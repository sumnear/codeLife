package com.sumnear.test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @authore sumnear
 * @create 2019-8-28 17:42
 */
public class geekBangDownload
{
    /**
     * 从网络Url中下载文件
     *
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void downLoadFromUrl(String urlStr, String fileName, String savePath) throws IOException
    {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(5 * 1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);

        //文件保存位置
        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }
        File file = new File(saveDir + File.separator + fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if (fos != null) {
            fos.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }


        System.out.println("info:" + url + " download success");

    }


    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException
    {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    public static void main(String[] args)
    {
        try {

//            String baseUrl = "https://media001.geekbang" +
//                    ".org/95528eafdaa347d1aef3e3cdeeecb4b4/7fe52771f3264ea0a5ae827d1244c3e5-6b7a1c6fb0b7822806f1403d1f8cc479-sd-encrypt-stream-";
            String baseUrl = "https://res001.geekbang.org//media/audio/6f/0b/6f39e01ae78383a982af0d130dc2220b/ld/ld" +
                    "-";
            for (int i = 1; i < 55; i++) {
                String tempUrl;
                String name;
                if (i < 10) {
                    name = "0000" + i + ".ts";
                } else {
                    name = "000" + i + ".ts";
                }
                tempUrl = baseUrl + name;
                downLoadFromUrl(tempUrl,name, "E:\\data\\");
//                downLoadFromUrl(tempUrl,
//                        "7fe52771f3264ea0a5ae827d1244c3e5-6b7a1c6fb0b7822806f1403d1f8cc479-sd-encrypt-stream-" + name , "E:\\data\\");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


}
