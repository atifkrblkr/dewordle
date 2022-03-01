package com.karbelkardesigns.labs.dewordle;

public interface DeWordleStrategy {
    String random();

    String suggest(String[] words);
}
