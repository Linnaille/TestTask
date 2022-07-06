package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexMarket {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public YandexMarket(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определяем локатор поля ввода
     */
    @FindBy(css= "#header-search")
    private WebElement headerSearch;

    /**
     * определяем локатор второго варианта в попап подсказказ
     */
    @FindBy(css = "div.mini-suggest__popup ul li:nth-child(2)")
    private WebElement secondSuggestPopup;

    /**
     * определяем локатор цены первого товара
     */
    @FindBy(xpath = "//*[@class=\"dwAaA\"]/div/div/div/div/div[1]/div/div/div[1]/article/div[4]/div[3]/div/a/div/span/span[1]")
    private WebElement firstPrice;

    /**
     * метод для ввода запроса
     */
    public void inputRequest(String req) {
        headerSearch.sendKeys(req);
    }

    /**
     * метод для ввода запроса
     */
    public void clickSuggest() {
        secondSuggestPopup.click(); }

    /**
     * метод для получения цены первого товара
     */
    public String getPrice() {
        String price = firstPrice.getText();
        return price;
    }

}
