package ru.gostev.autotest.tests;

import org.testng.annotations.Test;

public class MarketTests extends TestBase{
  @Test
  public void equalsListMarket() throws InterruptedException {
    app.getMarketPageHelper().openMarketPage();
    app.getMarketPageHelper().moveToCategory();
    app.getMarketPageHelper().moveToShowBy("Показывать по 12");
    app.getMarketPageHelper().equalsList(12);
    app.getMarketPageHelper().moveToShowBy("Показывать по 48");
    app.getMarketPageHelper().equalsList(48);
  }
}
