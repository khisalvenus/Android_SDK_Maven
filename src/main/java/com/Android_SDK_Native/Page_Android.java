package com.Android_SDK_Native;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static java.lang.Thread.sleep;

public class Page_Android {
    public static void FindAndClickInitialiseButton() throws InterruptedException {
        Map_Android.FindInitialiseButton().click();
        sleep(2000);
    }

    public static void FindAndClickShowInterstetialButton() throws InterruptedException {
        Map_Android.FindShowIntestetialButton().click();
        sleep(2000);
    }

    public static void FindAndClickLoadRewardedButton() throws InterruptedException {
        Map_Android.FindLoadRewardedButton().click();
        sleep(2000);
    }
    public static void FindAndClicShowRewardedButton() throws InterruptedException {
        Map_Android.FindShowRewardedButton().click();
        sleep(2000);
    }

    public static void FindAndClickShowIconAdButton() throws InterruptedException {
        Map_Android.FindShowIconAdButton().click();
        sleep(2000);
    }
    public static void FindAndClickHideIconAdButton() throws InterruptedException {
        Map_Android.FindHideIconAdButton().click();
        sleep(2000);
    }
    public static void FindAndClickShowBannerButton() throws InterruptedException {
        AndroidElement element = Map_Android.FindShowBannerButton();
        Actions action = new Actions(Driver_Property.Android_Driver);
        action.moveToElement(element).build().perform();
        //action.perform();
        element.click();
        sleep(2000);
    }
    public static void FindAndClickHideBannerButton() throws InterruptedException {
        AndroidElement element = Map_Android.FindHideBannerButton();
        Actions action = new Actions(Driver_Property.Android_Driver);
        action.moveToElement(element).build().perform();
        element.click();
        sleep(2000);
        sleep(2000);
    }

    public static void FindAndClickSelectSceneForAd() throws InterruptedException {
        Map_Android.FindSelectSceneForAd().click();
        sleep(2000);
    }
    public static void FindAndClickShowNativeButton() throws InterruptedException {
        Map_Android.FindShowNativeButton().click();
        sleep(2000);
    }

    public static void FindAndClickShowBannerTwoButton() throws InterruptedException {
        AndroidElement element = Map_Android.FindShowBannerTwoButton();
        Actions action = new Actions(Driver_Property.Android_Driver);
        action.moveToElement(element).perform();
        element.click();
        sleep(2000);
    }

    public static void FindAndClickHideBannerTwoButton() throws InterruptedException {
        Map_Android.FindHideBannerTwoButton().click();
        sleep(2000);
    }
    public static void FindAndClickShowNativeAdMainButton() throws InterruptedException {
        Map_Android.FindNativeAdMainButton().click();
        sleep(2000);
    }

    public static void FindAndClickDestroyNativeAdMainButton() throws InterruptedException {
        Map_Android.FindDestroyNativeAdMainButton().click();
        sleep(2000);
    }

    public static void FindAndClickSwtichToMainScreen() throws InterruptedException {
        Map_Android.FindSwtichToMainScreen().click();
        sleep(2000);
    }


    public static void FindSceneFrameView(int val) throws InterruptedException {
        AndroidElement frameView = Map_Android.FindMapSceneFrameView();
        sleep(2000);
        List<MobileElement> elements = frameView.findElements(By.xpath(".//*"));
        Thread.sleep(100);
        elements.get(val).click();
    }




}