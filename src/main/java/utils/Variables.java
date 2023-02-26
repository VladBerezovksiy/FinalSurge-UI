package utils;

import java.util.HashMap;
import java.util.Map;

public class Variables {

    /********************************************* DRIVER TYPES ****************************************************/

    public static final String GOOGLE_CHROME = "GC";
    public static final String FIREFOX = "FF";
    public static final String EDGE = "EG";


    /**************************************** WINDOWS VERSIONS *******************************************************/

    public enum OSVersions {
        WIN7, WIN10
    }


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

    public static final String PROJECT_UPLOAD_TEST_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\uploadtest\\";
    public static final String PROJECT_DOWNLOAD_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\download\\";
    public static final String PROJECT_SCREENSHOT_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\screenshots\\";
    public static final String PROJECT_SIKULI_PATTERNS_WIN7 = System.getProperty("user.dir") + "\\src\\main\\resources\\sikuli_patterns_win7\\";
    public static final String PROJECT_SIKULI_PATTERNS_WIN10 = System.getProperty("user.dir") + "\\src\\main\\resources\\sikuli_patterns_win10\\";


    /******************************************* SIKULI PATTERNS *************************************************/

    public static final String WINDOWS_10_NAME = "win10";
    public static final String WINDOWS_7_NAME = "win7";
    public static final String UPLOAD_INPUT = "upload_input.png";
    public static final String UPLOAD_BUTTON = "upload_button.png";
    public static final String UPLOAD_CANCEL = "upload_cancel.png";
    public static final String WINDOWS_CLOSE = "windows_close.png";
    public static final String KEEP_FILE = "keep_file.png";
    public static final String PRINT_CANCEL = "print_cancel.png";
    public static final String PRINT_CLOSE = "print_close.png";


    /****************************************** FILES EXTENSIONS ************************************************/

    public static final String FILE_ZIP = ".zip";
    public static final String FILE_EML = ".eml";
    public static final String FILE_CSV = ".csv";
    public static final String FILE_VCF = ".vcf";


    /******************************************* CLUSTERS ******************************************************/

    public enum Clusters {
        Stage
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

    public static final String COLLABORATOR_EMAIL = envSet[1][1];
    public static final String COLLABORATOR_PASSWORD = envSet[1][2];

    public static final String NONEXISTENT_EMAIL = "nonexistingemail@domain.org";
    public static final String INCORRECT_PASSWORD = "NonExisting#123";

    public static final String SEND_TO[] = {envSet[0][1], envSet[1][1]};
    public static final String EXAMPLE_MESSAGE = "Test messageOne";
    public static final int FILE_UPLOAD_LIMIT = 5;


    public static final String IMAGE_PATH = "file.jpg";
    public static final String FILE_DOCX = "file.docx";
    public static final String FILE_PDF = "file.pdf";

    public static final String IMAGE2_PATH = "jpg_new.jpg";
    public static final String DOCX2_PATH = "docx_new.docx";
    public static final String PDF2_PATH = "pdf_new.pdf";
    public static final String PNG2_PATH = "png_new.png";
    public static final String XLS2_PATH = "xls_new.xls";

    public static final String DELETE_FILE1_PATH = "filetoDelete.docx";
    public static final String DELETE_FILE2_PATH = "filetoDelete.pdf";
    public static final String BIGSIZE_PATH = "bigsize.txt";
    public static final String OTHER_FILES_PATH = "\"file.docx\" \"file.pdf\" \"file.txt\" \"file.xlsx\"";
    public static final String OTHER_FILES_AND_BIGSIZE_PATH = OTHER_FILES_PATH + " \"" + BIGSIZE_PATH + "\"";


    /**************************************** SOCIAL ACCOUNTS ********************************************************/

