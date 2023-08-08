package helpers;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
		"classpath:{env}.properties"
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
}
