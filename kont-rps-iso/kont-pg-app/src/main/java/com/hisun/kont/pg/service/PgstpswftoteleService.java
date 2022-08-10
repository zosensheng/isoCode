package com.hisun.kont.pg.service;

import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.utils.CnToTeleDO;


public interface PgstpswftoteleService {

    String getStringCnToTele(String str,String traditionalFlag);

    CnToTeleDO getStringCnToTele2(String str, String traditionalFlag);

    Fmt103 getTagCnToTeleFor103(Fmt103 fmt103, String traditionalFlag);

    Fmt200 getTagCnToTeleFor200(Fmt200 fmt200, String traditionalFlag);

    Fmt202 getTagCnToTeleFor202(Fmt202 fmt202, String traditionalFlag);

    F79 cnToTeleForN99(F79 f79,String traditionalFlag);

    F72 CnToTeleForF72(F72 f72,String traditionalFlag);

    Fmt210 getTagCnToTeleFor210(Fmt210 fmt210,String traditionalFlag);

    Fmt190 getTagCnToTeleFor190(Fmt190 fmt190,String traditionalFlag);

    Fmt290 getTagCnToTeleFor290(Fmt290 fmt290,String traditionalFlag);

    Fmt191 getTagCnToTeleFor191(Fmt191 fmt191,String traditionalFlag);

    Fmt291 getTagCnToTeleFor291(Fmt291 fmt291,String traditionalFlag);

    Fmt196 getTagCnToTeleFor196(Fmt196 fmt196,String traditionalFlag);

    Fmt296 getTagCnToTeleFor296(Fmt296 fmt296,String traditionalFlag);

    Fmt900 getTagCnToTeleFor900(Fmt900 fmt900,String traditionalFlag);

    Fmt910 getTagCnToTeleFor910(Fmt910 fmt910,String traditionalFlag);

    Fmt191 removeAcFor191(Fmt191 fmt191);

    Fmt291 removeAcFor291(Fmt291 fmt291);

}
