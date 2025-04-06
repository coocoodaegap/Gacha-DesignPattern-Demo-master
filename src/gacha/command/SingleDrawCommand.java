package gacha.command;

import gacha.statepattern.DrawContext;
import gacha.templatemethod.AbstractDrawProcess;

// 单抽命令
public class SingleDrawCommand implements Command
{
    private AbstractDrawProcess drawProcess;
    private DrawContext context;

    public SingleDrawCommand(AbstractDrawProcess drawProcess, DrawContext context)
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
