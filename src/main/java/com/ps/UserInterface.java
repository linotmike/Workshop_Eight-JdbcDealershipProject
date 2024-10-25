package com.ps;

public class UserInterface {


    public static void init(){
        DealershipFileManager.getDealership();

    }
    public static void display(){
        init();
        DealershipFileManager.getDealership();
    }
}
