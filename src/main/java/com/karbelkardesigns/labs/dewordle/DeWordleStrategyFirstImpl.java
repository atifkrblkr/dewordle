package com.karbelkardesigns.labs.dewordle;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DeWordleStrategyFirstImpl implements DeWordleStrategy{

    @Override
    public String random() {
        Random random = new Random();
        return Dictionary.instance.allWords.get(random.nextInt(Dictionary.instance.allWords.size()-1));
    }

    @Override
    public String suggest(String[] words) {
        return null;
    }
}
