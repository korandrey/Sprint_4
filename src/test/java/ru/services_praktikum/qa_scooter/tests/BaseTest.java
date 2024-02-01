package ru.services_praktikum.qa_scooter.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.services_praktikum.qa_scooter.page.MainPage;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(MainPage.URL);
    }

    @After
    public void tearDown() {
        // Закрытие браузера
        driver.quit();
    }
}
