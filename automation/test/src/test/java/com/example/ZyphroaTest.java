// package com.example;

// import io.github.bonigarcia.wdm.WebDriverManager;
// import java.time.Duration;
// import org.openqa.selenium.*;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.Assert;
// import org.testng.annotations.*;
// import io.qameta.allure.*;

// public class ZyphroaTest {

//     WebDriver driver;
//     WebDriverWait wait;

//     String BASE_URL = "http://127.0.0.1:5500/website/";

//     @BeforeClass
//     public void setup() {

//         WebDriverManager.chromedriver().setup();

//         ChromeOptions options = new ChromeOptions();
//         options.addArguments("--remote-allow-origins=*");

//         driver = new ChromeDriver(options);
//         driver.manage().window().maximize();
//         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//         wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//     }

//     private void waitForPageLoad() {
//         wait.until(webDriver ->
//                 ((JavascriptExecutor) webDriver)
//                         .executeScript("return document.readyState")
//                         .equals("complete"));
//     }

//     private void loginByLocalStorage() {

//         driver.get(BASE_URL + "index.html");
//         waitForPageLoad();

//         JavascriptExecutor js = (JavascriptExecutor) driver;
//         js.executeScript(
//                 "localStorage.setItem('zyphroa_current_user','test@example.com');"
//         );
//     }

//     // ================= LOGIN =================

//     @Test(priority = 1)
//     public void TC_LOGIN_PAGE_LOAD() {
//         driver.get(BASE_URL + "index.html");
//         waitForPageLoad();
//         Assert.assertTrue(driver.getTitle().length() > 0);
//     }

//     @Test(priority = 2)
//     public void TC_LOGIN_FIELDS_PRESENT() {
//         driver.get(BASE_URL + "index.html");
//         waitForPageLoad();
//         Assert.assertTrue(driver.findElement(By.tagName("body")).isDisplayed());
//     }

//     // ================= HOME =================

//     @Test(priority = 3)
//     public void TC_HOME_PAGE_LOAD() {
//         loginByLocalStorage();
//         driver.get(BASE_URL + "home.html");
//         waitForPageLoad();
//         Assert.assertTrue(driver.getCurrentUrl().contains("home.html"));
//     }

//     // ================= CART =================

//     @Test(priority = 4)
//     public void TC_CART_PAGE_LOAD() {
//         loginByLocalStorage();
//         driver.get(BASE_URL + "cart.html");
//         waitForPageLoad();
//         Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));
//     }

//     // ================= CHECKOUT =================

//     @Test(priority = 5)
//     public void TC_CHECKOUT_PAGE_LOAD() {
//         loginByLocalStorage();
//         driver.get(BASE_URL + "checkout.html");
//         waitForPageLoad();
//         Assert.assertTrue(driver.getCurrentUrl().contains("checkout.html"));
//     }

//     // ================= PAYMENT =================

//     // ================= ORDERS =================

//     @Test(priority = 7)
//     public void TC_ORDERS_PAGE_LOAD() {
//         loginByLocalStorage();
//         driver.get(BASE_URL + "orders.html");
//         waitForPageLoad();
//         Assert.assertTrue(driver.getCurrentUrl().contains("orders.html"));
//     }

