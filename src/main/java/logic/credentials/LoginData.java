package logic.credentials;

import utils.PropertiesUtils;

public class LoginData {

    public static final String CLUSTER = PropertiesUtils.getEnv("clusters");
    public static final String BROWSER = PropertiesUtils.getEnv("browser");

}
