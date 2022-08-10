

import com.hisun.kont.mx.msg.javabean.head00100102.BusinessApplicationHeaderV02;


 
 
 
public enum BscMsgCd {

    
     
     
    SUCCESS("BSC00000"),
    
     
     
    MSG_BSC27001("BSC27001"),
    
     
     
    MSG_BSC27002("BSC27002"),
    
     
     
    MSG_BSC27003("BSC27003"),
    
     
     
    MSG_BSC27004("BSC27004"),
    
     
     
    MSG_BSC27005("BSC27005"),
    
     
     
    MSG_BSC27006("BSC27006"),
    
     
     
    MSG_BSC27007("BSC27007"),
    
     
     
    MSG_BSC27008("BSC27008"),
    
     
     
    MSG_BSC27009("BSC27009");


    
     
     
    private String msgCd;

    private BscMsgCd(String msgCd) {
        this.msgCd = msgCd;
    }

    public String getMsgCd() {
        return msgCd;
    }

    public void setMsgCd(String msgCd) {
        this.msgCd = msgCd;
    }


}
