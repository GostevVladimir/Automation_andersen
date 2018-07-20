package ru.gostev.autotest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class YandexMainPageHelper extends HelperBase{

  public YandexMainPageHelper(WebDriver wd) {
    super(wd);
  }

  private final String URL = "https://www.yandex.ru/";

  private By searchString = By.cssSelector("#text");
  private By searchButton = By.cssSelector(".search2__button button");
  private By locationButton = By.cssSelector(".geolink__button"); //Подобрать позже локатор
  private By yet = By.cssSelector("a[data-statlog=\"tabs.more\"]");
  private By listYet = By.cssSelector(".home-tabs__more");

  public void search(String text){
    type(searchString,text);
    click(searchButton);
  }

  public void goToLacationpage(){
    click(locationButton);
  }

  public void openSearchPage(){
    wd.get(URL);
  }

  public String[] getListElementYet(){
    click(yet);
    WebElement element = wd.findElement(listYet);
    String listElements = element.getText();
    String[] words = listElements.split("(?=\\p{Lu})");
    return words;
  }

  public void equalsList(String[] before, String[] after) {
    for (int i = 0; i < before.length; i++) {
      if(before[i].equals(after[i])){
        System.out.println("Ok");
      }
    }
  }
}


