package com.easy.cloundmes.analysis;

import java.util.concurrent.ThreadFactory;

/**
 * @author zhaohan
 */

public class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {

        return new Thread(r);

    }

}
