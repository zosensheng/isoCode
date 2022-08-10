package com.hisun.kont.pg.utils;
import java.util.UUID;


public class GenF121Utils {


    public static String GenF121Id() {
        UUID uuid = UUID.randomUUID();
        String uuid36 = uuid.toString();
        return  uuid36;
    }


}
