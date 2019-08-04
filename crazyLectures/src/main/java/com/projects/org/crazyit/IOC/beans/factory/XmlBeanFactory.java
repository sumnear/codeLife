package com.projects.org.crazyit.IOC.beans.factory;


import com.projects.org.crazyit.IOC.context.AbstractApplicationContext;

/**
 * Bean创建工厂, 该类初始化时不创建任何的对象
 * 
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
public class XmlBeanFactory extends AbstractApplicationContext
{

	public XmlBeanFactory(String[] xmlPaths) {
		//只初始化文档, 不创建任何bean
		super.setUpElements(xmlPaths);
	}
}
