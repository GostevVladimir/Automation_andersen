package ru.gostev.autotest.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class NavigationPageHelper extends HelperBase{

  public NavigationPageHelper(WebDriver wd) {
    super(wd);
    PageFactory.initElements(wd, this);
  }

  private final String URL = "https://www.yandex.ru/";

  private By navigation = By.cssSelector("[role=\"navigation\" ] .home-link");

  @FindBy(css = ".related-serp__title")
  public WebElement textFromVideoPage;

  @FindBy(css = ".input_air-search-large__control")
  public WebElement textFromMapsPage;


/*  public By textFromVideoPage = By.cssSelector(".related-serp__title");
  public By textFromMapsPage = By.cssSelector(".input_air-search-large__control");*/



  public WebElement returnElementFromList(List<WebElement> listElement, String textElement){
    for(int i = 0; i < listElement.size(); i++){
      if(listElement.get(i).getText().equals(textElement)){
        return listElement.get(i);
      }
    }
    return null;
  }
  public void goToMainPage(){
    wd.get(URL);
  }
  public void goToVideoPage(String namePage){
    returnElementFromList(getWebElements(navigation), namePage).click();
  }
  public void goToPicturePage(String namePage){
    returnElementFromList(getWebElements(navigation), namePage).click();
  }
  public void goToNewsPage(String namePage){
    returnElementFromList(getWebElements(navigation), namePage).click();
  }
  public void goToMapsPage(String namePage){
    returnElementFromList(getWebElements(navigation), namePage).click();
  }
  public void goToMarketPage(String namePage){
    returnElementFromList(getWebElements(navigation), namePage).click();
  }
  public void goToInterpreterPage(String namePage){
    returnElementFromList(getWebElements(navigation), namePage).click();
  }
  public void goToMusicPage(String namePage){
    returnElementFromList(getWebElements(navigation), namePage).click();
  }

  public String getURL(){
    return wd.getCurrentUrl();
  }

  public boolean checkingNavigators(String URL){
    if(! URL.contains(getURL())){
      return false;
    }else
      return true;
  }

/*  public boolean chekingTextFromPage(String textFromPage, int timeout, By elementLocator) {
    final WebDriverWait wait = new WebDriverWait(wd, timeout);
    wait.until(ExpectedConditions.visibilityOf(returnElementFromList(getWebElements(elementLocator), textFromPage)));
    if (textFromPage.equals(returnElementFromList(getWebElements(elementLocator), textFromPage).getText())) {
      return true;
    } else return false;
  }*/

  public boolean chekingTextFromPage( String text, WebElement element, int timeout){
    final WebDriverWait wait = new WebDriverWait(wd, timeout);
    wait.until(ExpectedConditions.visibilityOf(element));
    if (text.contains(element.getText())){
      return true;
    }else return false;
  }

}
