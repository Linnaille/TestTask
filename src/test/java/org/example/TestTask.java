package org.example;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestTask {
    public static SearchPage searchPage;
    public static YandexMarket yandexMarket;
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        yandexMarket = new YandexMarket(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на поисковую страницу из файла настроект
        driver.get(ConfProperties.getProperty("startpage")); }

    @Test
    public void testTask() throws IOException {
        //сохраняем количество вкладок
        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        //нажимаем на иконку маркета
        searchPage.clickMarketIcon();
        //переключаемся на новую вкладку
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        //вводим запрос в поле
        yandexMarket.inputRequest("белые кеды");
        //в попапе подсказок нажимаем на второй
        yandexMarket.clickSuggest();
        //делаем скриншот
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
        //выводим цену первого товара
        System.out.println(yandexMarket.getPrice());
    }

    /**
     * закрываем браузер
     */
    @AfterClass
    public static void tearDown() {
        driver.quit(); } }