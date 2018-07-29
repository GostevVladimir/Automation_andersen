package ru.gostev.autotest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;


public class CompareGoodsPageHelper extends HelperBase{
  public CompareGoodsPageHelper(WebDriver wd) {
    super(wd);
    PageFactory.initElements(wd, this);
  }

  @FindBy(css = "div[class=\"title title_size_18\"]")
  protected WebElement textDelitionCompare;

  private By compareGoodsElements = By.cssSelector(".price");
  private By compareMenuElements = By.cssSelector(".link__inner");

  public boolean chekingGoodsCompare(int count) {
    List<WebElement> elementsGoodsCompare = getWebElements(compareGoodsElements);
    if (elementsGoodsCompare.size() == count){
      return true;
    }
    return false;
  }

  public void deleteGoodsIncompare(String textMenu) {
    List<WebElement> elementsMenuCompare = getWebElements(compareMenuElements);
    for (int i = 0; i < elementsMenuCompare.size(); i++) {
      if (elementsMenuCompare.get(i).getText().equals(textMenu)) {
        elementsMenuCompare.get(i).click();
        break;
      }
    }
  }
  public boolean chekingDeleteGoodsInCompare(String text){
    if(textDelitionCompare.getText().contains(text)){
      return true;
    }else  return false;
  }
}
