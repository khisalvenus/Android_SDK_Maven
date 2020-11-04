package com.Android_SDK_Native;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.Android_SDK_Native.Driver_Property.Android_Driver;

public class Extenstion {
    public static AppiumDriverLocalService service;
    public static LogEntries logs;
    public static Connection connection;
   //Constructor on class
    public static void Extension() {
    }

    //Start Appium Server
    @BeforeTest
    public static void Start_Appium() throws IOException, SQLException, ClassNotFoundException {
      //  OpenDbConnection();
       // ExecuteQuery(connection,"Select * from apps LIMIT 10");
        Process process;
        try {
            List<String> cmdList = new ArrayList<String>();
            // adding command and args to the list
            cmdList.add("sh");
            cmdList.add("/Volumes/DataDisk/Ahmadkhisal/Consoliads/Automation/Automation_Data/Appium.sh");
            ProcessBuilder processBuilder = new ProcessBuilder(cmdList);
            process = processBuilder.start();
            }
         catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/Cellar/node/14.7.0/bin/node")).withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").usingPort(4723).withLogFile(new File("/Volumes/DataDisk/Ahmadkhisal/Consoliads/Automation/Automation_Data/AppiumLog.txt")));

        try
        {
            service.start();
            System.out.println("Starting the appium server ...\n" + dateFormat.format(new Date()));
            Thread.sleep(10000);
        }
        //handling the exception
        catch(Exception e)
        {
            System.out.println(e);
        }
        //mainDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public static void InitialiseApplication() throws IOException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //desiredCapabilities.setCapability("deviceName", "Galaxy A7 (2018)");
        desiredCapabilities.setCapability("deviceName", "SamsungA71 API 30");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appPackage", "com.sheeda.sampleapp");
        desiredCapabilities.setCapability("appActivity", "com.sheeda.sampleapp.MainActivity");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("newCommandTimeout", 10000);
        AndroidDriver<AndroidElement> mainDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Android_Driver = mainDriver;
        String activity = mainDriver.currentActivity();
        Activity activity1 = new Activity("com.sheeda.sampleapp", "com.sheeda.sampleapp.MainActivity");
        Thread.sleep(40000);
    }

    //Stop Appium Server
    @AfterTest
    public static void Stop_Appium() {
        service.stop();
    }

    //Saving Logcat logs
    public static void Save_LogCat_Logs() throws IOException {
        Set<String> allLogType = Android_Driver.manage().logs().getAvailableLogTypes();
        Android_Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logs = Android_Driver.manage().logs().get("logcat");
        File LogCatFile = new File("/Volumes/DataDisk/Ahmadkhisal/Consoliads/Automation/Automation_Data/LogCat_Logs.txt");
        LogCatFile.createNewFile();
        LogCatFile.canWrite();
        FileOutputStream fostream = new FileOutputStream("/Volumes/DataDisk/Ahmadkhisal/Consoliads/Automation/Automation_Data/LogCat_Logs.txt");
        OutputStreamWriter oswriter = new OutputStreamWriter(fostream);
        BufferedWriter bwriter = new BufferedWriter(oswriter);
        for (LogEntry log:logs
        ) {
            if (log.getMessage().contains("CALogManager") || log.getMessage().contains("ConsoliAdsListners")) {
                bwriter.write(log.toString() + "\r\n");
              //  System.out.println(ansi().eraseLine(Ansi.Erase.ALL).fg(Ansi.Color.RED).a(log.toString()).a('\n').reset()
                        //.toString());
            }
        }
        bwriter.close();
        oswriter.close();
        fostream.close();
    }

    public static void logs_validation_Icon() throws IOException {
        int rowNumber = 39;
        int colNumber = 1;
        int sheetNumber = 0;
        boolean logValidated = true;
        String value;
        String s;
        for (colNumber = 1;colNumber<=4; colNumber++) {
            logValidated = true;
            value  = ExcelUtil.GetValueFromExcel(sheetNumber,colNumber,rowNumber);
            File f1=new File("/Volumes/DataDisk/Ahmadkhisal/Consoliads/Automation/Automation_Data/LogCat_Logs.txt"); //Creation of File Descriptor for input file
            FileReader fr = new FileReader(f1);  //Creation of File Reader object
            BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
            while ((s = br.readLine()) != null) {
                if (s.contains(value)) {
                    ExcelUtil.WriteToExcel(sheetNumber, rowNumber, colNumber, value, (byte) 0, (byte) 255);
                    logValidated = false;
                    break;
                }
            }
            if (logValidated == true)
            {
                ExcelUtil.WriteToExcel(sheetNumber, rowNumber, colNumber, value, (byte) 255, (byte) 0);
            }
        }
    }

    public static void CaptureScreenShot(String fileName) {
        String destinationDirectory = "/Volumes/DataDisk/Ahmadkhisal/Consoliads/Automation/Automation_Data/NativeScreenShots";
        File createdFile = ((TakesScreenshot) Android_Driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        new File(destinationDirectory).mkdirs();
        fileName = fileName + dateFormat.format(new Date()) + ".png";
        try {
            // Copy paste file at destination folder location
            FileUtils.copyFile(createdFile, new File(destinationDirectory + "/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void OpenDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://aurora-shoeda-2020aug21.cvpiqdvbgbus.us-west-2.rds.amazonaws.com/db_consoliads","sheeda_user","consoli123");
//        Android_Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void ExecuteQuery(Connection connection, String sqlQuery) throws SQLException {
        ResultSet resultSet;
        Statement statement;
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sqlQuery);
        while(resultSet.next())
        {
            System.out.println(resultSet.getString("appID"));
        }

    }
}
