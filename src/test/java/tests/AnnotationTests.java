package tests;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.junit.After;
    import org.junit.Before;
    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.openqa.selenium.firefox.FirefoxDriver;

public class AnnotationTests {

    protected WebDriver driver;
    //Локатор кнопки Куки
    protected final By cookieButton = By.xpath("//*[@id=\"rcc-confirm-button\"]");
    protected String BROWSER;

    @Before
    public void startUp() {
        //BROWSER = "Firefox";
        BROWSER = "Chrome";
        if (BROWSER == "Chrome") {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }


        // Открываем страницу сайта в браузере
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //Закрываем куки
        driver.findElement(cookieButton).click();
    }

    @After
    public void tearDown() {
        //Закрываем браузер
        driver.quit();

    }

}