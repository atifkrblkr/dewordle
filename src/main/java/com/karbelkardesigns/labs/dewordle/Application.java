package com.karbelkardesigns.labs.dewordle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(ResourceUtils.getFile("classpath:words.txt")))){
            Dictionary.instance.allWords.addAll(br.lines().filter(word -> word.length() == 5).collect(Collectors.toList()));
        }
        SpringApplication.run(Application.class, args);
    }
}
