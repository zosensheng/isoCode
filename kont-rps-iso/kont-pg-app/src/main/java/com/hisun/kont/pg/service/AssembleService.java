package com.hisun.kont.pg.service;

import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.framework.data.NoBody;
import com.hisun.kont.pg.mt.remote.*;


public interface AssembleService {
    GenericRspDTO<MtDto> assembleMT103 (GenericDTO<SendRemit103ReqDTO> reqDto);

    GenericRspDTO<NoBody> headerInfo (GenericDTO<SwHeader> reqDto);

    GenericRspDTO<MtDto> assembleMT910 (GenericDTO<SendRemit910ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleMT192 (GenericDTO<SendRemit192ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleMT292 (GenericDTO<SendRemit292ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleMT190 (GenericDTO<SendRemit190ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleMT202 (GenericDTO<SendRemit202ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleMT200 (GenericDTO<SendRemit200ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleMT191 (GenericDTO<SendRemit191ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleMT290 (GenericDTO<SendRemit290ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleMT291 (GenericDTO<SendRemit291ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleMT196 (GenericDTO<SendRemit196ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleMT950 (GenericDTO<SendRemit950ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleMT199 (GenericDTO<SendRemit199ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleMT299 (GenericDTO<SendRemit299ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleMT296 (GenericDTO<SendRemit296ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleMT999 (GenericDTO<SendRemit999ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleMT900 (GenericDTO<SendRemit900ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleMT210 (GenericDTO<SendRemit210ReqDTO> reqDto);

    GenericRspDTO<MtDtos> assembleMT202COV (GenericDTO<SendRemit202COVReqDTO> reqDto);

    GenericRspDTO<MtDtos> assemblDoubleMT202 (GenericDTO<AssemblDoubleMT202ReqDTO> reqDto);

    GenericRspDTO<MtDto> assembleSingle202COV (GenericDTO<AssembleSingle202COVReqDTO> reqDto);

}