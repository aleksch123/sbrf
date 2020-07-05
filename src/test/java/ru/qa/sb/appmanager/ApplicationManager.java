package ru.qa.sb.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qa.sb.pageobjects.YandexPage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

WebDriver wd;
private final Properties properties;
private String browser;
private YandexPage yandexPage;
public Map<String, Object> vars;


public ApplicationManager(String browser) {
  this.browser = browser;
  properties = new Properties();

}

public void init() throws IOException {
  wd = new ChromeDriver();
  properties.load(new FileReader(new File("src/test/resources/test.properties")));
  wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  wd.get(properties.getProperty("web.baseUrl"));
  wd.manage().window().maximize();
  vars = new HashMap<String, Object>();
  vars.put("window_handles", wd.getWindowHandles());
  yandexPage = new YandexPage(wd);

}

public void stop() {
  wd.quit();
}

public YandexPage yandex() {
  return yandexPage;
}

}
