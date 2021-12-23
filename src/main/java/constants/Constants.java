package constants;

import global.GlobalData;

public  class Constants {

    public static final String BASE_PACKAGE = "testsuite";
    public static final String FILENAME_TESTNG_XML = "testng.xml";
    public static final String TESTNG_XML_SUITE_NAME = "GenoSmart";
    public static final String TESTNG_XML_TEST_NAME = " GenoSmart Automation Suite";
    public static final String email="Email";
    public static final String email_Password="Email_Password";
    public static final String emailUserName="Email_User_Name";

    public static final class Timeouts {
        public static final int ELEMENT_TIMEOUT = 30;
        public static final int PAGE_LOAD_TIMEOUT = 120;
        public static final int LOADER_TIMEOUT = 50;
        public static final int DEFAULT_IMPLICIT_WAIT = 1;
    }

    public static final class Urls {
        public static final String URL_HOMEPAGE = GlobalData.BASE_URL;
    }

        public static final String PATH_CURRENT_WORKING_DIRECTORY = System.getProperty("user.dir");
        public static final String TEST_DATA_FOLDER_PATH = "src/main/resources/testdata/";
        public static final String FILEPATH_USERDATA = TEST_DATA_FOLDER_PATH + GlobalData.ENVIRONMENT.toLowerCase() + "/userdata.csv";
        public static final String FILEPATH_PDF_FILE = PATH_CURRENT_WORKING_DIRECTORY + "/" + TEST_DATA_FOLDER_PATH + GlobalData.ENVIRONMENT.toLowerCase()+ "/files/file.pdf";
        public static final String FILEPATH_DOC_FILE = PATH_CURRENT_WORKING_DIRECTORY + "/" + TEST_DATA_FOLDER_PATH + GlobalData.ENVIRONMENT.toLowerCase()+ "/files/file.doc";
        public static final String FILEPATH_PNG_FILE = PATH_CURRENT_WORKING_DIRECTORY + "/" + TEST_DATA_FOLDER_PATH + GlobalData.ENVIRONMENT.toLowerCase()+ "/files/file.png";
        public static final String FILEPATH_JPG_FILE = PATH_CURRENT_WORKING_DIRECTORY + "/" + TEST_DATA_FOLDER_PATH + GlobalData.ENVIRONMENT.toLowerCase()+ "/files/file.jpg";
        public static final String FILEPATH_XML_FILE = PATH_CURRENT_WORKING_DIRECTORY + "/" + TEST_DATA_FOLDER_PATH +"/files/SampleTest.xml";
        public static final String FILEPATH_FASTA_FILE = PATH_CURRENT_WORKING_DIRECTORY + "/" + TEST_DATA_FOLDER_PATH +"/files/SampleTest.fasta";
        public static final String FILEPATH_COMMON_TEXT = PATH_CURRENT_WORKING_DIRECTORY + "/" + TEST_DATA_FOLDER_PATH + "commonText.csv";
    }


