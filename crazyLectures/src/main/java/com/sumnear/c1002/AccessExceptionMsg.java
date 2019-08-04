package com.sumnear.c1002;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class AccessExceptionMsg
{
    public static void main(String[] args)
    {
        try
        {
            URL path = AccessExceptionMsg.class.getResource("/");
            System.out.println(path.getPath());
            FileInputStream fis = new FileInputStream(path.getPath()+"a.txt");
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }
}