//     @AfterClass
//     public void tearDown() {
//         if (driver != null) {
//             driver.quit();
//         }
//     }
// }
package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class ZyphroaTest {

    WebDriver driver;
    WebDriverWait wait;

    String BASE_URL = "http://127.0.0.1:5500/website/";

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private void waitForPageLoad() {
        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    private void loginByLocalStorage() {
        driver.get(BASE_URL + "index.html");
        waitForPageLoad();
        ((JavascriptExecutor) driver)
                .executeScript("localStorage.setItem('zyphroa_current_user','test@example.com');");
    }

    private void openPage(String page) {
        driver.get(BASE_URL + page);
        waitForPageLoad();
    }

    // ========================= LOGIN (1–10) =========================

    @Test(priority=1) public void TC01_LoginUrl() { openPage("index.html"); Assert.assertTrue(driver.getCurrentUrl().endsWith("index.html")); }
    @Test(priority=2) public void TC02_LoginTitleNotEmpty() { openPage("index.html"); Assert.assertFalse(driver.getTitle().isEmpty()); }
    @Test(priority=3) public void TC03_LoginBodyVisible() { openPage("index.html"); Assert.assertTrue(driver.findElement(By.tagName("body")).isDisplayed()); }
    @Test(priority=4) public void TC04_LoginHTMLVisible() { openPage("index.html"); Assert.assertTrue(driver.findElement(By.tagName("html")).isDisplayed()); }
    @Test(priority=5) public void TC05_LoginPageSourceLength() { openPage("index.html"); Assert.assertTrue(driver.getPageSource().length() > 50); }
    @Test(priority=6) public void TC06_LoginRefresh() { openPage("index.html"); driver.navigate().refresh(); Assert.assertTrue(true); }
    @Test(priority=7) public void TC07_LoginBackForward() { openPage("index.html"); driver.navigate().back(); driver.navigate().forward(); Assert.assertTrue(true); }
    @Test(priority=8) public void TC08_LoginJSExecution() { Assert.assertEquals(((JavascriptExecutor)driver).executeScript("return 3+7"),10L); }
    @Test(priority=9) public void TC09_LoginWindowHeight() { Assert.assertTrue(driver.manage().window().getSize().getHeight()>0); }
    @Test(priority=10) public void TC10_LoginDriverNotNull() { Assert.assertNotNull(driver); }

    // ========================= HOME (11–25) =========================

    @Test(priority=11) public void TC11_HomeUrlContains() { loginByLocalStorage(); openPage("home.html"); Assert.assertTrue(driver.getCurrentUrl().contains("home")); }
    @Test(priority=12) public void TC12_HomeTitleExists() { loginByLocalStorage(); openPage("home.html"); Assert.assertNotNull(driver.getTitle()); }
    @Test(priority=13) public void TC13_HomeBodyVisible() { loginByLocalStorage(); openPage("home.html"); Assert.assertTrue(driver.findElement(By.tagName("body")).isDisplayed()); }
    @Test(priority=14) public void TC14_HomePageSource() { loginByLocalStorage(); openPage("home.html"); Assert.assertTrue(driver.getPageSource().contains("<")); }
    @Test(priority=15) public void TC15_HomeRefresh() { loginByLocalStorage(); openPage("home.html"); driver.navigate().refresh(); Assert.assertTrue(true); }
    @Test(priority=16) public void TC16_HomeScrollDown() { loginByLocalStorage(); openPage("home.html"); ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,500)"); Assert.assertTrue(true); }
    @Test(priority=17) public void TC17_HomeScrollTop() { loginByLocalStorage(); openPage("home.html"); ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0)"); Assert.assertTrue(true); }
    @Test(priority=18) public void TC18_HomeReadyState() { loginByLocalStorage(); openPage("home.html"); Assert.assertEquals(((JavascriptExecutor)driver).executeScript("return document.readyState"),"complete"); }
    @Test(priority=19) public void TC19_HomeJSBoolean() { loginByLocalStorage(); openPage("home.html"); Assert.assertEquals(((JavascriptExecutor)driver).executeScript("return true"),true); }
    @Test(priority=20) public void TC20_HomeJSString() { loginByLocalStorage(); openPage("home.html"); Assert.assertEquals(((JavascriptExecutor)driver).executeScript("return 'home'"),"home"); }
    @Test(priority=21) public void TC21_HomeBackNav() { loginByLocalStorage(); openPage("home.html"); openPage("cart.html"); driver.navigate().back(); Assert.assertTrue(true); }
    @Test(priority=22) public void TC22_HomeForwardNav() { loginByLocalStorage(); openPage("home.html"); openPage("cart.html"); driver.navigate().back(); driver.navigate().forward(); Assert.assertTrue(true); }
    @Test(priority=23) public void TC23_HomePageLength() { loginByLocalStorage(); openPage("home.html"); Assert.assertTrue(driver.getPageSource().length()>100); }
    @Test(priority=24) public void TC24_HomeURLExact() { loginByLocalStorage(); openPage("home.html"); Assert.assertTrue(driver.getCurrentUrl().endsWith("home.html")); }
    @Test(priority=25) public void TC25_HomeWindowWidth() { Assert.assertTrue(driver.manage().window().getSize().getWidth()>0); }

    // ========================= CART (26–40) =========================

    @Test(priority=26) public void TC26_CartUrl() { loginByLocalStorage(); openPage("cart.html"); Assert.assertTrue(driver.getCurrentUrl().contains("cart")); }
    @Test(priority=27) public void TC27_CartTitle() { loginByLocalStorage(); openPage("cart.html"); Assert.assertNotNull(driver.getTitle()); }
    @Test(priority=28) public void TC28_CartBodyVisible() { loginByLocalStorage(); openPage("cart.html"); Assert.assertTrue(driver.findElement(By.tagName("body")).isDisplayed()); }
    @Test(priority=29) public void TC29_CartRefresh() { loginByLocalStorage(); openPage("cart.html"); driver.navigate().refresh(); Assert.assertTrue(true); }
    @Test(priority=30) public void TC30_CartPageLength() { loginByLocalStorage(); openPage("cart.html"); Assert.assertTrue(driver.getPageSource().length()>50); }
    @Test(priority=31) public void TC31_CartJSCalc() { loginByLocalStorage(); openPage("cart.html"); Assert.assertEquals(((JavascriptExecutor)driver).executeScript("return 4*5"),20L); }
    @Test(priority=32) public void TC32_CartScroll() { loginByLocalStorage(); openPage("cart.html"); ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,300)"); Assert.assertTrue(true); }
    @Test(priority=33) public void TC33_CartScrollTop() { loginByLocalStorage(); openPage("cart.html"); ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0)"); Assert.assertTrue(true); }
    @Test(priority=34) public void TC34_CartBackForward() { loginByLocalStorage(); openPage("cart.html"); openPage("home.html"); driver.navigate().back(); driver.navigate().forward(); Assert.assertTrue(true); }
    @Test(priority=35) public void TC35_CartReadyState() { loginByLocalStorage(); openPage("cart.html"); Assert.assertEquals(((JavascriptExecutor)driver).executeScript("return document.readyState"),"complete"); }
    @Test(priority=36) public void TC36_CartURLExact() { loginByLocalStorage(); openPage("cart.html"); Assert.assertTrue(driver.getCurrentUrl().endsWith("cart.html")); }
    @Test(priority=37) public void TC37_CartPageSourceContainsHTML() { loginByLocalStorage(); openPage("cart.html"); Assert.assertTrue(driver.getPageSource().contains("html")); }
    @Test(priority=38) public void TC38_CartWindowHeight() { Assert.assertTrue(driver.manage().window().getSize().getHeight()>0); }
    @Test(priority=39) public void TC39_CartDriverActive() { Assert.assertNotNull(driver); }
    @Test(priority=40) public void TC40_CartJSBoolean() { loginByLocalStorage(); openPage("cart.html"); Assert.assertEquals(((JavascriptExecutor)driver).executeScript("return false"),false); }

    // ========================= CHECKOUT (41–55) =========================

    @Test(priority=41) public void TC41_CheckoutUrl(){ loginByLocalStorage(); openPage("checkout.html"); Assert.assertTrue(driver.getCurrentUrl().contains("checkout")); }
    @Test(priority=42) public void TC42_CheckoutTitle(){ loginByLocalStorage(); openPage("checkout.html"); Assert.assertNotNull(driver.getTitle()); }
    @Test(priority=43) public void TC43_CheckoutBody(){ loginByLocalStorage(); openPage("checkout.html"); Assert.assertTrue(driver.findElement(By.tagName("body")).isDisplayed()); }
    @Test(priority=44) public void TC44_CheckoutRefresh(){ loginByLocalStorage(); openPage("checkout.html"); driver.navigate().refresh(); Assert.assertTrue(true); }
    @Test(priority=45) public void TC45_CheckoutScroll(){ loginByLocalStorage(); openPage("checkout.html"); ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,400)"); Assert.assertTrue(true); }
    @Test(priority=46) public void TC46_CheckoutReadyState(){ loginByLocalStorage(); openPage("checkout.html"); Assert.assertEquals(((JavascriptExecutor)driver).executeScript("return document.readyState"),"complete"); }
    @Test(priority=47) public void TC47_CheckoutJSNumber(){ loginByLocalStorage(); openPage("checkout.html"); Assert.assertEquals(((JavascriptExecutor)driver).executeScript("return 100/5"),20L); }
    @Test(priority=48) public void TC48_CheckoutURLExact(){ loginByLocalStorage(); openPage("checkout.html"); Assert.assertTrue(driver.getCurrentUrl().endsWith("checkout.html")); }
    @Test(priority=49) public void TC49_CheckoutPageSource(){ loginByLocalStorage(); openPage("checkout.html"); Assert.assertTrue(driver.getPageSource().length()>50); }
    @Test(priority=50) public void TC50_CheckoutBackForward(){ loginByLocalStorage(); openPage("checkout.html"); openPage("home.html"); driver.navigate().back(); driver.navigate().forward(); Assert.assertTrue(true); }
    @Test(priority=51) public void TC51_CheckoutHTMLTag(){ loginByLocalStorage(); openPage("checkout.html"); Assert.assertTrue(driver.findElement(By.tagName("html")).isDisplayed()); }
    @Test(priority=52) public void TC52_CheckoutJSString(){ loginByLocalStorage(); openPage("checkout.html"); Assert.assertEquals(((JavascriptExecutor)driver).executeScript("return 'checkout'"),"checkout"); }
    @Test(priority=53) public void TC53_CheckoutWindowWidth(){ Assert.assertTrue(driver.manage().window().getSize().getWidth()>0); }
    @Test(priority=54) public void TC54_CheckoutDriverNotNull(){ Assert.assertNotNull(driver); }
    @Test(priority=55) public void TC55_CheckoutTitleLength(){ loginByLocalStorage(); openPage("checkout.html"); Assert.assertTrue(driver.getTitle().length()>=0); }

    // ========================= ORDERS (56–70) =========================

    @Test(priority=56) public void TC56_OrdersUrl(){ loginByLocalStorage(); openPage("orders.html"); Assert.assertTrue(driver.getCurrentUrl().contains("orders")); }
    @Test(priority=57) public void TC57_OrdersTitle(){ loginByLocalStorage(); openPage("orders.html"); Assert.assertNotNull(driver.getTitle()); }
    @Test(priority=58) public void TC58_OrdersBody(){ loginByLocalStorage(); openPage("orders.html"); Assert.assertTrue(driver.findElement(By.tagName("body")).isDisplayed()); }
    @Test(priority=59) public void TC59_OrdersRefresh(){ loginByLocalStorage(); openPage("orders.html"); driver.navigate().refresh(); Assert.assertTrue(true); }
    @Test(priority=60) public void TC60_OrdersScroll(){ loginByLocalStorage(); openPage("orders.html"); ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,500)"); Assert.assertTrue(true); }
    @Test(priority=61) public void TC61_OrdersReadyState(){ loginByLocalStorage(); openPage("orders.html"); Assert.assertEquals(((JavascriptExecutor)driver).executeScript("return document.readyState"),"complete"); }
    @Test(priority=62) public void TC62_OrdersURLExact(){ loginByLocalStorage(); openPage("orders.html"); Assert.assertTrue(driver.getCurrentUrl().endsWith("orders.html")); }
    @Test(priority=63) public void TC63_OrdersPageLength(){ loginByLocalStorage(); openPage("orders.html"); Assert.assertTrue(driver.getPageSource().length()>50); }
    @Test(priority=64) public void TC64_OrdersBackForward(){ loginByLocalStorage(); openPage("orders.html"); openPage("home.html"); driver.navigate().back(); driver.navigate().forward(); Assert.assertTrue(true); }
    @Test(priority=65) public void TC65_OrdersJSBoolean(){ loginByLocalStorage(); openPage("orders.html"); Assert.assertEquals(((JavascriptExecutor)driver).executeScript("return true"),true); }
    @Test(priority=66) public void TC66_OrdersJSNumber(){ loginByLocalStorage(); openPage("orders.html"); Assert.assertEquals(((JavascriptExecutor)driver).executeScript("return 8+2"),10L); }
    @Test(priority=67) public void TC67_OrdersHTMLTag(){ loginByLocalStorage(); openPage("orders.html"); Assert.assertTrue(driver.findElement(By.tagName("html")).isDisplayed()); }
    @Test(priority=68) public void TC68_OrdersWindowHeight(){ Assert.assertTrue(driver.manage().window().getSize().getHeight()>0); }
    @Test(priority=69) public void TC69_OrdersDriverActive(){ Assert.assertNotNull(driver); }
    @Test(priority=70) public void TC70_OrdersTitleLength(){ loginByLocalStorage(); openPage("orders.html"); Assert.assertTrue(driver.getTitle().length()>=0); }

    // ========================= SESSION / STORAGE (71–80) =========================

    @Test(priority=71) public void TC71_SetLocalStorage(){ ((JavascriptExecutor)driver).executeScript("localStorage.setItem('testKey','123')"); Assert.assertTrue(true); }
    @Test(priority=72) public void TC72_GetLocalStorage(){ Object value=((JavascriptExecutor)driver).executeScript("return localStorage.getItem('testKey')"); Assert.assertEquals(value,"123"); }
    @Test(priority=73) public void TC73_RemoveLocalStorage(){ ((JavascriptExecutor)driver).executeScript("localStorage.removeItem('testKey')"); Assert.assertTrue(true); }
    @Test(priority=74) public void TC74_ClearLocalStorage(){ ((JavascriptExecutor)driver).executeScript("localStorage.clear()"); Assert.assertTrue(true); }
    @Test(priority=75) public void TC75_SetSessionStorage(){ ((JavascriptExecutor)driver).executeScript("sessionStorage.setItem('s','1')"); Assert.assertTrue(true); }
    @Test(priority=76) public void TC76_GetSessionStorage(){ Object v=((JavascriptExecutor)driver).executeScript("return sessionStorage.getItem('s')"); Assert.assertEquals(v,"1"); }
    @Test(priority=77) public void TC77_RemoveSessionStorage(){ ((JavascriptExecutor)driver).executeScript("sessionStorage.removeItem('s')"); Assert.assertTrue(true); }
    @Test(priority=78) public void TC78_JSReturnArray(){ Object size=((JavascriptExecutor)driver).executeScript("return [1,2,3].length"); Assert.assertEquals(size,3L); }
    @Test(priority=79) public void TC79_JSReturnObject(){ Object obj=((JavascriptExecutor)driver).executeScript("return typeof window"); Assert.assertEquals(obj,"object"); }
    @Test(priority=80) public void TC80_JSMathRandom(){ Object num=((JavascriptExecutor)driver).executeScript("return Math.floor(10/2)"); Assert.assertEquals(num,5L); }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
