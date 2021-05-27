# Homework_9

1. Prompt Alert box https://seleniumui.moderntester.pl/alerts.php  
**Test steps:**  
Click on 'Prompt Pop up' button  
Type "Lord Vader" in the alert text box  
Click 'OK' button on alert  
Check that "Hello Lord Vader! How are you today?" text has been shown

2. Confirm Alert box https://seleniumui.moderntester.pl/alerts.php  
**Test steps:**  
Click on 'Confirm Pop up' button  
Click 'OK' button on alert  
Check that "You pressed OK!" has been shown  
Click again on 'Confirm Pop up' button  
Click 'Anuluj'/'Cancel' button on alert  
Check that "You pressed Cancel!" text has been shown  

3. Tables https://seleniumui.moderntester.pl/table.php  
**Test steps:**  
Get all rows from table to List  
Print out 'Rank', 'Peak' and 'Mountain range' of mountains that are in "Switzerland" and are higher than 4000 m

4. Slider https://seleniumui.moderntester.pl/slider.php  
Fill missing methods in https://github.com/mtadla-sii/SeleniumForm/blob/master/SeleniumDemo/src/test/java/SliderTest.java  
Move the slider to such values and after each shift of the slider check if the correct value is displayed -50, 30, 30, 80

5. Droppable https://seleniumui.moderntester.pl/droppable.php  
**Test steps:**  
drag 'Drag me to my target' square and drop it in 'Drop here' area  
check if "Dropped!" text appeared  
https://github.com/mtadla-sii/SeleniumForm/blob/master/SeleniumDemo/src/test/java/DroppableTest.java  
do it using 'actions.dragAndDropBy()' it requeries X,Y values to move the square

6. Datepicker https://seleniumui.moderntester.pl/datepicker.php
Select the dates below. After each selection check if the correct date is shown in 'Date' input:  
29.05.2021  
05.02.2021  
05.02.2021 (yes, again the same date)  
01.11.2020  
01.12.2020  
25.12.2020  
01.02.2022  
Today (use LocalDate.now() method)
Comment: these dates combine all different ways of 'walking' on the date picker, so do all of them in one test. You cannot refresh page between different dates and select them one by one (similar how slider test have method moveTo())
