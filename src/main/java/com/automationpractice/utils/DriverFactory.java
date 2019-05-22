package com.automationpractice.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    
    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    // Chrome supplier
    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        return new ChromeDriver();
    };

    // Firefox supplier
    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        // System.setProperty("webdriver.gecko.driver", "/Users/username/Downloads/geckodriver");
        return new FirefoxDriver();
    };


    // add all the drivers into a map
    static {
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
        driverMap.put(DriverType.FIREFOX, firefoxDriverSupplier);
    }

    // return a new driver from the map
    public static final WebDriver getDriver(DriverType type) {
        return driverMap.get(type).get();
    }
    
}
