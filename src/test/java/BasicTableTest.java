import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasicTableTest extends TestBase{

    @Test
    public void shouldPrintHigherThan4000() {
        getDriver().get("https://seleniumui.moderntester.pl/table.php");

        List<WebElement> allMountains = getDriver().findElements(By.cssSelector("ybody tr"));

        for (WebElement mountain : allMountains) {
            List<WebElement> allColumns = mountain.findElements(By.cssSelector("td"));
            if (Integer.parseInt(allColumns.get(3).getText()) > 4000) {
                System.out.println(allColumns.get(0).getText());
            }
        }
    }

    @Test
    public void shouldPrintRankPeakMountainRangeInSwitzerlandHigherThan4000() {
        getDriver().get("https://seleniumui.moderntester.pl/table.php");

        List<WebElement> allMountains = getDriver().findElements(By.cssSelector("ybody tr"));

        for (WebElement mountain : allMountains) {
            List<WebElement> allColumns = mountain.findElements(By.cssSelector("td"));
            if (Integer.parseInt(allColumns.get(3).getText()) > 4000) {
                System.out.println(allColumns.get(0).getText());
                System.out.println(allColumns.get(1).getText());
                System.out.println(allColumns.get(2).getText());

            }
        }



    }
}
