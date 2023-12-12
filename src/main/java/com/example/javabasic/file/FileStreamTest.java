package com.example.javabasic.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest {
    public static void main(String[] args) {
        // 复制一份图片
        File srcFile = new File("src\\main\\java\\com\\example\\javabasic\\file\\playgirl.jpg");
        File destFile = new File("src\\main\\java\\com\\example\\javabasic\\file\\playgirl_file_stream.jpg");

        try (FileInputStream srcFileInputStream = new FileInputStream(srcFile);
             FileOutputStream destFileOutputStream = new FileOutputStream(destFile)) {

            byte[] buffer = new byte[1024];
            int len = srcFileInputStream.read(buffer);
            while (len != -1) {
                destFileOutputStream.write(buffer, 0, len);
                len =  srcFileInputStream.read(buffer);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
