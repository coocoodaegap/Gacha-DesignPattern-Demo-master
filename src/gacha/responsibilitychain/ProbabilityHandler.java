package gacha.responsibilitychain;

import gacha.statepattern.DrawContext;
import gacha.strategypattern.DrawStrategy;

// 具体处理器：概率计算
public class ProbabilityHandler extends ChainHandler
{
    private DrawStrategy strategy;

    public ProbabilityHandler(DrawStrategy strategy)
    {
        this.strategy = strategy;
    }

    @Override
    public void handleRequest(DrawContext context)
    {
        // 根据策略计算抽卡结果
        context.setDrawnItem(strategy.calculateDraw());
        if (next != null) next.handleRequest(context);
    }
}
