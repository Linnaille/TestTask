package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    public String captureScreen() {
        String path;
        WebDriver driver = new ChromeDriver();
        try {
            WebDriver webDriver = new Augmenter().augment(driver);
            File source = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
            path = "./target/screenshots/" + source.getName();
            FileUtils.copyFile(source, new File(path));
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }

}
