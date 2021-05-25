import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DroppableTest extends TestBase {

    @Test
    public void shouldDragAndDrop() {
        getDriver().get("https://seleniumui.moderntester.pl/droppable.php");

        WebElement drag = getDriver().findElement(By.id("draggable"));
        WebElement drop = getDriver().findElement(By.id("droppable"));

        Actions actions = new Actions(getDriver());

        actions.dragAndDrop(drag, drop).perform();

        // ta sama metoda rozpisana na pomniejsze metody:
//        actions.clickAndHold(drag).moveToElement(drop).release().perform();

        assertThat(drop.getText(), equalTo("Dropped!"));
    }

    @Test
    public void shouldDragAndDropAlternative() {
        getDriver().get("https://seleniumui.moderntester.pl/droppable.php");

        WebElement drag = getDriver().findElement(By.id("draggable"));
        WebElement drop = getDriver().findElement(By.id("droppable"));

        Actions actions = new Actions(getDriver());

        actions.clickAndHold(drag)
                .moveToElement(drop)
                .release()
                .perform();

        assertThat(drop.getText(), equalTo("Dropped!"));
    }

    @Test
    public void shouldDragAndDropUsingXAndYValues() {
        getDriver().get("https://seleniumui.moderntester.pl/droppable.php");

        WebElement drag = getDriver().findElement(By.id("draggable"));
        WebElement drop = getDriver().findElement(By.id("droppable"));
        WebElement message = getDriver().findElement(By.cssSelector("#droppable p"));

        Actions actions = new Actions(getDriver());

        int dragXValue = drag.getLocation().getX();
        int dropXValue = drop.getLocation().getX();
        int xValueDifference = dropXValue - dragXValue;
        actions.dragAndDropBy(drag, xValueDifference, 0).build().perform();

        assertThat(message.getText(), equalTo("Dropped!"));
    }
}
