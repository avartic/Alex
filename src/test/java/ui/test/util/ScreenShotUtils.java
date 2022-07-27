package ui.test.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static ui.test.util.Hooks.featureFileName;
import static ui.test.util.Hooks.scenarioName;


public final class ScreenShotUtils extends BasePage {


    final static String filePath = ".//target/cucumber-report/screenshots/";


    public static void takePageScreenshot(String imageName) throws IOException {
        File file = new File(String.valueOf(getFilePath(imageName)));
        createFolderAndSaveScreenshots(file);
    }

    public static void highlightAndTakeScreenshot(WebElement myAccount) throws IOException {
        String elementName = myAccount.getText();

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].style.border='2px solid red'", myAccount);

        File file = new File(String.valueOf(getFilePath(elementName)));
        createFolderAndSaveScreenshots(file);
    }

    private static void createFolderAndSaveScreenshots(File file) throws IOException {
        File fileDir = file.getParentFile();
        if (!fileDir.exists()) {
            System.out.println("File created " + file);
            fileDir.mkdir();

        }
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, file);
    }

    private static File getFilePath(String elementName) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Before Formatting: " + now);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH-mm-ss.SS");
        String formatDate = now.format(dateFormatter);
        String formatTime = now.format(timeFormatter);

        File file = new File(filePath + "/" + formatDate + "/" + featureFileName + "/" + scenarioName + "/" + formatTime + "-" + elementName + ".png");
        return file;
    }
}
