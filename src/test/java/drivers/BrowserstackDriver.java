package drivers;

import com.codeborne.selenide.WebDriverProvider;
import helpers.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
	static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
	@Nonnull
	@Override
	public WebDriver createDriver(@Nonnull Capabilities capabilities) {
		MutableCapabilities mutableCapabilities = new MutableCapabilities();
		mutableCapabilities.merge(capabilities);

		// Set your access credentials
		mutableCapabilities.setCapability("browserstack.user", config.getUser());
		mutableCapabilities.setCapability("browserstack.key", config.getKey());

		// Set URL of the application under test
		mutableCapabilities.setCapability("app", "bs://sample.app");
		// Specify device and os_version for testing
		System.out.println(config.getKey()+"!!!!!!!!!!!!!!!!");
		System.out.println(System.getProperties().getProperty("env")+"!!!!!!!!!!!!!!!!");
		mutableCapabilities.setCapability("device", config.getDevice());
		mutableCapabilities.setCapability("os_version", config.getOsVersion());

		// Set other BrowserStack capabilities
		mutableCapabilities.setCapability("project", "First Java Project");
		mutableCapabilities.setCapability("build", "browserstack-build-1");
		mutableCapabilities.setCapability("name", "first_test");


		// Initialise the remote Webdriver using BrowserStack remote URL
		// and desired capabilities defined above
		try {
			return new RemoteWebDriver(
					new URL("http://hub.browserstack.com/wd/hub"), mutableCapabilities);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
}