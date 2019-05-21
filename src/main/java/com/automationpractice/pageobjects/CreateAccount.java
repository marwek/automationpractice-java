package com.automationpractice.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CreateAccount {
    private String pageText = "You must register at least one phone number";

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

    public CreateAccount() {
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
    public SignInPage setMrRadioButtonField() {
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
     * Click on Create An Account Button.
     *
     * @return the SignInPage class instance.
     */
    public CreateAccount clickCreateAnAccountButton() {
        createAnAccount.click();
        return this;
    }
}
