package gacha.command;

import gacha.statepattern.DrawContext;
import gacha.templatemethod.AbstractDrawProcess;

// 十连抽命令
public class TenDrawCommand implements Command
{
    private AbstractDrawProcess drawProcess;
    private DrawContext context;

    public TenDrawCommand(AbstractDrawProcess drawProcess, DrawContext context)
    {
        this.drawProcess = drawProcess;
        this.context = context;
    }

    @Override
    public void execute()
    {
        drawProcess.performDraw(context);
        context.displayResults();
    }
}
