package chapter_16;

import java.util.HashMap;

public class TestMap {
    public static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<String, Integer>();

        scores.put("Ketty", 42);
        scores.put("Bert", 342);
        scores.put("Skailer", 420);

        System.out.println(scores);
        System.out.println(scores.get("Bert"));

    }
}
