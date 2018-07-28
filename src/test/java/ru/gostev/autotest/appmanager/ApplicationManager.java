package ru.gostev.autotest.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;
  private YandexMainPageHelper yandexMainPageHelper;
  private WeatherPageHelper weatherPageHelper;
  private LocationPageHelper locationPageHelper;
  private NavigationPageHelper navigationPageHelper;
  private MarketPageHelper marketPageHelper;
  private LoptopPageHalper loptopPageHalper;
  private CompareGoodsPageHelper compareGoodsPageHelper;


  public void init() {
    wd = new ChromeDriver();
    wd.manage().window().maximize();
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    yandexMainPageHelper = new YandexMainPageHelper(wd);
    marketPageHelper = new MarketPageHelper(wd);
    navigationPageHelper = new NavigationPageHelper(wd);
    yandexMainPageHelper.openSearchPage();
    weatherPageHelper = new WeatherPageHelper(wd);
    locationPageHelper = new LocationPageHelper(wd);
    loptopPageHalper = new LoptopPageHalper(wd);
    compareGoodsPageHelper = new CompareGoodsPageHelper(wd);
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
  public MarketPageHelper getMarketPageHelper() {
    return marketPageHelper;
  }
  public NavigationPageHelper getNavigationPageHelper() {
    return navigationPageHelper;
  }
  public LoptopPageHalper getLoptopPageHalper() {
    return loptopPageHalper;
  }
  public CompareGoodsPageHelper getCompareGoodsPageHelper() {
    return compareGoodsPageHelper;
  }
}
