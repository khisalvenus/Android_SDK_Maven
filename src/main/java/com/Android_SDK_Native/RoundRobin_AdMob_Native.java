package com.Android_SDK_Native;
import org.testng.annotations.Test;

import java.io.IOException;

public class RoundRobin_AdMob_Native extends Extenstion{
    @Test
    public static void RoundRobin_AdMob_Native_First() throws InterruptedException, IOException {
        //Thread.sleep(20000);
        Page_Android.FindAndClickInitialiseButton();
        Thread.sleep(30000);
       for(int sceneIndex=2;sceneIndex<=2;sceneIndex++) {
           Page_Android.FindAndClickSelectSceneForAd();
           Thread.sleep(2000);
           Page_Android.FindSceneFrameView(sceneIndex);
           Thread.sleep(2000);
           Page_Android.FindAndClickShowIconAdButton();
           Thread.sleep(1000);
           Extenstion.CaptureScreenShot("Icon");
           Thread.sleep(2000);
           Page_Android.FindAndClickHideIconAdButton();
           Thread.sleep(2000);
       }
      // Extenstion.Save_LogCat_Logs();
       //logs_validation_Icon();
       Page_Android.FindAndClickSelectSceneForAd();
        Page_Android.FindSceneFrameView(2);
        for(int sceneIndex=2;sceneIndex<=14;sceneIndex++) {
            Page_Android.FindAndClickShowBannerButton();
            Thread.sleep(1000);
            Extenstion.CaptureScreenShot("Banner");
            Thread.sleep(2000);
            Page_Android.FindAndClickHideBannerButton();
            Thread.sleep(2000);
        }
        Page_Android.FindAndClickSelectSceneForAd();
        Thread.sleep(2000);
        Page_Android.FindSceneFrameView(2);
        Thread.sleep(2000);
        Page_Android.FindAndClickShowBannerTwoButton();
        Thread.sleep(2000);
        Extenstion.CaptureScreenShot("Banner2");
        Thread.sleep(2000);
        Page_Android.FindAndClickHideBannerTwoButton();
        Thread.sleep(2000);
        for(int i=0;i<=7;i++) {
            Page_Android.FindAndClickShowNativeButton();
            Thread.sleep(2000);
            Page_Android.FindAndClickShowNativeAdMainButton();
            Extenstion.CaptureScreenShot("Native");
            Thread.sleep(2000);
            Page_Android.FindAndClickDestroyNativeAdMainButton();
            Thread.sleep(2000);
        Page_Android.FindAndClickSwtichToMainScreen();
        Thread.sleep(100);

        }
        // Extenstion.Save_LogCat_Logs();
        //second scene index
        // mainDriver.startActivity(activity1);
    }
}
