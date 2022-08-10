//package com.hisun.kont.pg.operation;
//
//import com.hisun.kont.common.exception.KontException;
//import com.hisun.kont.pg.constants.MTConstants;
//import com.hisun.kont.pg.operation.runnable.FpsMsgBatchReceiveRunnable;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//import java.util.concurrent.Executor;
//
//@Component
//public class FpsMsgReceiveOperation {
//
//    public static final Logger logger = LoggerFactory.getLogger(FpsMsgReceiveOperation.class);
//
//
//    //配置线程池
//    @Autowired
//    @Qualifier(MTConstants.TASK_REALTIME_SEND_THREADPOOL_NAME)
//    private Executor asyncRealTimeRecExecutor;
//
//
//    /**
//     * 异步提交
//     */
//    public void receiveBatchFpsMsg() throws KontException {
//        logger.info("接收批量文件报文数据转换成功开始处理业务逻辑！");
//        FpsMsgBatchReceiveRunnable fpsMsgBatchReceiveRunnable = new FpsMsgBatchReceiveRunnable();
//        this.asyncRealTimeRecExecutor.execute(fpsMsgBatchReceiveRunnable);
//        }
//    }
//
//
//
