package com.automationpractice.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {
    private WebDriver driver;
    private WebDriverWait wait;
    private int timeout = 15;
    private String pageText = "You must register at least one phone number";
    private String formOk = "required form-group form-ok";

    // Register new user elements
    @FindBy(id = "SubmitCreate")
    @CacheLookup
    private WebElement createAnAccount;

    @FindBy(name = "id_gender")
    @CacheLookup
    private List<WebElement> mr;

    private final String mrValue = "1";

    @FindBy(name = "id_gender")
    @CacheLookup
    private List<WebElement> mrs;

    private final String mrsValue = "2";

    @FindBy(id = "customer_firstname")
    @CacheLookup
    private WebElement firstName;

    @FindBy(xpath = "//*[@id='account-creation_form']/div[1]/div[2]")
    private WebElement firstNameValidation;

    @FindBy(xpath = "//*[@id='account-creation_form']/div[1]/div[3]")
    private WebElement lastNameValidation;

    @FindBy(id = "customer_lastname")
    @CacheLookup
    private WebElement lastName;

    @FindBy(id = "submitAccount")
    @CacheLookup
    private WebElement register;

    @FindBy(id = "email")
    @CacheLookup
    private WebElement email;

    @FindBy(id = "passwd")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "days")
    @CacheLookup
    private WebElement days;

    @FindBy(id = "months")
    @CacheLookup
    private WebElement months;

    @FindBy(id = "years")
    @CacheLookup
    private WebElement year;

    @FindBy(id = "newsletter")
    @CacheLookup
    private WebElement signUpForOurNewsletter;

    @FindBy(id = "optin")
    @CacheLookup
    private WebElement receiveSpecialOffersFromOurPartners;

    @FindBy(id = "address1")
    @CacheLookup
    private WebElement addressLine1;

    @FindBy(id = "address2")
    @CacheLookup
    private WebElement addressLine2;

    @FindBy(id = "city")
    @CacheLookup
    private WebElement city;

    @FindBy(id = "id_state")
    @CacheLookup
    private WebElement state;

    @FindBy(id = "postcode")
    @CacheLookup
    private WebElement zippostalCode;

    @FindBy(id = "id_country")
    @CacheLookup
    private WebElement country;

    @FindBy(id = "phone_mobile")
    @CacheLookup
    private WebElement mobilePhone;

    // Constructors
    public CreateAccount() {
    }

    public CreateAccount(WebDriver driver) {
        this();
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    // Methods

    /**
     * Set First Name text field
     * @param name
     * @return same
     */
    public CreateAccount setFirstName(String name) {
        firstName.sendKeys(name);
        return this;
    }

    /**
     * Get First Name text field
     *
     * @param name
     * @return text field value
     */
    public String getFirstName() {
        return firstName.getAttribute("value");
    }

    /**
     * Set Last Name text field
     * @param name
     * @return same
     */
    public CreateAccount setLastName(String nameValue) {
        lastName.sendKeys(nameValue);
        return this;
    }

    /**
     * Get Last Name text field
     * @param name
     * @return text field value
     */
    public String getLastName() {
        return lastName.getAttribute("value");
    }

    /**
     * Set value to Email Text field.
     *
     * @return the CreateAccount class instance.
     */
    public CreateAccount setEmailAddress(String emailValue) {
        email.sendKeys(emailValue);
        return this;
    }

    /**
     * Set value to Password Password field.
     *
     * @return the Validatation class instance.
     */
    public CreateAccount setPassword(String passwordValue) {
        password.sendKeys(passwordValue);
        return this;
    }

    /**
     * Set value to Mobile Phone Text field.
     *
     * @return the CreateAccount class instance.
     */
    public CreateAccount setMobilePhone(String mobilePhoneValue) {
        mobilePhone.sendKeys(mobilePhoneValue);
        return this;
    }

    /**
     * Set default value to Mrs. Radio Button field.
     *
     * @return the SignInPage class instance.
     */
    public CreateAccount setMrsRadioButtonField() {
        for (WebElement el : mrs) {
            if (el.getAttribute("value").equals(mrsValue)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set default value to Mr. Radio Button field.
     *
     * @return the SignInPage class instance.
     */
    public CreateAccount setMrRadioButtonField() {
        for (WebElement el : mr) {
            if (el.getAttribute("value").equals(mrValue)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    /**
     * Set day to in Date Of Birth Drop Down List field.
     *
     * @return the CreateAccount class instance.
     */
    public CreateAccount selectDayOfBirth(String dayDate) {
        new Select(days).selectByValue(dayDate);
        return this;
    }

    /**
     * Set month to Date Of Birth Drop Down List field.
     *
     * @return the CreateAccount class instance.
     */
    public CreateAccount selectMonthOfBirth(String monthDate) {
        new Select(months).selectByValue(monthDate);
        return this;
    }

    /**
     * Set value to Date Of Birth Drop Down List field.
     *
     * @return the CreateAccount class instance.
     */
    public CreateAccount selectYearOfBirth(String yearDate) {
        new Select(year).selectByValue(yearDate);
        return this;
    }

    /**
     * Click on Create An Account Button.
     *
     * @return the SignInPage class instance.
     */
    public CreateAccount clickCreateAnAccountButton() {
        createAnAccount.click();
        return this;
    }

    /**
     * Set value to Address Text field.
     *
     * @return the CreateAccount class instance.
     */
    public CreateAccount setAddress(String addressValue) {
        addressLine1.sendKeys(addressValue);
        return this;
    }

    /**
     * Get value to Address Text field.
     *
     * @return the CreateAccount class instance.
     */
    public String getAddress() {
        return addressLine1.getAttribute("value");
    }

    /**
     * Set value to State Drop Down List field.
     *
     * @return the CreateAccount class instance.
     */
    public CreateAccount setState(String stateValue) {
        new Select(state).selectByVisibleText(stateValue);
        return this;
    }

    /**
     * Set value to Zippostal Code Text field.
     *
     * @return the CreateAccount class instance.
     */
    public CreateAccount setZippostalCodeTextField(String zippostalCodeValue) {
        zippostalCode.sendKeys(zippostalCodeValue);
        return this;
    }

    /**
     * Set value to Address (Line 2) Text field.
     *
     * @return the CreateAccount class instance.
     */
    public CreateAccount setAddressLine2(String addressValue) {
        addressLine2.sendKeys(addressValue);
        return this;
    }

    /**
     * Set value to Country Drop Down List field.
     *
     * @return the CreateAccount class instance.
     */
    public CreateAccount setCountry(String countryValue) {
        new Select(country).selectByVisibleText(countryValue);
        return this;
    }

    /**
     * Set value to City Text field.
     *
     * @return the CreateAccount class instance.
     */
    public CreateAccount setCity(String cityValue) {
        city.sendKeys(cityValue);
        return this;
    }

    /**
     * Set Sign Up For Our Newsletter Checkbox field.
     *
     * @return the CreateAccount class instance.
     */
    public CreateAccount setSignUpForOurNewsletter() {
        if (!signUpForOurNewsletter.isSelected()) {
            signUpForOurNewsletter.click();
        }
        return this;
    }

    /**
     * Set Receive Special Offers From Our Partners Checkbox field.
     *
     * @return the CreateAccount class instance.
     */
    public CreateAccount setReceiveSpecialOffersFromOurPartners() {
        if (!receiveSpecialOffersFromOurPartners.isSelected()) {
            receiveSpecialOffersFromOurPartners.click();
        }
        return this;
    }

    /**
     * Validate First Name input field
     * @return bool
     */
    public boolean validateFirstNameField() {
        String  required = firstNameValidation.getAttribute("class");
        if (required.equals(formOk)) {
            return true;
        }
        return false;
    }

    /**
     * Validate Last Name form field
     * @return bool
     */
    public boolean validateLastNameField() {
        String  required = lastNameValidation.getAttribute("class");
        if (required.equals(formOk)) {
            return true;
        }
        return false;
    }

    /**
     * Validate First and Last name
     * @return bool
     */
    public boolean validateNamesFields() {
        boolean firstName = validateFirstNameField();
        boolean lastName = validateLastNameField();
        if (firstName && lastName) {
            return true;
        }
        return false;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return true/false
     */
    public CreateAccount verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageText);
            }
        });
        return this;
    }
}
