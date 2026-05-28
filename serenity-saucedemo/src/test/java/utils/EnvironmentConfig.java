package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class EnvironmentConfig {


    private static final Config DEFAULT_ENV = ConfigFactory
            .parseResources("serenity.conf")
            .resolve()
            .getConfig("environments.default");

    public static String getUsername() {
        return DEFAULT_ENV.getString("credentials.username");
    }

    public static String getPassword() {
        return DEFAULT_ENV.getString("credentials.password");
    }

    public static String getBaseUrl() {
        return DEFAULT_ENV.getString("webdriver.base.url");
    }

    private EnvironmentConfig() {
    }
}
