package facade;

import gacha.command.GachaSubSystem;
import gacha.strategypattern.*;
import user.Backpack;
import user.UserSingleton;

public class Facade
{
    private GachaSubSystem gachaSubSystem;

    private GachaPool gachaPool;

    private Backpack backpack;

    public Facade(String username)
    {
        UserSingleton.getInstance(username);
        gachaPool = new GachaPool();
        backpack = UserSingleton.getInstance().getBackpack();
    }

    public void registerGacha(int poolChoice)
    {
        PoolType poolType = PoolType.NORMAL;
        switch (poolChoice)
        {
            case 1:
                poolType = PoolType.LIMITED;
                break;
            case 2:
                poolType = PoolType.LIMITED_WEAPON;
                break;
            case 3:
                poolType = PoolType.NORMAL;
                break;
            case 4:
                poolType = PoolType.NROMAL_WEAPON;
                break;
        }
        gachaSubSystem = new GachaSubSystem(poolType, gachaPool);
    }

    public void getDrawCountLeft()
    {
        System.out.println("再抽" + gachaSubSystem.getDrawCountLeft() + "次必出SSR！");
    }

    public void singleDraw() {
        gachaSubSystem.singleDraw();
    }

    public void tenDraw()
    {
        gachaSubSystem.tenDraw();
    }

    public void getDetail()
    {
        System.out.println(gachaSubSystem.getDetail());
    }

    public void displayCharacterCards() {
        backpack.displayCharacterCards();
    }

    public void displayWeaponCards() {
        backpack.displayWeaponCards();
    }

}

