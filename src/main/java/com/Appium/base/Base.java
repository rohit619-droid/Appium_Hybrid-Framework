package com.Appium.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
	public static AppiumDriverLocalService service;

//appium taskill - taskkll /F /IM node.exe
	public AppiumDriverLocalService startServer() {

		boolean flag = checkIfServerIsRunnning(4723);
		File file = new File("C:\\Users\\rohit\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\appium.js");
		System.out.println("TIs == > " + file.getName());
		System.out.println("Boolean == > " + file.exists());
		if (!flag) {
			service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
					.withAppiumJS(new File(
							"C:\\Users\\rohit\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723));
			service.start();
			System.out.println("Start");
		}
		return service;
	}

	public static void startEmulator() throws IOException, InterruptedException {

		Runtime.getRuntime()
				.exec(System.getProperty("user.dir") + "\\src\\main\\java\\com\\Appium\\resources\\startEmulator.bat");
		Thread.sleep(6000);
	}

	public static AndroidDriver<AndroidElement> capabilities(String apkFile) throws IOException, InterruptedException {
		AndroidDriver<AndroidElement> driver;
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\Appium\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		File f = new File("src");
		File fs = new File(f, (String) prop.get(apkFile));

		DesiredCapabilities cap = new DesiredCapabilities();
		//String device = (String) prop.get("device");
		//mvn test -Ddevicename=rohit
		String device = System.getProperty("deviceName");
		if (device.contains("rohit")) {
			startEmulator();
		}
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

}
