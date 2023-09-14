package com.study.test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Base64;

public class Base64Test {
    public static void main(String[] args) throws IOException {
        String str = "床前明月光，疑是地上霜。";
        byte[] bytes = str.getBytes();
        // 创建base64encoder实例
        BASE64Encoder base64Encoder = new BASE64Encoder();
        // 进行编码
        String encode = base64Encoder.encode(bytes);
        System.out.println(encode);

        // 创建base64decoder实例
        BASE64Decoder base64Decoder = new BASE64Decoder();
        // 进行解码
        byte[] content = base64Decoder.decodeBuffer(encode);
        System.out.println(new String(content,"UTF-8"));
    }
}
