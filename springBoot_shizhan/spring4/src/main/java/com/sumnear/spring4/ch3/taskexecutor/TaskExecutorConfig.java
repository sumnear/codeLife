package com.sumnear.spring4.ch3.taskexecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.PreDestroy;
import java.util.concurrent.Executor;


@Configuration
@ComponentScan("com.sumnear.spring4.ch3.taskexecutor")
@EnableAsync //1
public class TaskExecutorConfig implements AsyncConfigurer
{//2
    private static  ThreadPoolTaskExecutor taskExecutor;
    @Override
    public Executor getAsyncExecutor()
    {//2
        taskExecutor  = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler()
    {
        return null;
    }

    @PreDestroy
    public void destroy()
    {
        while (taskExecutor.getActiveCount()>1){
            System.out.println(taskExecutor.getActiveCount());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
          taskExecutor.shutdown();
//        taskExecutor.destroy();
//        taskExecutor.shutdown();
        System.out.println("jsr250-destory-method");
    }

}
