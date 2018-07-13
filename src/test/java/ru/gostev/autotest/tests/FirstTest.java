package ru.gostev.autotest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class FirstTest extends TestBase{

  @Test
   public void testFirst(){
     app.getYandexMainPageHelper().search("погода пензa");
     String textLink = app.getYandexMainPageHelper().textInThelink();
     String cityName = "Пензе";
     Assert.assertTrue(textLink.contains(cityName));
  }
}
