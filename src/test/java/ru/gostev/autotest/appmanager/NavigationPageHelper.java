package ru.gostev.autotest.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class NavigationPageHelper extends HelperBase{

  public NavigationPageHelper(WebDriver wd) {
    super(wd);
  }

  private final String URL = "https://www.yandex.ru/";

  private By navigation = By.cssSelector("[role=\"navigation\" ] .home-link");



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

  public boolean CheckingNavigators(String URL){
    if(! URL.contains(getURL())){
      return false;
    }else
      return true;
  }


}
