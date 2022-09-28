package pagesData;

    import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;

public class HomePage {
    // Локатор кнопки Заказа в заголовке
    private final By homeButtonHeader = By.xpath("//*[@id=\"root\']/div/div/div[1]/div[2]/button[1]");
    // Локатор кнопки Заказа в теле
    private final By homeButtonBody = By.xpath("//*[@id=\'root\']/div/div/div[4]/div[2]/div[5]/button");


}

