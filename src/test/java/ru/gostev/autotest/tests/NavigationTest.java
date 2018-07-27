package ru.gostev.autotest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends TestBase{

  @Test(enabled = true)
  public void navigationTest(){
    app.getNavigationPageHelper().goToMainPage();
    app.getNavigationPageHelper().goToVideoPage("Видео");
    Assert.assertTrue(app.getNavigationPageHelper().chekingTextFromPage("Свежее видео",
            app.getNavigationPageHelper().textFromVideoPage, 5 ));
    Assert.assertTrue(app.getNavigationPageHelper().checkingNavigators("https://yandex.ru/video/"));
    app.getNavigationPageHelper().goToMainPage();
    app.getNavigationPageHelper().goToMapsPage("Карты");
    Assert.assertTrue(app.getNavigationPageHelper().chekingTextFromPage("Поиск мест и адресов",
            app.getNavigationPageHelper().textFromMapsPage, 5));
    Assert.assertTrue(app.getNavigationPageHelper().checkingNavigators("https://yandex.ru/maps/"));
    app.getNavigationPageHelper().goToMainPage();
  }
}
