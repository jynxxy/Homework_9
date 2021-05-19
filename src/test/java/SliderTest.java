import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SliderTest extends TestBase{

    @Test
    public void shouldMoveSliderTo50() {
        getDriver().get("https://seleniumui.moderntester.pl/slider.php");

        WebElement slider = getDriver().findElement(By.id("custom-handle"));

        slider.sendKeys(Keys.ARROW_RIGHT);

        for (int i = 0; i < 50; i++ ) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }

        assertThat(slider.getText(), is("50"));

//        assertThat(slider().findElement(By.id("custom-handle")).getText(),
//                equalTo("OK button pressed"));
    }


    private void moveTo(int expectedSliderValue) {



    }

    private int getSliderValue() {
        String sliderValue = getDriver().findElement(By.id("custom-handle")).getText();
        return Integer.parseInt(sliderValue); //np. "81" -> 81

    }

}
