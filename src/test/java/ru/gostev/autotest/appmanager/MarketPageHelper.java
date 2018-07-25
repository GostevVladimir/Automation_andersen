package ru.gostev.autotest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class MarketPageHelper extends HelperBase{

  public MarketPageHelper(WebDriver wd) {
    super(wd);
    PageFactory.initElements(wd, this);
  }

  private final String URL = "https://market.yandex.ru/";

  private Select select;

  @FindBy(css = "[data-department=\"Компьютеры\"]")
  protected WebElement categoryPC;

  @FindBy(css = "a[href=\"/catalog/54544/list?hid=91013&track=menuleaf\"]")
  protected WebElement loptop;

  @FindBy(css = "button[role=\"listbox\"]")
  protected WebElement showBy;


  public void openMarketPage(){
    wd.get(URL);
  }

  public  void moveToCategory() {
    Actions action = new Actions(wd);
    action.moveToElement(categoryPC).perform();
    clickToLink(loptop, wd, 5);
  }

  public void clickToLink(WebElement locator, WebDriver driver, int timeout) {
    final WebDriverWait wait = new WebDriverWait(driver, timeout);
    wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(locator)));
    locator.click();
  }

  public void moveToShowBy(String text){
    Actions action = new Actions(wd);
    action.moveToElement(showBy).perform();
    clickToLink(showBy,wd, 10);
    getElementList(text).click();
  }

  public Select getSelect(WebElement element) {
    select = new Select(element);
    return select;
  }

  public  WebElement getElementList(String nameElementList){
    List<WebElement> elements = wd.findElements(By.cssSelector(".select__text"));
    for(int i = 0; i < elements.size(); i++){
      if(nameElementList.equals(elements.get(i).getText())){
        return elements.get(i);
      }
    }
    return null;
  }

  public  WebElement equalsList(int size){
    wd.navigate().refresh();
    List<WebElement> elements = wd.findElements(By.cssSelector(".n-snippet-card2__title"));
    Assert.assertEquals(elements.size(), size);
    return null;
  }

}
