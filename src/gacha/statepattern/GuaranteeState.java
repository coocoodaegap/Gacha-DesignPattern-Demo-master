package gacha.statepattern;

import carditem.factorymethod.CardRank;

import java.util.Random;

// 保底状态
public class GuaranteeState extends DrawState
{
    public GuaranteeState(DrawContext context)
    {
        super(context);
    }

    @Override
    public boolean handleState()
    {
        if (context.isLimited())
        {
            Random random = new Random();
            boolean limited = random.nextBoolean();
            if (limited)
            {
                context.setDrawnItem(CardRank.LIMITED_SSR);
                context.setState(new NormalState(context));
            }
            else
            {
                context.setDrawnItem(CardRank.SSR);
                context.setState(new PostGuaranteeState(context));
            }
        } else
        {
            context.setDrawnItem(CardRank.SSR);
            context.setState(new NormalState(context));
        }
        return true;
    }
}
