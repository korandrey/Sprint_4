package ru.services_praktikum.qa_scooter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {
    //Поле Имя
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Поле Фамилия
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле Адрес:куда привезти
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле Станция метро
    private final By metroField = By.xpath(".//input[@placeholder='* Станция метро']");

    //Метро Сокольники
    private final By metroSokolniki = By.xpath(".//div[@class='select-search__select']//div[contains(text(),'Сокольники')]");

    //Поле Телефон: на него позвонит курьер
    private final By telephoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее в заказе
    private final By nextButton = By.xpath(".//button[contains(text(),'Далее')]");
    //Поле Когда привезти самокат
    private final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Число 12 в календаре
    private final By numberTwelveInCalendar = By.xpath(".//div[contains(text(),'12') and (@role='button')]");

    //Поле Срок аренды
    private final By rentalPeriodField = By.xpath(".//div[contains(text(),'Срок аренды')]");

    //Пункт Сутки в поле "Срок аренды" в разделе "Про аренду"
    private final By rentalPeriodDay = By.xpath(".//div[contains(text(),'сутки')]");

    //Чек-бокс Цвет самоката черный жемчук
    private final By colorScooterBlack = By.id("black");
    //Чек-бокс Цвет самоката серая безысходность
    private final By colorScooterGrey = By.id("grey");
    //Поле Комментарий для курьера
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка Заказать в заказе
    private final By orderInOrder = By.xpath("(.//button[contains(text(),'Заказать')])[2]");

    //Уведомление "Хотите оформить заказ?"
    private final By orderModal = By.className("Order_Modal__YZ-d3");


    public OrderPage(WebDriver driver) {
        super(driver);
    }

    //Заполнить поля в заказе в разделе "Для кого самокат"
    public OrderPage fillInFieldsOnFormForWhom(String name, String surname, String address, String telephone) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(telephoneField).sendKeys(telephone);
        return this;
    }

    //Выбрать станцию метро Сокольники в разделе "Для кого самокат"
    public OrderPage fillInMetroFieldSokolniki() {
        driver.findElement(metroField).click();
        driver.findElement(metroSokolniki).click();
        return this;
    }

    //Нажать на кнопку Далее
    public OrderPage clickOnButtonNext() {
        driver.findElement(nextButton).click();
        return this;
    }

    //Заполнить поле Дата и Комментарий в разделе "Про аренду"
    public OrderPage enterDateAndComment(String date, String comment) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(numberTwelveInCalendar).click();
        driver.findElement(commentField).sendKeys(comment);
        return this;
    }

    //Выбрать срок аренды = сутки в разделе "Про аренду"
    public OrderPage chooseDayRentalPeriod() {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(rentalPeriodDay).click();
        return this;
    }

    //Выбрать самокат черного цвета в разделе "Про аренду"
    public OrderPage chooseBlackScooter() {
        driver.findElement(colorScooterBlack).click();
        return this;
    }

    //Выбрать самокат серого цвета в разделе "Про аренду"
    public OrderPage chooseGreyScooter() {
        driver.findElement(colorScooterGrey).click();
        return this;
    }

    //Кликнуть на кнопку Заказать
    public OrderPage clickOnButtonOrder() {
        driver.findElement(orderInOrder).click();
        return this;
    }

    //Проверить,Что появилась модальное окно
    public boolean checkingOrderModal() {
        return driver.findElement(orderModal).isDisplayed();
    }
}
