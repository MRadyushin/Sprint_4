package pagesData;

    import org.openqa.selenium.*;
    import org.openqa.selenium.support.ui.*;

public class DesignPage extends HomePage {

    // Локатор поля Имя
    private final By name = By.xpath("//input[@placeholder='* Имя']");

    // Локатор поля Фамилия
    private final By surname = By.xpath("//input[@placeholder='* Фамилия']");

    // Локатор поля Адресс
    private final By address = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    // Локатор поля станции метро
    private final By station = By.cssSelector("input.select-search__input");

    // Локатор поля Телефон
    private final By phone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Локатор кнопки Далее
    private final By nextButton = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM");

    // Локатор поля Даты аренды
    private final By rentalData = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    // Локатор поля Время аренды
    private final By rentalTime = By.xpath("//*/text()[normalize-space(.)='* Срок аренды']/parent::*");

    // Локатор поля Цвет
    private By color;

    // Локатор поля комментарий
    private final By comment = By.xpath("//input[@placeholder='Комментарий для курьера']");

    // Локатор кнопки Заказать
    private final By orderButton = By.xpath("(//*/text()[normalize-space(.)='Заказать']/parent::*)[2]");

    // Локатор всплывающего окна
    private final By popupWindow = By.xpath("//div[contains(@class, 'Order_ModalHeader')]");

    // Локатор кнопка оформления заказа
    private final By YesOrderButton = By.xpath("//*/text()[normalize-space(.)='Да']/parent::*");

    private WebDriver driver;

    public DesignPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Заполнение поля Имя
    public void setName(String firstName) {
        driver.findElement(name).clear();
        driver.findElement(name).sendKeys(firstName);
    }

    // Заполнение поля Фамилия
    public void setSurname(String lastName) {
        driver.findElement(surname).clear();
        driver.findElement(surname).sendKeys(lastName);
    }

    // Заполнение поля Адресс
    public void setAddress(String addr) {
        driver.findElement(address).clear();
        driver.findElement(address).sendKeys(addr);
    }

    // Выбор станции метро
    public void setStation(String metro) {
        WebElement metroFieldElement = driver.findElement(station);
        metroFieldElement.sendKeys(metro);
        metroFieldElement.sendKeys(Keys.DOWN);
        metroFieldElement.sendKeys(Keys.ENTER);
    }

    // Заполнение поля Телефон
    public void setPhone(String number) {
        driver.findElement(phone).clear();
        driver.findElement(phone).sendKeys(number);
    }

    //Метод заполнения главной формы
    public void setFillMainForms(String firstName, String lastName, String address, String metro, String number) {
        setName(firstName);
        setSurname(lastName);
        setAddress(address);
        setStation(metro);
        setPhone(number);
    }

    // Нажатие на кнопку Далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    //Заполнение даты аренды
    public void setRentalData(String rentData) {
        WebElement orderDate = driver.findElement(rentalData);
        orderDate.sendKeys(rentData);
        orderDate.sendKeys(Keys.ENTER);
    }

    //Заполнение срока аренды
    public void setRentalTime(String rentTime) {
        driver.findElement(rentalTime).click();
        driver.findElement(By.xpath("//div[contains(text(),'" + rentTime + "')]")).click();
    }

    //Выбор цвета
    public void setColor(String coloring) {
        setColoring(coloring);
        driver.findElement(color).click();
    }

    public void setColoring(String coloring) {
        this.color = By.xpath(String.format("(//div[contains(., 'Цвет самоката') and contains(@class, 'Order_Title')])/following::label[@for='%s']", coloring));
    }

    //Заполнение поля комментарий
    public void setComment(String commentary) {
        driver.findElement(comment).clear();
        driver.findElement(comment).sendKeys(commentary);
    }

    //Метод заполнения дополнительной формы
    public void setAdditionalForms(String rentData, String rentTime, String color, String comment) {
        setRentalData(rentData);
        setRentalTime(rentTime);
        setColor(color);
        setComment(comment);
    }

    //Нажатие кнопки Заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    //Получение текста в сплывающем окне
    public String getPopupWindow() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(popupWindow));
        return driver.findElement(popupWindow).getText();
    }
    //Нажатие кнопки Да
    public void clickMakeOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(YesOrderButton));
        driver.findElement(YesOrderButton).click();
    }

}
