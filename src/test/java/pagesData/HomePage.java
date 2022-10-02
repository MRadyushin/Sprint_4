package pagesData;

    import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;

public class HomePage {
    // Локатор кнопки Заказа в заголовке
    private final By homeButtonHeader = By.xpath("//*[@id=\'root\']/div/div/div[1]/div[2]/button[1]");

    // Локатор кнопки Заказа в теле
    private final By homeButtonBody = By.xpath("//*[@id=\'root\']/div/div/div[4]/div[2]/div[5]/button");

    // Локатор кнопки куки


    private String reqText;
    private WebDriver driver;

    //Локатор вопроса
    private By question;
    // Текст локатора ответа
    private By answerText;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    // Поиск и открытие вопроса
    public void openRequests(String reqText) {
        setQuestion(reqText);
        WebElement elementQuestion = driver.findElement(question);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0," + elementQuestion.getLocation().y + ")");
        elementQuestion.click();
    }
    //Поиск вопроса
    public void setQuestion(String reqText) {
        //Подставляем текст и находим xpath вопроса
        this.question = By.xpath(String.format(".//*[text()='%s']", reqText));
    }
    // Получение текста ответа
    public String getAnswerText(String reqText) {
        setAnswerText(reqText);
        return driver.findElement(answerText).getText();
    }
    //Поиск ответа
    public void setAnswerText(String reqText) {

        //Подставляем текст и находим xpath ответа
        this.answerText = By.xpath(String.format("(.//*[text()='%s'])/following::p[1]", reqText));
    }
    public void clickHomeButtonHeader() {
        driver.findElement(homeButtonHeader).click();
    }

    public void clickHomeButtonBody() {
        driver.findElement(homeButtonBody).click();
    }

}

