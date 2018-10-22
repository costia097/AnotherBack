package com.domain.controllers;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.domain.entities.TestEntity;
import com.domain.services.TestService;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.BitSet;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping(value = "/test/abc" + ".mp3", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> test(HttpServletRequest request) throws IOException {
        System.out.println(request);
//        bytes=0-

        String range = request.getHeader("range");

        String bytesValue = range.substring(6, 7);

        File file = new File("D:/Океан Ельзи – Без бою.mp3");

        InputStream systemResourceAsStream = new FileInputStream(file);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int bufferSize =100;

        byte[] buffer = new byte[bufferSize];
//        while (systemResourceAsStream.read(buffer) != -1) {
//            byteArrayOutputStream.write(buffer);
//        }

        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        randomAccessFile.seek(1000);
        randomAccessFile.read(buffer);
        randomAccessFile.close();



        while (systemResourceAsStream.read(buffer, 0, bufferSize) != -1) {
            byteArrayOutputStream.write(buffer);
        }

        byteArrayOutputStream.flush();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Range", "bytes 0-10393324/10393324");
        headers.add("Content-Length", "10393324");

        return new ResponseEntity<>(byteArrayOutputStream.toByteArray(), headers, HttpStatus.PARTIAL_CONTENT);
    }
}
