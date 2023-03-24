package utils;

import static utils.Variables.*;

public class Settings {

    public static final String DRIVER = PropertiesUtils.getEnv("browser");
    public static Clusters currentCluster = Clusters.Stage;

}
