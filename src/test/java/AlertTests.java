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
}
