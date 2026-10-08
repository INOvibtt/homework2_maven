package com.example;

import com.google.gson.Gson;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Gson().toJson(Map.of("name", "Polina", "lastName", "Pashchenko")));
    }
}
