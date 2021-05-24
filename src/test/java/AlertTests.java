import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AlertTests extends TestBase{

    @Test
    public void shouldHandleBasicAlert() {
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");
        getDriver().findElement(By.id("simple-alert")).click();

//        getDriver().switchTo().alert().getText(); //pobranie tekstu wpisanego w alert
//        getDriver().switchTo().alert().sendKeys("text"); //wpisanie tekstu do inputu w alercie
//        getDriver().switchTo().alert().dismiss(); //klika w przycisk cancel
        getDriver().switchTo().alert().accept(); //klika w przycisk OK

        assertThat(getDriver().findElement(By.id("simple-alert-label")).getText(),
                equalTo("OK button pressed"));

    }

    @Test
    public void promptAlertBoxTest() {
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");
        getDriver().findElement(By.id("prompt-alert")).click();
        getDriver().switchTo().alert().sendKeys("Lord Vader");
        getDriver().switchTo().alert().accept();

        assertThat(getDriver().findElement(By.id("prompt-label")).getText(),
                equalTo("Hello Lord Vader! How are you today?"));
    }

    @Test
    public void confirmAlertBoxTest() {
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");
        getDriver().findElement(By.id("confirm-alert")).click();
        getDriver().switchTo().alert().accept();
        assertThat(getDriver().findElement(By.id("confirm-label")).getText(),
                equalTo("You pressed OK!"));
        getDriver().findElement(By.id("confirm-alert")).click();
        getDriver().switchTo().alert().dismiss();
        assertThat(getDriver().findElement(By.id("confirm-label")).getText(),
                equalTo("You pressed Cancel!"));
    }


}
