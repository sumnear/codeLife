package com.sumnear.limiting;

/**
 * 
 * @author SumNear
 * @date 2017年11月1日 上午10:42:25 
 * @Description: 是否通过的函数式接口
 */
@FunctionalInterface
public interface LimitingInterface {

	public boolean isAllow();
}
