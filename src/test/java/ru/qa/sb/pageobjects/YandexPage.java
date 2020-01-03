package ru.qa.sb.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YandexPage {

protected WebDriver wd;

@FindBy(xpath = "//a[contains(text(),'Маркет')]")
private WebElement marketButton;

@FindBy(xpath = "//a[contains(.,'Компьютерная техника')]")
private WebElement computersButton;

@FindBy(linkText = "Ноутбуки")
private WebElement notebooksButton;

@FindBy(xpath = "//span[contains(.,'Все фильтры')]")
private WebElement allFilters;

@FindBy(id = "glf-pricefrom-var")
private WebElement rangeFrom;

@FindBy(id = "glf-priceto-var")
private WebElement rangeTo;

@FindBy(linkText = "Показать подходящие")
private WebElement resultsButton;

@FindBy(xpath = "//button[contains(.,'Показывать по')]")
private WebElement showAs;

@FindBy(xpath = "//input[@id='header-search']")
private WebElement searchField;

@FindBy(xpath = "//a[contains(text(),'Ноутбук')]")
private List<WebElement> noteList;

@FindBy(xpath = "//button[@type='submit']")
private WebElement searchButton;

@FindBy(css = ".n-search-preciser__text")
private WebElement endSearch;


public YandexPage(WebDriver wd) {
  PageFactory.initElements(wd, this);
  this.wd = wd;
}

public YandexPage goToMarket() {
  marketButton.click();
  return this;
}

public YandexPage goToComputers() {
  computersButton.click();
  return this;
}

public YandexPage goToNotebooks() {
  notebooksButton.click();
  return this;
}

public YandexPage openFilter() {
  allFilters.click();
  return this;
}

public YandexPage showResults() {
  resultsButton.click();
  return this;
}

public YandexPage setVendorName(String name) {
  WebElement vendorName = wd.findElement(By.xpath(String.format("//label[contains(.,'%s')]", name)));
  vendorName.click();
  return this;
}

public boolean isTargetPresent(String name) {
  WebElement note = wd.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", name)));

  return true;
}

public YandexPage setDownRange(int i) {
  rangeFrom.click();
  rangeFrom.sendKeys(Integer.toString(i));
  return this;
}

public YandexPage setUpRange(int i) {
  rangeTo.click();
  rangeTo.sendKeys(Integer.toString(i));
  return this;
}

public YandexPage showDozen() throws InterruptedException {
  showAs.click();
  showAs.sendKeys(Keys.UP, Keys.ENTER);
  Thread.sleep(2000);
  return this;
}

public List getList() {
  return noteList;
}

public String getSearch(String target) {

  searchField.click();
  searchField.sendKeys(target);
  searchButton.click();
  endSearch.isEnabled();
  return (noteList.get(0).getAttribute("title"));


}
}
