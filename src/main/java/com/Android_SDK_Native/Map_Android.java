package com.Android_SDK_Native;

import io.appium.java_client.android.AndroidElement;


public class Map_Android {
    public static AndroidElement FindInitialiseButton()
    {
        return Driver_Property.Android_Driver.findElementById("com.sheeda.sampleapp:id/btn_init");
    }

    public static AndroidElement FindShowIntestetialButton()
    {
        return Driver_Property.Android_Driver.findElementById("com.sheeda.sampleapp:id/btn_show_int");
    }

    public static AndroidElement FindLoadRewardedButton()
    {
        return Driver_Property.Android_Driver.findElementById("com.sheeda.sampleapp:id/btn_int_rew");
    }

    public static AndroidElement FindShowRewardedButton()
    {
        return Driver_Property.Android_Driver.findElementById("com.sheeda.sampleapp:id/btn_show_rew");
    }

    public static AndroidElement FindShowIconAdButton()
    {
        return Driver_Property.Android_Driver.findElementById("com.sheeda.sampleapp:id/btn_show_icon_ad");
    }

    public static AndroidElement FindHideIconAdButton()
    {
        return Driver_Property.Android_Driver.findElementById("com.sheeda.sampleapp:id/btn_hide_icon_ad");
    }

    public static AndroidElement FindShowBannerButton()
    {
        return Driver_Property.Android_Driver.findElementById("com.sheeda.sampleapp:id/btn_show_banner");
    }

    public static AndroidElement FindHideBannerButton()
    {
        return Driver_Property.Android_Driver.findElementById("com.sheeda.sampleapp:id/btn_hide_banner");
    }

    public static AndroidElement FindSelectSceneForAd()
    {
        return Driver_Property.Android_Driver.findElementById("android:id/text1");
    }

    public static AndroidElement FindMapSceneFrameView()
    {
        return Driver_Property.Android_Driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout");
    }

    public static AndroidElement FindShowNativeButton()
    {
        return Driver_Property.Android_Driver.findElementById("com.sheeda.sampleapp:id/btn_show_native");
    }

    public static AndroidElement FindShowBannerTwoButton()
    {
        return Driver_Property.Android_Driver.findElementById("com.sheeda.sampleapp:id/btn_show_banner2");
    }

    public static AndroidElement FindNativeAdMainButton()
    {
        return Driver_Property.Android_Driver.findElementById("com.sheeda.sampleapp:id/btn_show_ad");
    }

    public static AndroidElement FindDestroyNativeAdMainButton()
    {
        return Driver_Property.Android_Driver.findElementById("com.sheeda.sampleapp:id/btn_destroy_ad");
    }

    public static AndroidElement FindSwtichToMainScreen()
    {
        return Driver_Property.Android_Driver.findElementById("com.sheeda.sampleapp:id/btn_go_back");
    }

    public static AndroidElement FindHideBannerTwoButton()
    {
        return Driver_Property.Android_Driver.findElementById("com.sheeda.sampleapp:id/btn_hide_banner2");
    }
}