    public static final String LINKEDIN_URL = "https://www.linkedin.com/";
    public static final String TWITTER_URL = "https://twitter.com/";
    public static final String FACEBOOK_URL = "https://www.facebook.com/";
    public static final String SOCIAL_EMAIL = "vsmekhnov25@gmail.com";
    public static final String SOCIAL_PASSWORD = "Temp1234%";
    public static final String FACEBOOK_EMAIL = "test1936fcsd@gmail.com";
    public static final String FACEBOOK_PASSWORD = "it8sx989";


    /****************************************** REMOTE ACCOUNTS ******************************************************/

    public static final String GMAIL_URL = "https://gmail.com";
    public static final String GMAIL_EMAIL = "nonwm583@gmail.com";
    public static final String GMAIL_PASSWORD = "Temp1234%";

    public static final String CURRENT_PLATFORM_EMAIL = "auto2@ashustikov.hostopia.com";
    public static final String CURRENT_PLATFROM_PASSWORD = "J~&dD2c5=QK";
    public static final String GMAIL_REMOTE_EMAIL = "qatestwebmail@gmail.com";
    public static final String GMAIL_REMOTE_PASSWORD = "qr6m7ju2";
    public static final String OUTLOOK_EMAIL = "honcharova.o@outlook.com";
    public static final String OUTLOOK_PASSWORD = "qr6m7ju2";
    public static final String YAHOO_EMAIL = "qatestwebmail1@yahoo.com";
    public static final String YAHOO_PASSWORD = "qr6m7ju2";
    public static final String CUSTOM_EMAIL = "webmail.remote@gmail.com";
    public static final String CUSTOM_PASSWORD = "Temp1234%";


    /****************************************** GENERAL CSS ********************************************************/

    public static final String CSS_OPEN_CLASS = "open";
    public static final String CSS_HIDE_CLASS = "ng-hide";
    public static final String CSS_REQUIRED_ATR = "required";
    public static final String CSS_VALUE_ATR = "value";
    public static final String CSS_CLASS_ATR = "class";
    public static final String CSS_STYLE_ATR = "style";
    public static final String CSS_BORDER_ATR = "border-left";
    public static final String CSS_DATA_ORIG_TITLE = "data-original-title";
    public static final String CSS_COLOR = "color";
    public static final String CSS_BORDER_COLOR = "border-color";
    public static final String CSS_CHECKED_CLASS = "fa-check-square";
    public static final String CSS_SLIDER_OPEN_CLASS = "slideopen";
    public static final String CSS_TEXT_CONTENT_ATTR = "textContent";
    public static final String CSS_ERROR_PASS_CLASS = "errorPass";
    public static final String CSS_ERROR_CLASS = "error";
    public static final String CSS_TEXT_DECORATION = "text-decoration";
    public static final String CSS_LINE_THROUGH = "line-through";
    public static final String CSS_PAPERCLIP_CLASS = "fa-paperclip";
    public static final String CSS_SECONDARY_CALENDAR_CLASS = "fa-circle";
    public static final String CSS_TODAY_ACTIVE_CLASS = "fc-state-disabled";
    public static final String CSS_SHOW_ATTACHMENT_ALERTS_CHECKED_ATTR = "aria-checked";
    public static final String CSS_SELECT_CHECKBOX_CLASS = "checkboxShow";
    public static final String CSS_SELECT_STAR_CLASS = "flagShow";
    public static final String CSS_CLASS_MESSAGE_UNREAD = "messageUnread";
    public static final String CSS_CLASS_MESSAGE_LIST_SPLIT = "split";
    public static final String CSS_CLASS_MESSAGE_LIST_FULL = "full";
    public static final String CSS_CLASS_IN = "in";
    public static final String CSS_ARIA_EXPANDED_ATTR = "aria-expanded";
    public static final String CSS_ARIA_SELECTED_ATTR = "aria-selected";
    public static final String CSS_VALUE_TRUE = "true";
    public static final String CSS_VALUE_FALSE = "false";
    public static final String CSS_CLASS_ACTIVE = "active";


}