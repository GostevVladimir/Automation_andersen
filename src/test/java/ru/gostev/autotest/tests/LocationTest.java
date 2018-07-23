package ru.gostev.autotest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;


public class LocationTest extends TestBase {

  @Test
  public void locationTest() {
    app.getYandexMainPageHelper().goToLacationpage();
    app.getLocationPageHelper().enteringAnotherCity("Милан");
    String[] before = app.getYandexMainPageHelper().getListElementYet();
    app.getYandexMainPageHelper().goToLacationpage();
    app.getLocationPageHelper().enteringAnotherCity("Москва");
    String[] after = app.getYandexMainPageHelper().getListElementYet();
    Assert.assertTrue(app.getYandexMainPageHelper().equalsList(before, after));
  }
}


