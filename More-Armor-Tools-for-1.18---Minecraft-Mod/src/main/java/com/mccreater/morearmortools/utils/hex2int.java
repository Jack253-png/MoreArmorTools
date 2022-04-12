package com.mccreater.morearmortools.utils;

public class hex2int {
    public String toint(String s) {
        //d7c144a860
        int result;
        if (s.contains(".")) {
            return s;
        } else {
            result = 0;
            for (int i = 0; i < 10; i++) {
                result += hex1int(String.valueOf(s.charAt(i))) * (int) Math.pow(16, 10 - (i + 1));
            }
        }
        return String.valueOf(Math.abs(result));
    }
    public int hex1int(String s){
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
