package com.hisun.kont.mx.service.impl;


import com.alibaba.fastjson.JSON;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.mx.constant.SendMxConstant;
import com.hisun.kont.mx.service.MxMsgMainService;
import org.springframework.stereotype.Service;

@Service
public class MxMsgMainServiceImpl implements MxMsgMainService{

    /**
     * MX原文转换JSON格式
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<String> mxMsgToJson(GenericDTO<Object> reqDto) {
        GenericRspDTO<String> genericRspDTO = new GenericRspDTO<>();
        if (JudgeUtils.isNotNull(reqDto.getBody())){
            Object reqDtoBody = reqDto.getBody();
            String jsonString = JSON.toJSON(reqDtoBody).toString();
            genericRspDTO.setBody(jsonString);
            return genericRspDTO;
        }else {
            genericRspDTO.setMsgCd(SendMxConstant.MX_TO_JSON_ERROR);
            genericRspDTO.setMsgInfo(SendMxConstant.MX_TO_JSON_ERROR_INFO);
            return genericRspDTO;
        }

    }
}
