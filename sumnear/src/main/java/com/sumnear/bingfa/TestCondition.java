package com.sumnear.bingfa;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestCondition {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();
}
