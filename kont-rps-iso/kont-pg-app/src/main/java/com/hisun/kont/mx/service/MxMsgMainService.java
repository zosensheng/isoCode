package com.hisun.kont.mx.service;

import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

public interface MxMsgMainService {

    GenericRspDTO<String> mxMsgToJson(@Validated @RequestBody GenericDTO<Object> reqDto);
}
