import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Datepicker extends TestBase{


    @Test
    public void datepickerTest() throws InterruptedException {
        getDriver().get("https://seleniumui.moderntester.pl/datepicker.php");

        moveTo(29, 5, 2021);
        moveTo(5, 2, 2021);
        moveTo(5, 2, 2021);
        moveTo(1, 11, 2020);
        moveTo(1, 12, 2020);
        moveTo(25, 12, 2020);
        moveTo(1, 2, 2022);
        moveTo(Integer.parseInt(LocalDate.now().toString().substring(8)), Integer.parseInt(LocalDate.now().toString().substring(5, 7)), Integer.parseInt(LocalDate.now().toString().substring(0, 4)));


    }

    private void moveTo(int day, int month, int year) throws InterruptedException {
        getDriver().findElement(By.cssSelector("#datepicker")).click();

        while (true) {
            int actualYear = getYearValue();
            if (actualYear < year) {
                getDriver().findElement(By.xpath("//a[contains(@class,'ui-datepicker-next ui-corner-all')]")).click();
            } else if (getYearValue() > year) {
                getDriver().findElement(By.xpath("//a[contains(@class,'ui-datepicker-prev ui-corner-all')]")).click();
            } else
                break;
        }

        while (true) {
            int actualMonth = getMonthValue();
            if (actualMonth < month) {
                getDriver().findElement(By.xpath("//a[contains(@class,'ui-datepicker-next ui-corner-all')]")).click();
            } else if (actualMonth > month) {
                getDriver().findElement(By.xpath("//a[contains(@class,'ui-datepicker-prev ui-corner-all')]")).click();
            } else
                break;
        }

        List<WebElement> dayElements = getDriver().findElements(By.xpath("//td/a[contains(@class,'ui-state-default')and not(contains(@class,'ui-priority-secondary'))]"));
        for (WebElement d: dayElements) {
            if (Integer.parseInt(d.getText()) == day) {
                d.click();
                break;
            }
        }

        String formattedExpectedDay = getFormattedExpectedDay(day);
        String formattedExpectedMonth = getFormattedExpectedMonth(month);

        assertThat(getDriver().findElement(By.id("datepicker")).getAttribute("value"),
                equalTo(formattedExpectedMonth + "/" + formattedExpectedDay + "/" + year));
    }


    private int getYearValue() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        WebElement yearElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-year")));
        String yearValue = yearElement.getText();
        return Integer.parseInt(yearValue);
    }

    private String getFormattedExpectedDay(int day) {
        String formattedExpectedDay = "";
        if (day < 10) {
            formattedExpectedDay = "0" + day;
        } else {
            formattedExpectedDay = Integer.toString(day);
        }
        return formattedExpectedDay;
    }

    private String getFormattedExpectedMonth(int month) {
        String formattedExpectedMonth = "";
        if (month < 10) {
            formattedExpectedMonth = "0" + month;
        } else {
            formattedExpectedMonth = Integer.toString(month);
        }
        return formattedExpectedMonth;
    }

    private int getMonthValue() {
        int month = 0;
        String monthValue = getDriver().findElement(By.className("ui-datepicker-month")).getText();
        switch (monthValue) {
            case "Januray":
                month = 1;
                break;
            case "February":
                month = 2;
                break;
            case "March":
                month = 3;
                break;
            case "April":
                month = 4;
                break;
            case "May":
                month = 5;
                break;
            case "June":
                month = 6;
                break;
            case "July":
                month = 7;
                break;
            case "August":
                month = 8;
                break;
            case "September":
                month = 9;
                break;
            case "October":
                month = 10;
                break;
            case "November":
                month = 11;
                break;
            case "December":
                month = 12;
                break;
        }
        return month;
    }
}


