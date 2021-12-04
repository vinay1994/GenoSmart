package utils;

import global.GlobalData;
import org.openqa.selenium.By;

public class Locator {
    By android;
    By ios;
    By web;

    private Locator() {

    }

    public static Locator builder() {
        return new Locator();
    }

    public By getBy() {
        switch (GlobalData.PLATFORM.toLowerCase()) {
            case "android":
                return this.getAndroid();
            case "ios":
                return this.getIos();
            default:
                return this.getWeb();
        }
    }

    public By getAndroid() {
        return android;
    }

    public By getIos() {
        return ios;
    }

    public By getWeb() {
        return web;
    }

    public Locator withWeb(By by) {
        this.web = by;
        return this;
    }

    public Locator withAndroid(By by) {
        this.web = by;
        return this;
    }

    public Locator withIOS(By by) {
        this.web = by;
        return this;
    }
}