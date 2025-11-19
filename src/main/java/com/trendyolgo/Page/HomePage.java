package com.trendyolgo.Page;

import com.trendyolgo.Base.BasePage;
import com.trendyolgo.Base.ConfigProperties;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Add New Addres
    private final By addNewAdress = By.xpath("//button[contains(text(),\"Yeni Adres Ekle\")]");
    private final By searchAdress = By.xpath("//input[@placeholder='Mahalle, sokak veya cadde ara']");
    private final By useLocationBtn = By.xpath("//button[contains(text(),'Bu Konumu Kullan')]");
    private final By houseNo = By.id(":ri:");
    private final By no = By.id(":rj:");
    private final By flat = By.id(":rk:");
    private final By adressTitle = By.id(":rl:");
    private final By name = By.id(":rn:");
    private final By surname = By.id(":ro:");
    private final By phone = By.id(":rp:");
    private final By submitButton = By.xpath("//button[contains(text(),'Kaydet')]");


    private final By searchFoodArea = By.xpath("//input[@class='outline-none w-full py-3 px-4 bg-transparent border-none']");
    private final By aboveFourPointsFilter = By.xpath("//div[@role='group']//button[contains(., '4 Puan ve Üzeri')]");
    private final By deliveryWithGoFilter = By.xpath("//div[@role='group']//button[contains(., 'Go ile Teslimat')]");
    private final By openRestaurantsFilter = By.xpath("//div[@role='group']//button[contains(., 'Açık Restoranlar')]");
    private final By paymentFilter = By.xpath("//label[contains(., 'Banka & Kredi Kartı')]");

    public void setAddNewLocation() {
        click(addNewAdress);
        waitElementVisibility(searchAdress);
        setText(searchAdress, ConfigProperties.getProperty("adress"));
        enter(searchAdress);
        waitElementClickable(useLocationBtn);
        click(useLocationBtn);
    }

    public void setAddNewAdress() {
        waitElementVisibility(houseNo);
        setText(houseNo, ConfigProperties.getProperty("houseNo"));
        setText(no, ConfigProperties.getProperty("no"));
        setText(flat, ConfigProperties.getProperty("flat"));
        setText(adressTitle, ConfigProperties.getProperty("adressTitle"));
        setText(name, ConfigProperties.getProperty("name"));
        setText(surname, ConfigProperties.getProperty("surname"));
        setText(phone, ConfigProperties.getProperty("phone"));
        setText(submitButton, "Kaydet");
    }

    public void searchFood() {
        click(searchFoodArea);
        setText(searchFoodArea, ConfigProperties.getProperty("searchedFood"));
        click(searchFoodArea);
        waitElementVisibility(aboveFourPointsFilter);
    }

    public void setFilters() {
        click(aboveFourPointsFilter);
        click(deliveryWithGoFilter);
        click(openRestaurantsFilter);
        click(paymentFilter);
    }

    public boolean isDisplayed() {
        return isPageDisplayed(addNewAdress);
    }






}
