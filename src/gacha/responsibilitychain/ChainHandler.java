package gacha.responsibilitychain;

import gacha.statepattern.DrawContext;

// 抽象类：责任链处理器
public abstract class ChainHandler
{
    protected ChainHandler next;

    public void setNext(ChainHandler next)
    {
        this.next = next;
    }

    public abstract void handleRequest(DrawContext context);
}
