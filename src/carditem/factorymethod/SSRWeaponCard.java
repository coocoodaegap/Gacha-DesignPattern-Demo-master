package carditem.factorymethod;

public class SSRWeaponCard extends WeaponCard
{
    public SSRWeaponCard(String name)
    {
        super(name, CardRank.SSR);
    }
    public SSRWeaponCard(String name, CardRank attach)
    {
        super(name, attach);
    }

    @Override
    public String toString()
    {
        return level.name() + "武器 " + name;
    }
}
