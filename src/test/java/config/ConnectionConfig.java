package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:${deviceHost}/connection.properties"
})
public interface ConnectionConfig extends Config {
    @Key("remoteUrl")
    String remoteUrl();

    @Key("appPath")
    String appPath();

    @Key("appURL")
    String appURL();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();
}
