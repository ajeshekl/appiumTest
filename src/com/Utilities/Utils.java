package com.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

public class Utils {
	public static void captureScreen(WebDriver driver) throws IOException {
		String imageName = System.currentTimeMillis() + ".png";
		File file = ((TakesScreenshot) new Augmenter().augment(driver))
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")
				+ "/Screenshot/" + imageName));
	}

}
