package tests;

    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.junit.After;
    import org.junit.Before;
    import io.github.bonigarcia.wdm.WebDriverManager;

public class AnnotationTests {

    protected WebDriver driver;

    @Before
    public void startUp() {
        // Инициализируем WebDriverManager в начале каждого теста
        WebDriverManager.chromedriver().setup();
        // Создаем драйвер под Google Chrome
        driver = new ChromeDriver();
        // Открываем страницу сайта в браузере
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDown() {
        driver.quit();

    }

}