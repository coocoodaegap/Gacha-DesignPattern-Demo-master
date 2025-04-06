package gacha.templatemethod;

import gacha.statepattern.DrawContext;

// 模板方法：抽卡流程
public abstract class AbstractDrawProcess
{

    public final void performDraw(DrawContext context)
    {
        if (newDraw()) context.newDraw();
        this.handleDraw(context);
    }

    protected boolean newDraw()
    {
        return false;
    }

    protected abstract void handleDraw(DrawContext context);

}
