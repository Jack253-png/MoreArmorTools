package com.mccreater.morearmortools.utils;

public class rgb2int {
    public static int toint(String s) {
        //d7c144a860
        int result;
        result = 0;
        for (int i = 0; i < 6; i++) {
            result += hex1int(String.valueOf(s.charAt(i))) * (int) Math.pow(16, 6 - (i + 1));
        }
        return Math.abs(result);
    }
    public static int hex1int(String s){
        return switch (s) {
            case "a" -> 10;
            case "b" -> 11;
            case "c" -> 12;
            case "d" -> 13;
            case "e" -> 14;
            case "f" -> 15;
            default -> Integer.parseInt(s);
        };
    }
}
