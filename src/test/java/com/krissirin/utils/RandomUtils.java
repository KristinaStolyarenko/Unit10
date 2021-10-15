package com.krissirin.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static String getRandomPhone(){
        Long random_phone = ThreadLocalRandom.current().nextLong(111111111L, 999999999L);
        return "9" + random_phone.toString();
    }

    public static String getRandomHobbies(){
        Random rnd = new Random();
        List<String> hobbies = Arrays.asList("Reading","Sports","Music");
        Integer randomIndex = ThreadLocalRandom.current().nextInt(0, 2 + 1);
        return hobbies.get(randomIndex);
    }
}
