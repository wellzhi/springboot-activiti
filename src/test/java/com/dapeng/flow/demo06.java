package com.dapeng.flow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

/**
 * 二、写出文件
 1、建立联系、File对象 目的地
 2、选择流    文件输出流   OutputStream   FileOutputStream
 3、操作：write()+flush()
 4、释放资源：关闭
 * @author zmx
 *
 */
public class demo06 {
    public static void main(String[] args) {
        File dest=new File("F:"+File.separator+"temp"+File.separator+"flow.png");
        OutputStream os=null;
        //以追加形式写出文件
        try {
            os=new FileOutputStream(dest,true);
            //3、操作
            String str="bjsxt is very good \r  \n";
            byte[] data=str.getBytes();
            os.write(data, 0, data.length);

            os.flush();//强制刷新出去
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("文件未找到");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("文件写出失败");
        }finally {
            if(null!=os){
                try {
                    os.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    System.out.println("关闭输出资源失败");
                }
            }
        }
    }

}


