package com.hisun.kont.pg.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jcL
 * @create: 2021/5/25 18:03
 */
public class MTDismantleReqDTO {
    @ApiModelProperty(
            name = "msgStr",
            value = ""
    )
    private String msgStr;

    public String getMsgStr() {
        return msgStr;
    }

    public void setMsgStr(String msgStr) {
        this.msgStr = msgStr;
    }
}
