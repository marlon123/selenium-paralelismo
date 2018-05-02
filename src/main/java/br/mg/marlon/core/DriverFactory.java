package br.mg.marlon.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
//	private static WebDriver driver;
	
	//ThreadLocal que retorna um WebDriver
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
		@Override
		protected synchronized WebDriver initialValue(){
			return initDriver();
		}
	};
	
	private DriverFactory() {}
	
	//inicia uma thread e já retorna um WebDriver pra essa thread
	public static WebDriver getDriver(){
		return threadDriver.get();
	}
	
	public static WebDriver initDriver(){
		WebDriver driver = null;
		switch (Propriedades.browser) {
			case FIREFOX: driver = new FirefoxDriver(); break;
			case CHROME: driver = new ChromeDriver(); break;
		}
		driver.manage().window().setSize(new Dimension(800, 640));
		//driver.manage().window().maximize();
		return driver;
	}

	public static void killDriver(){
		WebDriver driver = getDriver(); //mata a instância do driver corrente
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		if(threadDriver != null) {//se a thread resisitir, force a remoção
			threadDriver.remove();
		}
	}
}
