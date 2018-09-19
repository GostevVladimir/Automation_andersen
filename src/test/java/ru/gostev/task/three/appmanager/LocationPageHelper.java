package ru.gostev.autotest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class LocationPageHelper extends HelperBase{

  public LocationPageHelper(WebDriver wd) {
    super(wd);
  }

  private By stringInputCity = By.cssSelector("#city__front-input");
  private By cityName = By.xpath("//li[1]");

  public void enteringAnotherCity(String city){
    type(stringInputCity,city);
    boolean clicked = false;

    while (clicked != true)
      try{
        click(cityName);
        clicked = true;
      }catch ( StaleElementReferenceException e){
        System.out.println("Фиаско");
      }
  }
}
