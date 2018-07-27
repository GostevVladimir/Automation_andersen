package ru.gostev.autotest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MarketTests extends TestBase{
  @Test(enabled = false)
  public void equalsListMarket(){
    app.getMarketPageHelper().openMarketPage();
    app.getMarketPageHelper().moveToCategory();
    app.getMarketPageHelper().moveToShowBy("Показывать по 12");
    app.getMarketPageHelper().equalsList(12);
    app.getMarketPageHelper().moveToShowBy("Показывать по 48");
    app.getMarketPageHelper().equalsList(48);
  }

  @Test(enabled = false)
  public void productSortingByPrice(){
    app.getMarketPageHelper().openMarketPage();
    app.getMarketPageHelper().moveToCategory();
    app.getMarketPageHelper().moveToSortPrice("по цене");
    Assert.assertTrue(app.getMarketPageHelper().comparePriceGoods());
  }

  @Test(enabled = true)
  public void compareGoodsTest(){
    app.getMarketPageHelper().openMarketPage();
    app.getMarketPageHelper().moveToCategory();
    app.getMarketPageHelper().addGoodsToCompare();
    app.getMarketPageHelper().goToComparePage("Сравнение");
    Assert.assertTrue(app.getMarketPageHelper().chekingGoodsCompare(2));
    app.getMarketPageHelper().deleteGoodsIncompare("Удалить список");
    Assert.assertTrue((app.getMarketPageHelper().chekingDeleteGoodsInCompare("Товаров нет.")));
  }
}
