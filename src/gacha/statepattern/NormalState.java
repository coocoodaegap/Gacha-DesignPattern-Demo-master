package gacha.statepattern;

// 普通状态
public class NormalState extends DrawState
{
    public NormalState(DrawContext context)
    {
        super(context);
    }

    @Override
    public boolean handleState()
    {
        if (context.isLimited() && context.getMissedPickUp())
        {
            if (context.getDrawCount() >= context.getGuaranteeCount())
                context.setState(new LimitedGuaranteeState(context));
            else context.setState(new PostGuaranteeState(context));
        }
        else if (context.getDrawCount() >= context.getGuaranteeCount())
            context.setState(new GuaranteeState(context));
        else if (context.tenDrawAllR())
        {
            context.setState(new TenDrawGuaranteeState(context));
        }
        return false;
    }
}
