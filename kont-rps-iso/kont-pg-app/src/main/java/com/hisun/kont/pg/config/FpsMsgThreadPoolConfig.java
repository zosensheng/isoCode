//package com.hisun.kont.pg.config;
//
//import com.hisun.kont.pg.constants.MTConstants;
//import org.springframework.context.annotation.Bean;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.Executor;
//import java.util.concurrent.ThreadPoolExecutor;
//
///**
// * Created by zhangyu on 2019/9/10.
// */
//@Component
//public class FpsMsgThreadPoolConfig {
//
//	@Bean(MTConstants.TASK_REALTIME_SEND_THREADPOOL_NAME)
//	public Executor asyncRealTimeSendExecutor() {
//		Integer availibleNum = Runtime.getRuntime().availableProcessors();
//
//		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//		executor.setCorePoolSize(availibleNum);
//		executor.setMaxPoolSize(availibleNum * 2);
//		executor.setQueueCapacity(100);
//		executor.setKeepAliveSeconds(60);
//		executor.setThreadNamePrefix(MTConstants.TASK_REALTIME_SEND_THREADPOOL_NAME);
//		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//		return executor;
//	}
//}
