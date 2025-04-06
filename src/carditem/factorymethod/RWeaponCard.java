package carditem.factorymethod;

// 具体类：不同等级的武器卡
public class RWeaponCard extends WeaponCard
{
    public RWeaponCard(String name)
    {
        super(name, CardRank.R);
    }

    @Override
    public String toString()
    {
        return level.name() + "武器 " + name;
    }
}
