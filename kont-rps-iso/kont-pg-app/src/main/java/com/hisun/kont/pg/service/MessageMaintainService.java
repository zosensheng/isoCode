package com.hisun.kont.pg.service;


import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.pg.mt.remote.*;

public interface MessageMaintainService {
    GenericRspDTO<PrintMessageRspDTO> printMTMessage (GenericDTO<PrintMessageReqDTO> reqDto);

    GenericRspDTO<GetPrintMessageByNoRspDTO> getPrintMessageByNo (GenericDTO<GetPrintMessageByNoReqDTO> reqDto);

    GenericRspDTO<QueryMsgHisRecdRspDTO> queryMsgHisRecd (GenericDTO<QueryMsgHisRecdReqDTO> reqDto);

    GenericRspDTO<QueryMsgHisRecdByNoRspDTO> queryMsgHisRecdByNo (GenericDTO<QueryMsgHisRecdByNoReqDTO> reqDto);

    GenericRspDTO<QueryGpiMsgRspDTO> queryGpiMsg(GenericDTO<F20> reqDto);

    GenericRspDTO<CnToTeleNumRspDTO> cnToTeleNum(GenericDTO<CnToTeleNumReqDTO> reqDto);

    GenericRspDTO<QueryMsgByOurRefRspDTO> queryMsgByOurRef(GenericDTO<QueryMsgByOurRefReqDTO> reqDto);

    GenericRspDTO<CnLineWrapRspDTO> cnLineWrap(GenericDTO<CnLineWrapReqDTO> reqDto);

    GenericRspDTO<AmountToSwiftAmountRspDTO> amountToSwiftAmount(GenericDTO<AmountToSwiftAmountReqDTO> reqDto);

    GenericRspDTO<MatchOurRefByMsgNoRspDTO> matchOurRefByMsgNo(GenericDTO<MatchOurRefByMsgNoReqDTO> reqDto);

    GenericRspDTO<RateToSwiftRateRspDTO> rateToSwiftRate(GenericDTO<RateToSwiftRateReqDTO> reqDto);

    GenericRspDTO<SwiftRateToRateRspDTO> swiftRateToRate(GenericDTO<SwiftRateToRateReqDTO> reqDto);

    GenericRspDTO<SwiftAmountToAmountRspDTO> swiftAmountToAmount (GenericDTO<SwiftAmountToAmountReqDTO> reqDto);

    GenericRspDTO<QueryMatchMessageRspDTO> queryMatchMessage (GenericDTO<QueryMatchMessageReqDTO> reqDto);

    GenericRspDTO<StopPaymentMsgRspDTO> stopPaymentMsg (GenericDTO<StopPaymentMsgReqDTO> reqDto);

    GenericRspDTO<MtDto> SendTemporaryMt (GenericDTO<SendTemporaryMtReqDTO> reqDto);

    GenericRspDTO<GetFmt103MessageByMsgNoRspDTO> getFmt103MessageByMsgNo (GenericDTO<GetFmt103MessageByMsgNoReqDTO> reqDto);

    GenericRspDTO<GetFmt202MessageByMsgNoRspDTO> getFmt202MessageByMsgNo (GenericDTO<GetFmt202MessageByMsgNoReqDTO> reqDto);

    GenericRspDTO<Get202COVSeqbByMsgNoRspDTO> get202COVSeqbByMsgNo (GenericDTO<Get202COVSeqbByMsgNoReqDTO> reqDto);

    GenericRspDTO<CnToTeleNumFrontRspDTO> cnToTeleNumFront (GenericDTO<CnToTeleNumFrontReqDTO> reqDto);

    GenericRspDTO<UpdateGwMsgStatusToDeleRspDTO> updateGwMsgStatusToDele (GenericDTO<UpdateGwMsgStatusToDeleReqDTO> reqDto);

    GenericRspDTO<GetRmcTrx01ByMsgNoRspDTO> getRmcTrx01ByMsgNo (GenericDTO<GetRmcTrx01ByMsgNoReqDTO> reqDto);
}