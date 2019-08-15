package com.sumnear.spring4.ch1.di;

import org.springframework.stereotype.Service;

/**
 * @authore sumnear
 * @create 2019-2-18 14:57
 */
@Service
public class FunctionService
{
    public String sayHello(String word)
    {
        return "hello " + word + " !";
    }
}
