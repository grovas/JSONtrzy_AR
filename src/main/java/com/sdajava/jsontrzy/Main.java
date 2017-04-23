package com.sdajava.jsontrzy;

import com.sdajava.jsontrzy.utils.putJSONToCollection;

public class Main {

    public static void main(String[] args) {

        putJSONToCollection.readAndCollect()
                .stream().forEach(System.out::println);
    }
}
