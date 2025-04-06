package gacha.statepattern;

// 抽卡状态
public abstract class DrawState
{
    protected DrawContext context;
    public DrawState(DrawContext context)
    {
        this.context = context;
    }

    public abstract boolean handleState();
}
