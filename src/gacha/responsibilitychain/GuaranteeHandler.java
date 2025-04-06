package gacha.responsibilitychain;

import gacha.statepattern.DrawContext;

// 具体处理器：保底逻辑
public class GuaranteeHandler extends ChainHandler
{
    @Override
    public void handleRequest(DrawContext context)
    {
        boolean stopIt = context.handleState() || context.handleState();
//        context.debug();
        if (stopIt) return;
        if (next != null) next.handleRequest(context);
    }
}
