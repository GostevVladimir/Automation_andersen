package ru.gostev.autotest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MarketTests extends TestBase{
  @Test(enabled = true)
  public void equalsListMarket(){
    app.getMarketPageHelper().openMarketPage();
    app.getMarketPageHelper().moveToCategory();
    app.getLoptopPageHalper().selectShowBy("Показывать по 12");
    app.getLoptopPageHalper().equalsList(12);
    app.getLoptopPageHalper().selectShowBy("Показывать по 48");
    app.getLoptopPageHalper().equalsList(48);
  }

  @Test(enabled = true)
  public void productSortingByPrice(){
    app.getMarketPageHelper().openMarketPage();
    app.getMarketPageHelper().moveToCategory();
    app.getLoptopPageHalper().clickToSortPrice("по цене");
    Assert.assertTrue(app.getLoptopPageHalper().comparePriceGoods());
    Assert.assertTrue(app.getLoptopPageHalper().checkingTheSortIcon("link_hovered_yes"));
  }

  @Test(enabled = true)
  public void compareGoodsTest(){
    app.getMarketPageHelper().openMarketPage();
    app.getMarketPageHelper().moveToCategory();
    app.getLoptopPageHalper().addGoodsToCompare();
    app.getLoptopPageHalper().goToComparePage("Сравнение");
    Assert.assertTrue(app.getCompareGoodsPageHelper().chekingGoodsCompare(2));
    app.getCompareGoodsPageHelper().deleteGoodsIncompare("Удалить список");
    Assert.assertTrue((app.getCompareGoodsPageHelper().chekingDeleteGoodsInCompare("Товаров нет.")));
  }
}
