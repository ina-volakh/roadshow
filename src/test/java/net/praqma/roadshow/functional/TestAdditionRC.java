package net.praqma.roadshow.functional;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAdditionRC {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {        
		selenium = new DefaultSelenium("roadshowseleniumserver", 44444, "*firefox", "http://roadshowtomcatserver:8080/");
		selenium.start();
	}

	@Test
	public void testAddition() throws Exception {
		selenium.open("/RoadShow/Calculator");
		selenium.type("name=value", "2");
		selenium.click("name=plus");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=value", "3");
		selenium.click("name=plus");
		selenium.waitForPageToLoad("30000");		
		assertEquals("5.0", selenium.getValue("name=result"));
	}

    @Test
	public void testMultiplication() throws Exception {
		selenium.open("/RoadShow/Calculator");
		selenium.type("name=value", "7");
		selenium.click("name=multiply");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=value", "6");
		selenium.click("name=multiply");
		selenium.waitForPageToLoad("30000");		
		assertEquals("42.0", selenium.getValue("name=result"));
	}
    
    @Test
	public void testSubtract() throws Exception {
		selenium.open("/RoadShow/Calculator");
		selenium.type("name=value", "7");
		selenium.click("name=multiply");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=value", "6");
		selenium.click("name=multiply");
		selenium.waitForPageToLoad("30000");		
		assertEquals("1.0", selenium.getValue("name=result"));
	}
    
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
