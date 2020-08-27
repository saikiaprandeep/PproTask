
**System Requirements :**

1. Java 8 or above :
     -- Java 11 can be installed from -- https://aws.amazon.com/corretto/
2. Maven 
--Can be installed from -- https://maven.apache.org/
--------------------------------------------------------------------------------------

**Frameworks used :**

1. Test Framework used : TestNG and Selenium
2. Reporting Framework used : Extent Reports.
3. Logging Framework used : log4j.
4. For Reading Test Data Csv file is used.
5. DriverManager for browser drivers.
6. Pdf File reading -- Apache PDFBox
-----------------------------------------------------------------------------------------------------

**Run Configuration :**

1. Environment can be configured by maven options like (-Denv=dev) . If not configured default is dev.
2. Browser can be configured by maven options like (-Dbrowser=chrome) and in properties file like (browser=chrome). If nothing is configured default is chrome. Maven options takes priority over properties file.
3. Simple maven command to run tests  from command line  and  the Command line should be opened in project folder.
     
        mvn test  -DsuiteXmlFile=testng.xml  -Denv=dev  -Dbrowser=headless
4. Testng.xml is used to filter the test cases to run.  Like only regression test or only some module.
5. To run test classes in parallel , and the number of threads can be configured in testng.xml 
6. For reading or comparing pdfs , it picks pdf files from folder --- (src->test->resources->pdfFiles). Example to read pdf file:

        ReadPdfFile pdfFile = new ReadPdfFile();
        System.out.println(pdfFile.readPdf("filename"));

-----------------------------------------------------------------------------------------------------
**Location of files or folders:**

1. Logs generated under logs folder.
2. Reports generated under src->test->reports folder . Reports location can be changed from extent.properties under src->main->resources.
3. Test data can be found under src->test->resources->testData folder.
4. Properties file under src->main->resources.   properties file are environment specific like : dev.config.properties or qa.config.properties.
5. testng.xml is under root project folder.  
6. Tests can be found under src->test->java->com->ppro->web->test

-----------------------------------------------------------------------------------------------------
**Other Features:**
1.Retry failed test cases : failed tests can retry to run . The number of retries can be   configured in RetryAnalyzer class.
2.Test classes can run in parallel and can be configured in testng.xml
