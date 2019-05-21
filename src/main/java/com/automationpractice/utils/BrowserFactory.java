package com.automationpractice.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import com.automationpractice.utils.Browser;

public class BrowserFactory {
    public static WebDriver GetBrowser(Browser browser) {

        switch (browser) {
            case FIREFOX:
                return getFirefoxInstance();
            case CHROME:
                return getChromeInstance();
            default:
                break;
        }
    }

    public static RemoteWebDriver GetRemoteBrowser(String browser) {
        DesiredCapabilities capabillities = null;
        RemoteWebDriver driver = null;


        switch (browser) {
        case "firefox":
            capabillities = DesiredCapabilities.firefox();
            break;
        default:
        }

        capabillities.setJavascriptEnabled(true);
        driver = new RemoteWebDriver(capabillities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    private static FirefoxDriver getFirefoxInstance() {
        return new FirefoxDriver();
    }

    private static ChromeDriver getChromeInstance() {
        System.setProperty("webdriver.chrome.driver", "resources//chromedriver");
        return new ChromeDriver();
    }
}


