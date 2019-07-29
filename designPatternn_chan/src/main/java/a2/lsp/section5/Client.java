package a2.lsp.section5;

import java.util.HashMap;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class Client
{
    public static void invoker()
    {
        //有父类的地方就有子类
        Father f1 = new Father();
        Son f2 = new Son();
        HashMap map = new HashMap();
        f1.doSomething(map);
        f2.doSomething(map);
    }

    public static void main(String[] args)
    {
        invoker();
    }
}
