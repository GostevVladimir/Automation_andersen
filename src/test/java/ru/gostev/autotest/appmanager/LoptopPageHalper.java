package ru.gostev.autotest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

public class LoptopPageHalper extends HelperBase{
  public LoptopPageHalper(WebDriver wd) {
    super(wd);
    PageFactory.initElements(wd, this);
  }

  private By showBy = By.cssSelector("button[role=\"listbox\"]");
  private By listShow = By.cssSelector(".select__text");
  private By listSort = By.cssSelector(".n-filter-sorter");
  private By price = By.cssSelector("div[class=\"price\"]");
  private By filterLocator = By.cssSelector(".link.link_theme_major");
  private By compareButtonsElements = By.cssSelector(".n-user-lists_type_compare");
  private By marketMenuElements = By.cssSelector(".header2-menu__text");
  private By goodsElements = By.cssSelector(".n-snippet-card2__title");

  WebElement showByElement = wd.findElement(showBy);

  public void selectShowBy(String text){
    moveTo(showByElement);
    clickToLink(showByElement,wd, 5);
    getElementList(text,getWebElements(listShow)).click();
  }

  public  void equalsList(int size){
    waitForJQueryEnds();
    List<WebElement> elements = wd.findElements(goodsElements);
    Assert.assertEquals(elements.size(), size);
  }

  public void clickToSortPrice(String text){
    getElementList(text, getWebElements(listSort)).click();
  }

  public boolean comparePriceGoods(){
    waitForJQueryEnds();
    return parseToListInteger(getACorrectPriceList(getWebElements(price)));
  }

  public boolean parseToListInteger(List<String> listString){
    for(int i = 0; i < listString.size()-1; i++){
      if(!(Integer.parseInt(listString.get(i)) <= Integer.parseInt(listString.get(i+1)))){
        return false;
      }
    }
    return true;
  }

  public List<String> getACorrectPriceList(List<WebElement> list){
    List<String> listString = new ArrayList<String>();
    for(int i =0; i < list.size(); i++){
      String str = list.get(i).getText();
      listString.add(replaceSymbol(str));
    }
    return listString;
  }

  public String replaceSymbol(String str){
    str = str.replaceAll("\\s+","");
    str = str.replaceAll("\\u20BD","");
    str = str.replaceAll("от","");
    return str;
  }

  public boolean checkingTheSortIcon(String nameClass){
    List<WebElement> elementSort = getWebElements(filterLocator);
    moveTo(getElementList("по цене", elementSort));
    String str = getElementList("по цене", elementSort).getAttribute("class");
    if(! str.contains(nameClass)){
      return false;
    }else
      return true;
  }

  public void addGoodsToCompare(int count) {
    Actions action = new Actions(wd);
    List<WebElement> elementsCompari = getWebElements(compareButtonsElements);
    for(int i =0; i < count; i++){
      action.moveToElement(elementsCompari.get(i)).perform();
      elementsCompari.get(i).click();
    }
  }

  public  void goToComparePage(String textMenu){
    List<WebElement> elementsMenuMarket = getWebElements(marketMenuElements);
    Actions action = new Actions(wd);
    for(int i = 0; i < elementsMenuMarket.size(); i++){
      if(elementsMenuMarket.get(i).getText().equals(textMenu)){
        action.moveToElement(elementsMenuMarket.get(i)).perform();
        elementsMenuMarket.get(i).click();
        break;
      }
    }
  }
}
