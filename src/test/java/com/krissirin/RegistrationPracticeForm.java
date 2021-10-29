package com.krissirin;

import com.codeborne.selenide.Configuration;
import com.krissirin.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationPracticeForm extends TestData {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void PositivePass() {
        System.out.println(Configuration.remote);

        step("Открываем главную страницу", () -> {
            registrationPage.openPage();
        });
        step("Заполняем данные пользователя", () -> {
            registrationPage.typeFirstName(firstName);
            registrationPage.typeLastName(lastName);
            registrationPage.typeEmail(email);
            registrationPage.chooseGender(sex);
            registrationPage.setNumber(number);
        });
        step("Выбираем дату в календаре", () -> {
            registrationPage.calendar.setDate("3","July","1993");
        });
        step("Заполняем профиль и территориальные данные", () -> {
            registrationPage.setSubjects("Biology");
            registrationPage.chooseHobbies(hobbie);
            registrationPage.uploadPicture("001.jpeg");
            registrationPage.setAddress(address);
            registrationPage.stateCity.scrollIntoView(true);
            registrationPage.chooseStateCity(states.get(0));
            registrationPage.chooseCity(cities.get(0));
        });
        step("Отправляем форму", () -> {
            registrationPage.submitForm();
        });
        step("Проверяем заполненные данные", () -> {
            registrationPage.checkSubmittedForm("Student Name", firstName + " " + lastName);
            registrationPage.checkSubmittedForm("Student Email", email);
            registrationPage.checkSubmittedForm("Gender", sex);
            registrationPage.checkSubmittedForm("Mobile", number);
            registrationPage.checkSubmittedForm("Date of Birth", "03 July,1993");
            registrationPage.checkSubmittedForm("Subjects", "Biology");
            registrationPage.checkSubmittedForm("Hobbies", hobbie);
            registrationPage.checkSubmittedForm("Picture", "001.jpeg");
            registrationPage.checkSubmittedForm("Address", address);
            registrationPage.checkSubmittedForm("State and City", states.get(0) + " " + cities.get(0));
        });

    }
}
