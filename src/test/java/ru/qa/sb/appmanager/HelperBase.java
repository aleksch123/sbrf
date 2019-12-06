package ru.qa.sb.appmanager;
import org.openqa.selenium.WebDriver;

public class HelperBase {

protected WebDriver wd;

public HelperBase(WebDriver wd) {
  this.wd=wd;
}
}
