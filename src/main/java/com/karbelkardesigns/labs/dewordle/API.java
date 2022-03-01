package com.karbelkardesigns.labs.dewordle;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeMap;

@RestController
@RequestMapping(value = "/api")
public class API {

    private DeWordleStrategy deWordleStrategy;

    public API(DeWordleStrategy deWordleStrategy) {
        this.deWordleStrategy = deWordleStrategy;
    }

    @GetMapping(value = "/first")
    public String first() {
        return deWordleStrategy.random();
    }

    @GetMapping(value = "/next")
    public LinkedList<String> next(@RequestParam(required = false) Character[] _6,
                                   @RequestParam(required = false) Character[] _0,
                           @RequestParam(required = false) Character _1,
                           @RequestParam(required = false) Character _2,
                           @RequestParam(required = false) Character _3,
                           @RequestParam(required = false) Character _4,
                           @RequestParam(required = false) Character _5) {
        TreeMap<Integer,LinkedList<String>> rankedMatches = new TreeMap<>();
        for(String word : Dictionary.instance.allWords){
            int rank = 0;
            if(_1 != null && _1 == word.charAt(0)){
                rank++;
            }
            if(_2 != null && _2 == word.charAt(1)){
                rank++;
            }
            if(_3 != null && _3 == word.charAt(2)){
                rank++;
            }
            if(_4 != null && _4 == word.charAt(3)){
                rank++;
            }
            if(_5 != null && _5 == word.charAt(4)){
                rank++;
            }
            if(_0 != null){
                for(char c : _0){
                    if(word.contains(c+"")){
                        rank--;
                    }
                }
            }
            if(_6 != null){
                for(char c : _6){
                    if(word.contains(c+"")){
                        rank++;
                    }
                }
            }
            LinkedList<String> w;
            if(rankedMatches.containsKey(rank)){
                w = rankedMatches.get(rank);
            } else {
                w = new LinkedList<>();
            }
            w.push(word);
            rankedMatches.put(rank,w);
        }

        return rankedMatches.get(rankedMatches.lastKey());
    }
}
