package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора кнопки маркета
     */
    @FindBy(css = "div.services-new__icon_market")
    private WebElement marketIcon;

    /**
     * метод для нажатия на иконку маркета
     */
    public void clickMarketIcon(){
        marketIcon.click();
    }


}