package toronto22.swaglabDemo.common.navigation;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class Scroll {
    public static void scrollDown(AppiumDriver driver, By by)
    {
        boolean found=false;
        while(!found)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));
                wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                found=true;
            }
            catch(Exception e)
            {
                Dimension size = driver.manage().window().getSize();
                int startX=size.width/2;
                int startY=(int)(size.height*0.9);
                int endX=size.width/2;
                int endY=(int)(size.height*0.2);

                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence dragNDrop = new Sequence(finger, 1);
                dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
                dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                dragNDrop.addAction(new Pause(finger, Duration.ofMillis(600)));
                dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), endX, endY));
                dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                driver.perform(Collections.singletonList(dragNDrop));
            }
        }
    }
}
