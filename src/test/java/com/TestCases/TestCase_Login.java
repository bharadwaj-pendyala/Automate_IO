package com.TestCases;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.Allocator.Allocator;
import com.PageObjects.Automate_IO_HomePage;

public class TestCase_Login extends Allocator {

	@Before
	public void setup() throws IOException {
		init();
	}

	@Test
	public void executeTestCase() throws IOException {
		Automate_IO_HomePage hm = new Automate_IO_HomePage(driver);
		hm.login();
	}

	@After
	public void tearDown() {
		closeBrowser();
	}

}
