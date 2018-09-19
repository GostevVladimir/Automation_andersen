package ru.gostev.autotest.tests;

import org.testng.annotations.Test;


public class LocationTest extends TestBase {

  @Test
  public void locationTest() {
    app.getYandexMainPageHelper().goToLacationPage();
    app.getLocationPageHelper().enteringAnotherCity("Милан");
    String[] before = app.getYandexMainPageHelper().getListElementYet();
    app.getYandexMainPageHelper().goToLacationPage();
    app.getLocationPageHelper().enteringAnotherCity("Москва");
    String[] after = app.getYandexMainPageHelper().getListElementYet();
    app.getYandexMainPageHelper().assertEqualsList(before, after);
  }
}


