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
  public By textFromMarketPage = By.cssSelector("._2VRdkOjM3w");

  @FindBy(css = ".related-serp__title")
  public WebElement textFromVideoPage;

  @FindBy(css = "a[href=\"/collections/user/\"]")
  public WebElement textFromPicturePage;

  @FindBy(css = "a[href=\"/politics.html?from=index\"]")
  public WebElement textFromNewsPage;

  @FindBy(css = ".input_air-search-large__control")
  public WebElement textFromMapsPage;

  @FindBy(css = "[data-department='Компьютеры']")
  public WebElement elementYandexMarket;

  @FindBy(css = "a[class=\"name\"]")
  public WebElement textFromInterpreterPage;

  @FindBy(css = "div[data-b=\"60\"]")
  public WebElement textFromMusicPage;


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

  public boolean chekingTextFromPage( String text, WebElement element, int timeout){
    final WebDriverWait wait = new WebDriverWait(wd, timeout);
    wait.until(ExpectedConditions.visibilityOf(element));
    System.out.println(element.getText());
    if (text.contains(element.getText())){
      return true;
    }else return false;
  }

  public boolean chekingTextFromMarketPage(String text){
    String str = getElementList("Популярные товары",
            getWebElements(textFromMarketPage)).getText();
    System.out.println(str);
    if (!text.contains(str)){
      return false;
    } else return true;
  }

  public boolean waitLink(String text, WebElement element, int timeout) {
    final WebDriverWait wait = new WebDriverWait(wd, timeout);
    wait.until(ExpectedConditions.visibilityOf(element));
    if (text.contains(element.getText())) {
      return true;
    } else return false;
  }
}
