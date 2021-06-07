package Test.Testing;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Helper {

    WebDriver driver;
    private final By cookieComplianceLayer = By.cssSelector("div[id='onetrust-banner-sdk']");
    private final By cookieComplianceAcceptButton = By.cssSelector("button[id='onetrust-accept-btn-handler']");
    final long seed = Math.abs(new Random().nextLong());

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public void handleCookieComplianceDialog() throws InterruptedException {
        if (!driver.findElement(cookieComplianceLayer).isDisplayed()) {
            return;
        }
        String display = driver.findElement(cookieComplianceLayer).getCssValue("display");

        if (display == null || !display.equals("none")) {
            driver.findElement(cookieComplianceAcceptButton).click();
            Thread.sleep(2000);
        }
    }

    public void waitSpinner() throws InterruptedException {
        int i = 0;
        while (i < 90) {
            if (isPresent(By.cssSelector(".backprocess"))) {
                System.out.println("spinner present");
                Thread.sleep(2000);
                i++;
            } else {
                Thread.sleep(2000);
                System.out.println("spinner ya no presente");
                Thread.sleep(2000);
                break;
            }
        }
        if (i == 90) {
            Assert.fail("Error, el cuadro de espera ha estado presente durante mas de 90 segundos");
        }
    }

    public void waitSpinnerPrecio() throws InterruptedException {
        int i = 0;
        while (i < 90) {
            if (isPresent(By.cssSelector("div[class='pasatiempos-caja']"))) {
                System.out.println("spinner present");
                Thread.sleep(2000);
                i++;
            } else {
                Thread.sleep(2000);
                System.out.println("spinner ya no presente");
                Thread.sleep(2000);
                break;
            }
        }
        if (i == 90) {
            Assert.fail("Error, el cuadro de espera ha estado presente durante mas de 90 segundos");
        }
    }

    public boolean isPresent(By locator) {
        boolean result = false;
        try {
            (new WebDriverWait(driver, 3L)).pollingEvery(Duration.ofMillis(500L)).until(ExpectedConditions.presenceOfElementLocated(locator));
            result = true;
        } catch (WebDriverException | NullPointerException var4) {
            String var10001 = var4.getMessage() != null && !var4.getMessage().isEmpty() ? ": " + var4.getMessage() : "";
        }
        return result;
    }

    public void waitForPageToLoad(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        System.out.println("Ya esta cargada");
    }

    public String randomEmail() {
        String email = RandomStringUtils.randomAlphabetic(8) + "@gmail.com";
        System.out.println("Produced random email: " + email);
        return email;
    }

    public String randomPhoneNumber() {
        long number = 600000000 + (seed % 200000000);
        String phone = String.valueOf(number);
        System.out.println("Produced random Mobile phone: " + phone);
        return phone;
    }
}
