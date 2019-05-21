package com.automationpractice;

import java.util.concurrent.TimeUnit;

import com.automationpractice.utils.Browser;
import com.automationpractice.utils.BrowserFactory;
import com.automationpractice.utils.PageUrls;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class AddToCart {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
        if(driver !=null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void addToCartFirstProductOnPopularCategoryFirefox() {
        driver = BrowserFactory.GetBrowser(Browser.FIREFOX);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(PageUrls.getMainUrl());


    }

}
