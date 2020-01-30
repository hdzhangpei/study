package com.zhangpei.study.base.qrRecognition;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RecognitionQr {

    public void saveToFile(String destUrl) {
        ByteOutputStream bos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        BufferedImage image;
        String content = null;
        URL url = null;
        int BUFFER_SIZE = 1024;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
        try {
            url = new URL(destUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            bos = new ByteOutputStream();
            while ((size = bis.read(buf)) != -1) {
                bos.write(buf, 0, size);
            }
            bos.flush();


            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bos.getBytes());//byte[] 转BufferedImage
            image = ImageIO.read(byteArrayInputStream);
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            // 解码设置编码方式为：utf-8，

            hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
            //优化精度
            hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            //复杂模式，开启PURE_BARCODE模式
            hints.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);//解码
            System.out.println("图片中内容：  ");
            System.out.println("content： " + result.getText());
            content = result.getText();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                bis.close();
                httpUrl.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

//        String url = "//img11.360buyimg.com/xstore/jfs/t1/73158/18/6697/51406/5d4bb9b9E9990d781/24208fd1207cc162.jpg";
        long startTime = System.currentTimeMillis();
        String url = "//img11.360buyimg.com/xstore/jfs/t1/71027/23/10853/234264/5d847f74E2f64950b/1b92344cb2533d66.jpg";
        RecognitionQr dw = new RecognitionQr();
        dw.saveToFile("http:" + url);

        System.out.println(System.currentTimeMillis() - startTime + "ms");
    }

}
