package com.krissirin;

import com.krissirin.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationPracticeForm extends TestData {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void PositivePass() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(email);
        registrationPage.chooseGender(sex);
        registrationPage.setNumber(number);
        registrationPage.calendar.setDate("3","July","1993");
        registrationPage.setSubjects("Biology");
        registrationPage.chooseHobbies(hobbie);
        registrationPage.uploadPicture("001.jpeg");
        registrationPage.setAddress(address);
        registrationPage.stateCity.scrollIntoView(true);
        registrationPage.chooseStateCity(states.get(0));
        registrationPage.chooseCity(cities.get(0));
        registrationPage.submitForm();
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
    }
}
