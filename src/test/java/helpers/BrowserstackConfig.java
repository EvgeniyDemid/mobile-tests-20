package helpers;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
		"classpath:config/${env}.properties",
		"classpath:config/base.properties"
})
public interface BrowserstackConfig extends Config {

	@Key("user")
	String getUser();

	@Key("key")
	String getKey();

	@Key("app")
	String getApp();

	@Key("device")
	String getDevice();

	@Key("os_version")
	String getOsVersion();

	@Key("project")
	String getProject();

	@Key("build")
	String getBuild();

	@Key("name")
	String getName();

	@Key("urlRemoteWebDriver")
	String getUrlRemoteWebDriver();
}
