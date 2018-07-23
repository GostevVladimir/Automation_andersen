package ru.gostev.autotest.tests;

import org.testng.annotations.Test;


public class LocationTest extends TestBase {

  @Test
  public void locationTest() {
    app.getYandexMainPageHelper().goToLacationpage();
    app.getLocationPageHelper().enteringAnotherCity("Милан");
    String[] before = app.getYandexMainPageHelper().getListElementYet();
    app.getYandexMainPageHelper().goToLacationpage();
    app.getLocationPageHelper().enteringAnotherCity("Париж");
    String[] after = app.getYandexMainPageHelper().getListElementYet();
    app.getYandexMainPageHelper().equalsList(before, after);
  }
}


