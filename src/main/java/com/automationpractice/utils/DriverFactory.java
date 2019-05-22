package com.automationpractice.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    // chrome driver supplier
    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        Log.info(">>> Start Chrome driver. <<<");
        return new ChromeDriver();
    };

    // firefox driver supplier
    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        Log.info(">>> Start Firefox driver. <<<");
        return new FirefoxDriver();
    };

    /**
     * Add all the drivers into a map
     */
    static {
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
        driverMap.put(DriverType.FIREFOX, firefoxDriverSupplier);
    }

    /**
     * Return a new driver from the map
     * @param type
     * @return WebDriver
     */
    public static final WebDriver getDriver(DriverType type) {
        return driverMap.get(type).get();
    }
    
}
