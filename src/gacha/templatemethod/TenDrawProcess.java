package gacha.templatemethod;

import gacha.responsibilitychain.ChainHandler;
import gacha.statepattern.DrawContext;

// 十连抽
public class TenDrawProcess extends AbstractDrawProcess
{
    private ChainHandler handler;

    public TenDrawProcess(ChainHandler handler)
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
        for (int i = 0; i < 10; ++i)
        {
            context.incrementDrawCount();
            handler.handleRequest(context);
        }
    }
}
