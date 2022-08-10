package com.hisun.kont.pg.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jcL
 * @create: 2021/7/22 20:42
 */
public class MtMsgNoDTO {
    @ApiModelProperty(
            name = "msgNo",
            value = ""
    )
    private String msgNo;

    public String getMsgNo() {
        return msgNo;
    }

    public void setMsgNo(String msgNo) {
        this.msgNo = msgNo;
    }
}
