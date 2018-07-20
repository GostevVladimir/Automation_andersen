package ru.gostev.autotest.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;
  private YandexMainPageHelper yandexMainPageHelper;
  private WeatherPageHelper weatherPageHelper;
  private LocationPageHelper locationPageHelper;

  public void init() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    yandexMainPageHelper = new YandexMainPageHelper(wd);
    yandexMainPageHelper.openSearchPage();
    weatherPageHelper = new WeatherPageHelper(wd);
    locationPageHelper = new LocationPageHelper(wd);
  }

  public void stop() {
    wd.quit();
  }

  public YandexMainPageHelper getYandexMainPageHelper() {
    return yandexMainPageHelper;
  }

  public WeatherPageHelper getWeatherPageHelper() {
    return weatherPageHelper;
  }
  public LocationPageHelper getLocationPageHelper() {
    return locationPageHelper;
  }
}
