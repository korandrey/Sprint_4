package ru.services_praktikum.qa_scooter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    //URL для входа на сайт
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    //Все вопросы о важном
    private final By allQuestions = By.className("Home_FAQ__3uVm4");
    //Кнопка "Заказать" в хедере
    private final By orderButtonInHeader = By.xpath(".//div[@class='Header_Header__214zg']//button[contains(text(),'Заказать')]");
    //Кнопка заказать в футере
    private final By orderButtonInFooter = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button[contains(text(),'Заказать')]");

    public MainPage(WebDriver driver) {

        super(driver);
    }

    //кликаем на пункт выпадающего меню, где есть текст параметра
    public MainPage clickOnLineFromDropDownListWithText(String text) {
        //Пункт из выпадающего списка с вопросами
        By lineFromDropDownList = By.xpath(".//div[@class='Home_FAQ__3uVm4']//div[contains(text(),'" + text + "')]");
        driver.findElement(lineFromDropDownList).click();
        return this;
    }

    //проверка текста на отображение когда мы открылы пункт выпадающего меню
    public boolean checkTextInOpenParagraph(String textParagraphOpen) {
        //Текс который открывается когда нажимаешь на вопрос из выпадающего списка
        By openParagraph = By.xpath(".//div[@class='Home_FAQ__3uVm4']//p[contains(text(),'" + textParagraphOpen + "')]");
        return driver.findElement(openParagraph).isDisplayed();
    }

    //Скролл до местоположения вопросов, чтобы отображалось на странице
    public MainPage scrollToQuestions() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(allQuestions));
        return this;
    }

    public MainPage scrollToOrderButtonInFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButtonInFooter));
        return this;
    }

    public OrderPage clickOnButtonOrderInHeader() {
        driver.findElement(orderButtonInHeader).click();
        return new OrderPage(driver);
    }

    public OrderPage clickOnButtonOrderInFooter() {
        driver.findElement(orderButtonInFooter).click();
        return new OrderPage(driver);
    }
}
