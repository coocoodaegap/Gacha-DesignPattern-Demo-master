package gacha.statepattern;

import carditem.factorymethod.CardRank;

// 限定保底状态
public class LimitedGuaranteeState extends DrawState
{
    public LimitedGuaranteeState(DrawContext context)
    {
        super(context);
    }

    @Override
    public boolean handleState()
    {
        context.setDrawnItem(CardRank.LIMITED_SSR);
        context.setState(new NormalState(context));
        return true;
    }
}
