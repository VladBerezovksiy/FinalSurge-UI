package utils;

import java.util.HashMap;
import java.util.Map;

public class Variables {


    /********************************************* DRIVER TYPES ****************************************************/

    public static final String GOOGLE_CHROME = "CHROME";
    public static final String FIREFOX = "FIREFOX";
    public static final String EDGE = "EDGE";


    /******************************* THREAD SLEEP VALUES FOR MAKING PAUSES *******************************************/

    public static final int VERY_SHORT_SLEEP = 500;
    public static final int SHORT_SLEEP = 1000;
    public static final int NORMAL_SLEEP = 3000;
    public static final int LONG_SLEEP = 5000;
    public static final int VERY_LONG_SLEEP = 7000;
    public static final int VERY_LONG_SLEEP3 = 15000;
    public static final int VERY_LONG_SLEEP2 = 150000;
    public static final int VERY_LONG_SLEEP1 = 25000;


    /******************************* FOLDERS CONTAINING FILES FOR UPLOAD TESTS ***************************************/

    public static final String PROJECT_DOWNLOAD_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\download\\";
    public static final String PROJECT_SCREENSHOT_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\screenshots\\";


    /******************************************* CLUSTERS ******************************************************/

    public enum Clusters {
        Stage, Prod
    }

    public static final Map<Clusters, String[][]> clusters = createClusters();

    public static Map<Clusters, String[][]> createClusters() {
        Map<Clusters, String[][]> map = new HashMap<>();
        map.put(Clusters.Stage, new String[][]{
                {"https://log.finalsurge.com", "email1@domain.com", "Temp1234%"},
                {"https://log.finalsurge.com", "email2@domain.com", "Temp1234%"},
                {"https://log.finalsurge.com", "email2@domain.com", "Temp1234%"}

        });
        return map;
    }

    public static final String[][] envSet = clusters.get(Settings.currentCluster);


    /*****************************************************************************************************************/

    public static final String MIME_TYPES = "application/vnd.ms-excel,application/zip,application/x-7z-compressed,application/xml," +
            "application/x-rar-compressed,image/png,image/jpeg,text/calendar,text/csv,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,text/vcard";

    public static final String FINALSURGE_URL = envSet[0][0];

    public static final String MAIN_ACCOUNT = envSet[0][1];
    public static final String MAIN_PASSWORD = envSet[0][2];

    public static final String NONEXISTENT_EMAIL = "nonexistingemail@domain.org";
    public static final String INCORRECT_PASSWORD = "NonExisting#123";

    public static final String SEND_TO[] = {envSet[0][1], envSet[1][1]};

    public static final String IMAGE_PATH = "file.jpg";
    public static final String FILE_DOCX = "file.docx";
    public static final String FILE_PDF = "file.pdf";

}
