package config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.load("application.conf");
    }

    String userDir = readConfig().getString("user.dir");
    String reportDirectory = readConfig().getString("report.directory");
    String URL = readConfig().getString("url");
    String DB_USERNAME = readConfig().getString("users.dbUser.login");
    String DB_PASSWORD = readConfig().getString("users.dbUser.password");
    String UI_USERNAME = readConfig().getString("users.uiUser.login");
    String UI_PASSWORD = readConfig().getString("users.uiUser.password");
}