package ru.gostev.autotest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexMainPageHelper extends HelperBase{

  public YandexMainPageHelper(WebDriver wd) {
    super(wd);
  }

  public void search(String text){
    type(By.cssSelector("#text"),text);
    click(By.cssSelector(".search2__button button"));
  }


  public String textInThelink(){
    String textLink  = wd.findElement(By.cssSelector("a[accesskey=\"1\"]")).getText();
    return textLink;
  }
}
