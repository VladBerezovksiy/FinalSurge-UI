package credentials;

import utils.PropertiesUtils;

// На самом деле это не будет работать!!!
public class LoginData {

    public static final String CLUSTER = PropertiesUtils.getEnv("clusters");
    public static final String BROWSER = PropertiesUtils.getEnv("browser");
    public static final String OS = PropertiesUtils.getEnv("os");


}
