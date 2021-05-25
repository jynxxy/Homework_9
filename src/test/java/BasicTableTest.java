import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasicTableTest extends TestBase{

    @Test
    public void shouldPrintHigherThan4000() {
        getDriver().get("https://seleniumui.moderntester.pl/table.php");

        // find all rows
        List<WebElement> allMountains = getDriver().findElements(By.cssSelector("tbody tr"));

        // iterate through each row
        for (WebElement mountain : allMountains) {
            // find all columns inside row
            List<WebElement> allColumns = mountain.findElements(By.cssSelector("td"));

            // get(3) -> column with height
            // get(0) -> column with mountain name
            if (Integer.parseInt(allColumns.get(3).getText()) > 4000) {
                System.out.println(allColumns.get(0).getText());
            }
        }
    }

    @Test
    public void shouldPrintRankPeakMountainRangeInSwitzerlandHigherThan4000() {
        getDriver().get("https://seleniumui.moderntester.pl/table.php");

        List<WebElement> allMountains = getDriver().findElements(By.cssSelector("tbody tr"));

        for (WebElement mountain : allMountains) {
            List<WebElement> allColumns = mountain.findElements(By.cssSelector("td"));
            List<WebElement> allRows = mountain.findElements(By.cssSelector("th"));

            if (Integer.parseInt(allColumns.get(3).getText()) > 4000 && allColumns.get(2).getText().equals("Switzerland")) {
                System.out.println(allRows.get(0).getText());
                System.out.println("Peak: " + allColumns.get(0).getText());
                System.out.println("Mountain range: " + allColumns.get(1).getText());
                System.out.println("----------");
            }
        }
    }
}