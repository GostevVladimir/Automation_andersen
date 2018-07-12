package ru.gostev.autotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexMainPageHelper {
  private WebDriver wd;

  public YandexMainPageHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void search(String text){
    type(By.cssSelector("#text"),text);
    click(By.cssSelector(".search2__button button"));
  }

  public void type(By locator, String text){
    click(locator);
    if(text != null){
      String existingText = wd.findElement(locator).getAttribute("value");
      if(! text.equals(existingText)){
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }


  public void click(By locator){
    wd.findElement(locator).click();
  }

  public String textInThelink(){
    String textLink  = wd.findElement(By.cssSelector("a[accesskey=\"1\"]")).getText();
    return textLink;
  }
}
