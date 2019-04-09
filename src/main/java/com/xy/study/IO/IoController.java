package com.xy.study.IO;

import java.io.*;

public class IoController {

    public static final String directoryName = "io";

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/apple/Documents/学习资料/io/io-test.txt");
        if(!file.exists()){
            file.createNewFile();
        }

        // 字节流读写文件
        // 写入文件
//        OutputStream out = new FileOutputStream(file, true); // 文本内容是否能够追加
        OutputStream out = new FileOutputStream(file);
        String str = "it's ok !";
        out.write(str.getBytes());
        out.close();

        StringBuffer su = new StringBuffer();
        InputStream inputStream = new FileInputStream(file);
        //读取数据
        //一次性取多少字节
        byte[] by = new byte[2048];
        //接受读取的内容(n就代表的相关数据，只不过是数字的形式)
        int n = -1;
        //循环取出数据
        while ((n = inputStream.read(by,0,by.length)) != -1) {
            //转换成字符串
            su.append(new String(by,0,n,"GBK"));//这里可以实现字节到字符串的转换，比较实用
        }
        //关闭流
        inputStream.close();
        System.out.println(su.toString());


        //缓存方式进行读取
        StringBuffer stringBuffer = new StringBuffer();
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("/Users/apple/Documents/学习资料/io/io-test.txt"));
        //循环取出数据
        byte[] bytes = new byte[2];
        int len = -1;
        int time = 0;
        while ((len = in.read(bytes,0,bytes.length)) != -1){
            //转换成字符串
            String string = new String(bytes,0,len,"GBK"); //这里可以实现字节到字符串的转换，比较实用
            stringBuffer.append(string);

            time ++;
        }

        System.out.println("====" + stringBuffer.toString());
        System.out.println("====" + time);




    }

    /**
     * 判断是否为文件目录
     * @param fileName
     * @param file
     * @return
     */
    private static File isDirectory(String fileName,File file){
        File f = null;
        if(file.isDirectory()){
            File [] files = file.listFiles();
            for (File fi: files) {
                 if(fileName.equalsIgnoreCase(fi.getName())){
                    f = fi;
                    break;
                }
            }
        }else{
            f = file;
        }

        return f;
    }
}
