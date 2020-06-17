package pages;

import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebPage {
    protected WebDriver driver;

    public WebPage(WebDriver driver) {
        Atlas atlas = new Atlas();
        this.driver = driver;
        PageFactory.initElements(driver, this);
      // PageFactory page = atlas.create(driver,this);
    }
}
