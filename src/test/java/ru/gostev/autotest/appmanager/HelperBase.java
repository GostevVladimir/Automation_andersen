package ru.gostev.autotest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public List<WebElement> getWebElements(By element){
    List<WebElement> elements = wd.findElements(element);
    return elements;
  }

  public  WebElement getElementList(String nameElementList, List<WebElement> elements){
    for(int i = 0; i < elements.size(); i++){
      if(nameElementList.equals(elements.get(i).getText())){
        return elements.get(i);
      }
    }
    return null;
  }

  public void moveTo(WebElement element) {
    Actions action = new Actions(wd);
    action.moveToElement(element).perform();
  }

  public void clickToLink(WebElement locator, WebDriver driver, int timeout) {
    final WebDriverWait wait = new WebDriverWait(driver, timeout);
    wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(locator)));
    locator.click();
  }
}
