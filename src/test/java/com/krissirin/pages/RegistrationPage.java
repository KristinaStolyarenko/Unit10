package com.krissirin.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.krissirin.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement formTitle = $(".practice-form-wrapper"),
                            firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            userEmailInput = $("#userEmail"),
                            genterWrapper = $("#genterWrapper"),
                            userNumber = $("#userNumber"),
                            subjects = $("#subjectsInput"),
                            hobbies = $("#hobbiesWrapper"),
                            picture = $("#uploadPicture"),
                            address = $("#currentAddress"),
                            city = $("#city"),
                            submit = $("#submit");
    public SelenideElement stateCity = $("#stateCity-wrapper");

    public CalendarComponent calendar = new CalendarComponent();

    public void openPage(){
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }
    public void typeFirstName(String value){
        firstNameInput.setValue(value);
    }
    public void typeLastName(String value){ lastNameInput.setValue(value); }
    public void typeEmail(String value) { userEmailInput.setValue(value); }
    public void chooseGender(String value) { genterWrapper.$(byText(value)).click();; }
    public void setNumber(String value) { userNumber.setValue(value); }
    public void setSubjects(String value) { subjects.setValue(value).pressEnter(); }
    public void chooseHobbies(String value) { hobbies.$(byText(value)).click();}
    public void uploadPicture(String value) {picture.uploadFromClasspath(value);}
    public void setAddress (String value) {address.setValue(value);}
    public void chooseStateCity (String value){
        stateCity.$(byText("Select State")).click();
        stateCity.$(byText(value)).click();
    }
    public void chooseCity (String value){
        city.$(byText("Select City")).click();
        city.$(byText(value)).click();
    }
    public void submitForm () {submit.click();}

    public void checkSubmittedForm(String fieldName, String fieldValue) {
        $x("//td[text()='" + fieldName + "']").sibling(0).shouldHave(exactText(fieldValue));
    }
}
