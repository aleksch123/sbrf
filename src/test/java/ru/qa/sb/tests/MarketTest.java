package ru.qa.sb.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.util.List;
@Features("Search")

public class MarketTest extends TestBase {

@Stories("Comparison of filter and search results")
@Test
 public void pageMarketTest() throws InterruptedException {

    app.yandex().goToMarket()
                .switchToNextPage()
                .goToComputers()
                .goToNotebooks()
                .openFilter()
                .setDownRange(10000)
                .setUpRange(60000)
                .setVendorName("HP")
                .setVendorName("Lenovo")
                .showResults()
                .showDozen();
    List<WebElement> noteList= app.yandex().getList();
    Assert.assertEquals(noteList.size(),12,"Notebooks list size doesn't match with expectation");
     String target = noteList.get(0).getText();
    app.yandex().getSearch(target);
    Assert.assertTrue(app.yandex().isTargetPresent(target),"Target Notebook doesn't shown on search page");
    System.out.println(target);






    //Thread.sleep(5000);
  }


}
