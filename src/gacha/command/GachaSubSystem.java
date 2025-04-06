package gacha.command;

import gacha.strategypattern.*;
import gacha.statepattern.DrawContext;
import gacha.responsibilitychain.ChainHandler;
import gacha.responsibilitychain.GuaranteeHandler;
import gacha.responsibilitychain.ProbabilityHandler;
import gacha.templatemethod.SingleDrawProcess;
import gacha.templatemethod.TenDrawProcess;
import user.observer.UserObserver;

public class GachaSubSystem
{
    private Command singleDrawCommand;
    private Command tenDrawCommand;
    private DrawContext context;
    private String detail;

    public GachaSubSystem(PoolType poolType, GachaPool gachaPool)
    {
        DrawStrategy strategy = null;
        switch (poolType)
        {
            case NORMAL:
                strategy = new NormalPoolStrategy();
                break;
            case LIMITED:
                strategy = new LimitedPoolStrategy();
                break;
            case NROMAL_WEAPON:
                strategy = new NormalWeaponPoolStrategy();
                break;
            case LIMITED_WEAPON:
                strategy = new LimitedWeaponPoolStrategy();
                break;
        }
        // 创建抽卡责任链
        ChainHandler probabilityHandler = new ProbabilityHandler(strategy);
        ChainHandler guaranteeHandler = new GuaranteeHandler();
        guaranteeHandler.setNext(probabilityHandler);

        gachaPool.setPrototypeMap(strategy.getPoolMap());
        detail = strategy.getDetail();

        UserObserver userObserver = new UserObserver();

        // 初始化抽卡上下文
        context = new DrawContext(userObserver.getTotalDrawCount(poolType == PoolType.LIMITED), poolType == PoolType.LIMITED || poolType == PoolType.LIMITED_WEAPON, userObserver.isMissedPickUp(), 50, gachaPool);
        // 给上下文添加观察者
        context.addObserver(userObserver);

        // 初始化单抽和十连抽命令
        this.singleDrawCommand = new SingleDrawCommand(new SingleDrawProcess(guaranteeHandler), context);
        this.tenDrawCommand = new TenDrawCommand(new TenDrawProcess(guaranteeHandler), context);
    }

    public void singleDraw()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("单抽！");
        singleDrawCommand.execute();
    }

    public void tenDraw()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("10连！");
        tenDrawCommand.execute();
    }

    public int getDrawCountLeft()
    {
        return context.getGuaranteeCount() - context.getDrawCount();
    }

    public String getDetail()
    {
        return detail;
    }
}
