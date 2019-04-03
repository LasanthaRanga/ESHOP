package com.eshop.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class SMSsend {

    static String mggg = "cheack";
    static String id = "94767365725";
    static String pw = "1548";

    static String to;

    static String IR;

    public static String sss;

    public static void setIr(String ir) {
        sss = "ESHOP+Registration+Complete+" + ir + "+TheankYou";
    }

    public static void setMobile(String mobile) {
        to = mobile;
    }

    public static String sendBulckSms() {
        try {
            URL textit = new URL("http://textit.biz/sendmsg/index.php?id=" + id + "&pw=" + pw + "&to=" + to + "&text=" + sss + "");
            BufferedReader in = new BufferedReader(new InputStreamReader(textit.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
            return sss;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean netIsAvailable() {
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        if (netIsAvailable()) {
            sendBulckSms();
        }
    }

}
