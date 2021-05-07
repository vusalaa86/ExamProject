package com.company;

import java.util.Scanner;

public class Util {

    public static String requireString(String title) {
        System.out.println(title);
        return new Scanner(System.in).nextLine();

    }
}