package com.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtil {
    public static String getData(String url){

        //打开连接
        try {
            URL u = new URL(url);
            URLConnection con = u.openConnection();
            //获取输入流
            InputStream in = con.getInputStream();
            byte[] bs = new byte[1024];
            int count = 0;
            //in.read(bs) 每次从流里读取1024字节的数据
            StringBuilder sd = new StringBuilder();
            //没有读到数据返回-1
            while ((count = in.read(bs))!=-1) {
                //把读到的字节 转换为字符
                sd.append(new String(bs,0,count));
            }
            in.close();
            return sd.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
