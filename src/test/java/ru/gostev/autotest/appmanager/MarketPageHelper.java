package ru.gostev.autotest.appmanager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketPageHelper extends HelperBase{

  public MarketPageHelper(WebDriver wd) {
    super(wd);
    PageFactory.initElements(wd, this);
  }

  private final String URL = "https://market.yandex.ru/";


  @FindBy(css = "[data-department=\"Компьютеры\"]")
  protected WebElement categoryPC;

  @FindBy(css = "a[href=\"/catalog/54544/list?hid=91013&track=menuleaf\"]")
  protected WebElement loptop;


  public void openMarketPage(){
    wd.get(URL);
  }

  public  void moveToCategory() {
    moveTo(categoryPC);
    clickToLink(loptop, wd, 5);
  }

}
