package com.hisun.kont.pg.service;

import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.pg.mt.remote.*;



public interface AssembleCheckService {
    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDto> assembleCheckMT103(GenericDTO<Fmt103> reqDto) ;

    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDto> assembleCheckMT202(GenericDTO<Fmt202> reqDto) ;

    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDto> assembleCheckMT200(GenericDTO<Fmt200> reqDto) ;

    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDtos> assembleCheckMT202Cov(GenericDTO<Fmt202Cov> reqDto) ;

    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDto> assembleCheckMT196(GenericDTO<Fmt196> reqDto) ;

    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDto> assembleCheckMT199(GenericDTO<Fmt199> reqDto) ;

    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDto> assembleCheckMT296(GenericDTO<Fmt296> reqDto) ;

    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDto> assembleCheckMT299(GenericDTO<Fmt299> reqDto) ;

    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDto> assembleCheckMT999(GenericDTO<Fmt999> reqDto) ;

    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDto> assembleCheckMT910(GenericDTO<Fmt910> reqDto) ;


    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDto> assembleCheckMT192(GenericDTO<Fmt192> reqDto) ;


    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDto> assembleCheckMT292(GenericDTO<Fmt292> reqDto) ;


    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDto> assembleCheckMT190(GenericDTO<Fmt190> reqDto) ;


    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDto> assembleCheckMT191(GenericDTO<Fmt191> reqDto) ;


    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDto> assembleCheckMT290(GenericDTO<Fmt290> reqDto) ;


    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDto> assembleCheckMT291(GenericDTO<Fmt291> reqDto) ;


    //MT103检查调用此方法，若需要做打包走上面的方法
    GenericRspDTO<MtDto> assembleCheckMT950(GenericDTO<Fmt950> reqDto) ;

    GenericRspDTO<MtDto> assembleCheckMT900(GenericDTO<Fmt900> reqDto) ;

    GenericRspDTO<MtDto> assembleCheckMT210(GenericDTO<Fmt210> reqDto) ;

    GenericRspDTO<MtDto> assembleCheckSingle202COV (GenericDTO<AssembleCheckSingle202COVReqDTO> reqDto);
}