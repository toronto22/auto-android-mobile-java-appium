package toronto22.swaglabDemo.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import toronto22.swaglabDemo.common.driver.AppiumDriverSetup;

public class WebHooks {
    @Before
    public void setup(){
        AppiumDriverSetup.createDriver();
    }

    @After
    public void tearDown(){
        AppiumDriverSetup.getDriver().closeApp();
    }
}
