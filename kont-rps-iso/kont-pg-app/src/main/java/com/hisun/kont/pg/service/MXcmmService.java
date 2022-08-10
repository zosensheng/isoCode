package com.hisun.kont.pg.service;

import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.metadata.common.apiid.ApiId;
import com.hisun.kont.pg.mx.remote.*;

public interface MXcmmService {
    @ApiId(Id = "0007000505912164")
    GenericRspDTO<QueryButtenPgtctlRspDTO> queryButtenPgtctl(GenericDTO<QueryButtenPgtctlReqDTO> reqDto);

    @ApiId(Id = "0007000505912166")
    GenericRspDTO<UpdateListPgtctlRspDTO> updateListPgtctl(GenericDTO<UpdateListPgtctlReqDTO> reqDto);

    @ApiId(Id = "0007000505912171")
    GenericRspDTO<CheckTransferLimitRspDTO> checkTransferLimit (GenericDTO<CheckTransferLimitReqDTO> reqDto);
}