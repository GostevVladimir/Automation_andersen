package ru.gostev.autotest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WeatherPageHelper extends HelperBase{

  public WeatherPageHelper(WebDriver wd) {
    super(wd);
  }

  private By firstLink = By.cssSelector("a[accesskey=\"1\"]");

  public String textInThelink(){
    String textLink  = wd.findElement(firstLink).getText();
    return textLink;
  }
}
