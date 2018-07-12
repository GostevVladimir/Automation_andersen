package ru.gostev.autotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;
  private YandexMainPageHelper yandexMainPageHelper;

  protected void init() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    wd.get("https://www.yandex.ru/");
    yandexMainPageHelper = new YandexMainPageHelper(wd);
  }

  protected void stop() {
    wd.quit();
  }

  public YandexMainPageHelper getYandexMainPageHelper() {
    return yandexMainPageHelper;
  }
}
