package ru.gostev.autotest.tests;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondTest extends TestBase {

  @Test
  public void secondTest() {
    app.getYandexMainPageHelper().goToLacationpage();
    app.getLocationPageHelper().enteringAnotherCity("Милан");
    app.getYandexMainPageHelper().getListElementYet();
    String[] before = app.getYandexMainPageHelper().getListElementYet();
    app.getYandexMainPageHelper().goToLacationpage();
    app.getLocationPageHelper().enteringAnotherCity("ddd");
    app.getYandexMainPageHelper().getListElementYet();
    String[] after = app.getYandexMainPageHelper().getListElementYet();
    app.getYandexMainPageHelper().equalsList(before, after);
    Arrays.equals(before, after);
  }

}


