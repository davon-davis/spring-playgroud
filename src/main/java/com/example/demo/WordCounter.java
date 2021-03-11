package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class WordCounter {

    public Map<String, Integer> count(String str){
        str = str.replaceAll("\\p{Punct}","");
        String[] words = str.split(" ");
        Map<String, Integer> map = new HashMap<String, Integer>();

        int count = 0;
        for(String word: words){
            count = map.containsKey(word) ? map.get(word) : 0;
            map.put(word, ++count);
        }
        return map;
    }
}
