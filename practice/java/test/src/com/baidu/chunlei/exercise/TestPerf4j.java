package com.baidu.chunlei.exercise;

import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;

/**
 * 帮助：http://perf4j.codehaus.org/devguide.html
 * 解析log：java -jar perf4j-0.9.16.jar times.log
 * 生成图形html：java -jar .\perf4j-0.9.16.jar --graph perfGraphs.out .\log.txt
 * 
 * @author luxiaoyu01@baidu.com
 * @since 2014-7-23
 * @todo 
 */
public class TestPerf4j {

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
     // Create the LoggingStopWatch to start timing. This constructor takes the tag
     // name, which identifies the code block being timed. Note that usually you
     // will want to instantiate one of the subclasses of LoggingStopWatch, such as
     // a Log4JStopWatch or CommonsLogStopWatch depending on your preferred
     // logging framework.
     StopWatch stopWatch = new LoggingStopWatch("codeBlock1");

     // Execute the code block - this is just a dummy call to pause execution for
     // 0-1 second.
     Thread.sleep((long)(Math.random() * 1000L));

     // Stop the StopWatch and log it. LoggingStopWatches automatically log their
     // timing statements when one of the stop() or lap() methods are called.
     stopWatch.stop();
    }

}
