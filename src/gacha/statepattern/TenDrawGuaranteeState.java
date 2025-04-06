package gacha.statepattern;

import carditem.factorymethod.CardRank;

public class TenDrawGuaranteeState extends DrawState
{
    public TenDrawGuaranteeState(DrawContext context)
    {
        super(context);
    }

    @Override
    public boolean handleState()
    {
        context.setDrawnItem(CardRank.SR);
        if (context.isLimited() && context.getMissedPickUp())
            context.setState(new PostGuaranteeState(context));
        else context.setState(new NormalState(context));
        return true;
    }
}
