package tests;

    import pagesData.*;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.junit.runners.Parameterized;

    import static org.hamcrest.CoreMatchers.containsString;
    import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class RentScooterTests extends AnnotationTests {


    private final String firstName;
    private final String lastName;
    private final String addr;
    private final String metro;
    private final String number;
    private final String rentData;
    private final String rentTime;
    private final String color;
    private final String comment;
    private final String result;

    public RentScooterTests(String firstName, String lastName, String addr, String metro, String number, String rentData, String rentTime, String color, String comment, String result) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.addr = addr;
        this.metro = metro;
        this.number = number;
        this.rentData = rentData;
        this.rentTime = rentTime;
        this.color = color;
        this.comment = comment;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] dataSet() {
        return new Object[][]{
                {"Максим", "Радюшин", "г. Рязань", "Рязанский проспект", "+79999998888", "30.09.2022", "пятеро суток", "black", "С какой максимальной скоростьб едет самокат?", "Заказ оформлен"},
                {"Алёна", "Радюшина", "г. Москва", "Китай-город", "+79998889999", "28.02.2023", "сутки", "grey", "", "Заказ оформлен"},

        };
    }

    @Test
    public void testMakeScooter() {
        HomePage objHomePage = new HomePage(driver);
        // Нажатие кнопки Заказать в заголовке
        objHomePage.clickHomeButtonHeader();

        DesignPage objDesignPage = new DesignPage(driver);
        // Заполнение основных данных
        objDesignPage.setFillMainForms(firstName, lastName, addr, metro, number);

        // Нажатие кнопки Далее
        objDesignPage.clickNextButton();

        // Заполнение дополнительных данных
        objDesignPage.setAdditionalForms(rentData, rentTime, color, comment);

        // Нажатие кнопки Заказть
        objDesignPage.clickOrderButton();

        // Нажатие кнопки Да для оформления заказа
        objDesignPage.clickRentalConfirmation();

        // Проверка появления всплывающего окна с сообщением об успешном создании заказа.
        assertThat("Всплывающее окно с сообщением об успешном создании заказа не появилось", objDesignPage.getPopupWindow(), containsString(result));
    }
}