package com.krissirin;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static com.krissirin.utils.RandomUtils.getRandomHobbies;
import static com.krissirin.utils.RandomUtils.getRandomPhone;

public class TestData {

   static Faker faker = new Faker();

    public static String
            firstName = "Kristina",
            lastName = "Still",
            email = faker.internet().emailAddress(),
            sex = faker.demographic().sex(),
            number = getRandomPhone(),
            hobbie = getRandomHobbies(),
            address = faker.address().fullAddress();

    public static List<String>
            states = Arrays.asList("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            cities = Arrays.asList("Delhi", "Agra", "Karnal", "Jaipur");
}
