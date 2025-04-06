package gacha.statepattern;

public class PostGuaranteeState extends DrawState
{
    public PostGuaranteeState(DrawContext context)
    {
        super(context);
    }

    @Override
    public boolean handleState()
    {
        if (!context.getMissedPickUp())
            context.setState(new NormalState(context));
        else
        {
            if (context.getDrawCount() >= context.getGuaranteeCount())
                context.setState(new LimitedGuaranteeState(context));
            else if (context.tenDrawAllR())
            {
                context.setState(new TenDrawGuaranteeState(context));
            }
        }
        return false;
    }
}
