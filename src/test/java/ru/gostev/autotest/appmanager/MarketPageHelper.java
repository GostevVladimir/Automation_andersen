package ru.gostev.autotest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;


public class MarketPageHelper extends HelperBase{

  public MarketPageHelper(WebDriver wd) {
    super(wd);
    PageFactory.initElements(wd, this);
  }

  private final String URL = "https://market.yandex.ru/";


  @FindBy(css = "[data-department=\"Компьютеры\"]")
  protected WebElement categoryPC;

  @FindBy(css = "a[href=\"/catalog/54544/list?hid=91013&track=menuleaf\"]")
  protected WebElement loptop;


  public void openMarketPage(){
    wd.get(URL);
  }

  public  void moveToCategory() {
    moveTo(categoryPC);
    clickToLink(loptop, wd, 5);
  }

  public void clickToLink(WebElement locator, WebDriver driver, int timeout) {
    final WebDriverWait wait = new WebDriverWait(driver, timeout);
    wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(locator)));
    locator.click();
  }

}
