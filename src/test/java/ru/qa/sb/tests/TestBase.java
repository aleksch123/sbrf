package ru.qa.sb.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.qa.sb.appmanager.ApplicationManager;

public class TestBase {
public static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

@BeforeSuite
public void setUp() throws Exception {
  app.init();
}

@AfterSuite(alwaysRun = true)
public void tearDown() {
  app.stop();
}
}
