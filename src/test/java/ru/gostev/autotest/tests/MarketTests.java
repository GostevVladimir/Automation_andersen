package ru.gostev.autotest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MarketTests extends TestBase{
  @Test(enabled = false)
  public void testEqualsListMarket(){
    app.getMarketPageHelper().openMarketPage();
    app.getMarketPageHelper().moveToCategory();
    app.getLoptopPageHalper().selectShowBy("Показывать по 12");
    app.getLoptopPageHalper().equalsList(12);
    app.getLoptopPageHalper().selectShowBy("Показывать по 48");
    app.getLoptopPageHalper().equalsList(48);
  }

  @Test(enabled = false)
  public void testProductSortingByPrice(){
    app.getMarketPageHelper().openMarketPage();
    app.getMarketPageHelper().moveToCategory();
    app.getLoptopPageHalper().clickToSortPrice("по цене");
    Assert.assertTrue(app.getLoptopPageHalper().comparePriceGoods());
    Assert.assertTrue(app.getLoptopPageHalper().checkingTheSortIcon("link_hovered_yes"));
  }

  @Test(enabled = true)
  public void testCompareGoods(){
    app.getMarketPageHelper().openMarketPage();
    app.getMarketPageHelper().moveToCategory();
    app.getLoptopPageHalper().addGoodsToCompare(3);
    app.getLoptopPageHalper().goToComparePage("Сравнение");
    Assert.assertTrue(app.getCompareGoodsPageHelper().chekingGoodsCompare(3));
    app.getCompareGoodsPageHelper().deleteGoodsIncompare("Удалить список");
    Assert.assertTrue((app.getCompareGoodsPageHelper().chekingDeleteGoodsInCompare("Товаров нет.")));
  }
}
