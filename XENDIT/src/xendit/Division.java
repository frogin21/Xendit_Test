package xendit;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;




public class Division {
  private static WebDriver driver;
  private static String baseUrl;


  public static void setUp() throws Exception { 
	System.setProperty("webdriver.chrome.driver","/Applications/Katalon Studio.app/Contents/Eclipse/configuration/resources/drivers/chromedriver_mac/chromedriver");
     driver = new ChromeDriver();
    baseUrl = "https://www.online-calculator.com/full-screen-calculator/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   
    
  }

  
  public void TC_Division() throws Exception {
	  Division.setUp();
	  driver.get(baseUrl);
      driver.manage().window().maximize();
     
     // Going to Canvas frame
      new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("fullframe")));
      WebElement canvas = new WebDriverWait(driver, 10).until( ExpectedConditions.elementToBeClickable(By.id("canvas")));

      //Screenshots frame with result=2 
      new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(-(174/5)*2,(255/6)*3).click().build().perform();
      new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset((174/2)*2,(255/6)*5).click().build().perform();
      Thread.sleep(3000);
      Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver);
      ImageIO.write(logoImageScreenshot.getImage(),"png",new File("/Users/rachmat/Desktop/Division_ACT.png"));
      
      //clear
      new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset((174/2)*2,(255/6)*(-3)).click().build().perform();
      //clicking on 6
      new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(-(174/5)*1,(255/6)*2).click().build().perform();
      //clicking on the substract sign (:)
      new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset((174/3)*2,(255/6)*(-1)).click().build().perform();
      //clicking on 3
      new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(-(174/5)*1,(255/6)*3).click().build().perform();
      //clicking on equals to sign (=)
      new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset((174/2)*2,(255/6)*5).click().build().perform();
      
      
    //Compare image
      
      BufferedImage expectedImage = ImageIO.read(new File("/Users/rachmat/Desktop/Division_ACT.png"));
          
      Screenshot logoImageScreenshot2 = new AShot().takeScreenshot(driver);
      ImageIO.write(logoImageScreenshot2.getImage(),"png",new File("/Users/rachmat/Desktop/Division_EXP.png"));
      BufferedImage actualImage = logoImageScreenshot2.getImage();
            
      ImageDiffer imgDiff = new ImageDiffer();
      ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
      if(diff.hasDiff()==true)
      {
      System.out.println("Images are Not Same");
      }
      else {
      System.out.println("Images are Same");
      }
      driver.close();
      
  }  
  
  public void CEFunction() throws Exception {
	    driver.get(baseUrl);
	    driver.manage().window().maximize();
	   
	    new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("fullframe")));
	    WebElement canvas = new WebDriverWait(driver, 10).until( ExpectedConditions.elementToBeClickable(By.id("canvas")));
	    
	  //clicking on 6
	    new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(-(174/5)*1,(255/6)*2).click().build().perform();
	  //clicking on the substract sign (-)
	    new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset((174/5)*2,(255/6)*3).click().build().perform();
	  //clicking on 3
	    new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(-(174/5)*1,(255/6)*3).click().build().perform();
	  //clicking on equals to sign (=)
	    new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset((174/2)*2,(255/6)*5).click().build().perform();
	 
	  //clicking on CE red button
	    new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset((174/2)*2,(255/6)*(-3)).click().build().perform();
	    
	    driver.close();
	  
  }
  

  
}
