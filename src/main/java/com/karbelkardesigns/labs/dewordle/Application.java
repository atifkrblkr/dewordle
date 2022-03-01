package com.karbelkardesigns.labs.dewordle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {
        ClassPathResource r = new ClassPathResource("words.txt");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(r.getInputStream()))) {
            Dictionary.instance.allWords.addAll(br.lines().filter(word -> word.length() == 5).collect(Collectors.toList()));
        }
        SpringApplication.run(Application.class, args);
    }
}
