package com.cloud.user.manager.base.until;

import java.security.MessageDigest;

/**
 * @author ：mmzs
 * @date ：Created in 2020/1/3 18:20
 * @description：md5加密算法
 * @modified By：
 * @version: 1$
 */
public class MD5Util {
    // 测试方法
    public static void main(String[] args) {
        MD5Util m=new MD5Util();
        m.getMD5("triplons33");
    }
    /**
     * 生成md5
     *
     * @param message
     * @return
     */
    public  String getMD5(String message) {
        String md5str = "";
        try {
            // 1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 2 将消息变成byte数组
            byte[] input = message.getBytes();
            // 3 计算后获得字节数组,这就是那128位了
            byte[] buff = md.digest(input);
            // 4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
            md5str = bytesToHex(buff);
            //System.out.println("加密前： " + message);
            //System.err.println("加密后： " + md5str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5str;
    }


    /**
     * 二进制转十六进制
     *
     * @param bytes
     * @return
     */
    public  String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();
        // 把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];
            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }
}
