package ru.gostev.autotest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPageHelper extends HelperBase{

  public LocationPageHelper(WebDriver wd) {
    super(wd);
  }

  private By stringInputCity = By.cssSelector("#city__front-input");
  private  By cityName = By.xpath(".//div[@class=\"b-autocomplete-item__details\" and contains(text(),\"Ломбардия, Италия\")]");// установить правельный локатор

  public void enteringAnotherCity(String city){
    type(stringInputCity,city);
    click(cityName);

   }
}
