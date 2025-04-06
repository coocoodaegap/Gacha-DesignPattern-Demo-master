package gacha.templatemethod;

import gacha.responsibilitychain.ChainHandler;
import gacha.statepattern.DrawContext;

// 单抽
public class SingleDrawProcess extends AbstractDrawProcess
{
    private ChainHandler handler;

    public SingleDrawProcess(ChainHandler handler)
    {
        this.handler = handler;
    }

    protected boolean newDraw()
    {
        return true;
    }

    @Override
    protected void handleDraw(DrawContext context)
    {
        context.incrementDrawCount();
        handler.handleRequest(context);
    }
}
