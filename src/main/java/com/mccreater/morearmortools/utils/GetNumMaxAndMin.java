package com.mccreater.morearmortools.utils;

import org.checkerframework.checker.units.qual.A;

import java.text.DecimalFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class GetNumMaxAndMin {
    public static Vector<Float> getFloat(){
        Vector<Float> result = new Vector<>();
        HashMap<String , Integer> hashMap = new HashMap<String , Integer>();
        hashMap.put("t",0);
        System.out.println(hashMap.get("t"));
        result.add(Float.MAX_VALUE);
        result.add(Float.MIN_VALUE);
        return result;
    }
    public static Vector<Double> getDouble(){
        Vector<Double> result = new Vector<>();
        result.add(Double.MAX_VALUE);
        result.add(Double.MIN_VALUE);
        return result;
    }
    public static Vector<Short> getShort(){
        Vector<Short> result = new Vector<>();
        result.add(Short.MAX_VALUE);
        result.add(Short.MIN_VALUE);
        return result;
    }
    public static Vector<Integer> getInt(){
        Vector<Integer> result = new Vector<>();
        result.add(Integer.MAX_VALUE);
        result.add(Integer.MIN_VALUE);
        return result;
    }
    public static Vector<Long> getLong(){
        Vector<Long> result = new Vector<>();
        result.add(Long.MAX_VALUE);
        result.add(Long.MIN_VALUE);
        return result;
    }
    public static Vector<Integer> getYear(){
        Vector<Integer> result = new Vector<>();
        result.add(Year.MAX_VALUE);
        result.add(Year.MIN_VALUE);
        return result;
    }
    public static Vector<Byte> getByte(){
        Vector<Byte> result = new Vector<>();
        result.add(Byte.MAX_VALUE);
        result.add(Byte.MIN_VALUE);
        return result;
    }
    public static Vector<Character> getChar(){
        Vector<Character> result = new Vector<>();
        result.add(Character.MAX_VALUE);
        result.add(Character.MIN_VALUE);
        return result;
    }
}
