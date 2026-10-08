package com.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void printsNameAsJson() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream previous = System.out;
        try {
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            Main.main(new String[0]);
        } finally {
            System.setOut(previous);
        }
        JsonObject json = JsonParser.parseString(output.toString(StandardCharsets.UTF_8).trim()).getAsJsonObject();
        assertEquals("Polina", json.get("name").getAsString());
        assertEquals("Pashchenko", json.get("lastName").getAsString());
        assertEquals(2, json.size());
    }
}
