package com.junitseleniumpr;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Tarayıcı penceresini tam ekran başlatır
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
