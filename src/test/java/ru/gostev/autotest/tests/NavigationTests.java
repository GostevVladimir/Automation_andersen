package ru.gostev.autotest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTests extends TestBase{

  @Test(enabled = true)
  public void navigationTest(){
/*    app.getNavigationPageHelper().goToMainPage();
    app.getNavigationPageHelper().goToVideoPage("Видео");
    Assert.assertTrue(app.getNavigationPageHelper().chekingTextFromPage("Свежее видео",
            app.getNavigationPageHelper().textFromVideoPage, 5 ));
    Assert.assertTrue(app.getNavigationPageHelper().checkingNavigators("https://yandex.ru/video/"));
    app.getNavigationPageHelper().goToMainPage();
    app.getNavigationPageHelper().goToPicturePage("Картинки");
    Assert.assertTrue(app.getNavigationPageHelper().chekingTextFromPage("Мои коллекции",
            app.getNavigationPageHelper().textFromPicturePage, 5 ));
    Assert.assertTrue(app.getNavigationPageHelper().checkingNavigators("https://yandex.ru/images/"));
    app.getNavigationPageHelper().goToMainPage();
    app.getNavigationPageHelper().goToNewsPage("Новости");
    Assert.assertTrue(app.getNavigationPageHelper().chekingTextFromPage("ПОЛИТИКА",
            app.getNavigationPageHelper().textFromNewsPage, 5 ));
    Assert.assertTrue(app.getNavigationPageHelper().checkingNavigators("https://news.yandex.ru/"));
    app.getNavigationPageHelper().goToMainPage();
    app.getNavigationPageHelper().goToMapsPage("Карты");
    Assert.assertTrue(app.getNavigationPageHelper().chekingTextFromPage("Поиск мест и адресов",
            app.getNavigationPageHelper().textFromMapsPage, 5));
    Assert.assertTrue(app.getNavigationPageHelper().checkingNavigators("https://yandex.ru/maps/"));*/

    app.getNavigationPageHelper().goToMainPage();
    app.getNavigationPageHelper().goToMarketPage("Маркет");
/*    Assert.assertTrue(app.getNavigationPageHelper().chekingTextFromPage("Маркет",
            app.getNavigationPageHelper().textFromMarketPageElem, 5 ));*/
/*    Assert.assertTrue(app.getNavigationPageHelper().chekingTextFromMarketPage("Популярные товары"));*/
    Assert.assertTrue(app.getNavigationPageHelper().waitLink("Компьютеры", app.getNavigationPageHelper().elementYandexMarket, 5));
    Assert.assertTrue(app.getNavigationPageHelper().checkingNavigators("https://market.yandex.ru"));

/*        app.getNavigationPageHelper().goToMainPage();
    app.getNavigationPageHelper().goToInterpreterPage("Переводчик");
    Assert.assertTrue(app.getNavigationPageHelper().chekingTextFromPage("Переводчик",
            app.getNavigationPageHelper().textFromInterpreterPage, 5 ));
    Assert.assertTrue(app.getNavigationPageHelper().checkingNavigators("https://translate.yandex.ru/"));
  app.getNavigationPageHelper().goToMainPage();
    app.getNavigationPageHelper().goToMusicPage("Музыка");
    Assert.assertTrue(app.getNavigationPageHelper().chekingTextFromPage("ПЛЕЙЛИСТЫ С НОВИНКАМИ",
            app.getNavigationPageHelper().textFromMusicPage, 5 ));
    Assert.assertTrue(app.getNavigationPageHelper().checkingNavigators("https://music.yandex.ru/home"));*/


  }
}
