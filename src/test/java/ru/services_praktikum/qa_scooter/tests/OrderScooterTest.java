package ru.services_praktikum.qa_scooter.tests;

import org.junit.Test;
import ru.services_praktikum.qa_scooter.page.MainPage;

import static org.junit.Assert.assertTrue;

public class OrderScooterTest extends BaseTest {
    //Тестовые данные
    final String name = "Андрей";
    final String surname = "Коршунов";
    final String address = "Иннополис";
    final String telephone = "89655023872";
    final String date = "31.12.24";
    final String comment = "Хорошей дороги";

    @Test
    public void orderScooterAndGetModalWindowButtonHeader() {
        boolean isModalDisplayed = new MainPage(driver)
                .clickOnButtonOrderInHeader()
                .fillInFieldsOnFormForWhom(name, surname, address, telephone)
                .fillInMetroFieldSokolniki()
                .clickOnButtonNext()
                .enterDateAndComment(date, comment)
                .chooseDayRentalPeriod()
                .chooseBlackScooter()
                .clickOnButtonOrder()
                .checkingOrderModal();

        assertTrue(isModalDisplayed);
    }

    @Test
    public void orderScooterAndGetModalWindowButtonFooter() {
        boolean isModalDisplayed = new MainPage(driver)
                .scrollToOrderButtonInFooter()
                .clickOnButtonOrderInFooter()
                .fillInFieldsOnFormForWhom(name, surname, address, telephone)
                .fillInMetroFieldSokolniki()
                .clickOnButtonNext()
                .enterDateAndComment(date, comment)
                .chooseDayRentalPeriod()
                .chooseBlackScooter()
                .clickOnButtonOrder()
                .checkingOrderModal();

        assertTrue(isModalDisplayed);
    }
}
