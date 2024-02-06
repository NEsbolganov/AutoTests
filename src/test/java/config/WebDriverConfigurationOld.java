package config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class WebDriverConfigurationOld {

    public String getBaseUrl(){
        String baseUrl = System.getProperty("baseUrl");

        if(Objects.isNull(baseUrl)){
            baseUrl = "https://github.com";
        }
        return baseUrl;
    }


    public Browser getBrowser(){
        String browser = System.getProperty("browser");
        if(Objects.isNull(browser)){
            browser = "Chrome";
        }
        return Browser.valueOf(browser);
    }

    public URL getRemoteUrl(){
        String remoteUrl = System.getProperty("URL");

        if(Objects.isNull(remoteUrl)){
            remoteUrl = "https://localhost:4444";
        }
        try {
            return new URL(remoteUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
