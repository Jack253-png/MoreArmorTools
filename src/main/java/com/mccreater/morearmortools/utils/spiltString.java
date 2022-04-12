package com.mccreater.morearmortools.utils;

import com.mccreater.morearmortools.utils.hex2int;

public class spiltString {
    public String split(String s){
        String[] arrayList = s.split(" ");
        String s1 = "";
        s1 += arrayList[0];

        String[] version = arrayList[1].split("\\+");
        if (version.length == 1){
            s1 += " v"+version[0];
        }else{
            hex2int hex2int = new hex2int();

            s1 += " v"+version[0]+"(."+hex2int.toint(version[1])+")";
        }
        return s1;
    }
}
