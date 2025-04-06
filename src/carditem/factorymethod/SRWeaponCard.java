package carditem.factorymethod;

public class SRWeaponCard extends WeaponCard
{
    public SRWeaponCard(String name)
    {
        super(name, CardRank.SR);
    }

    @Override
    public String toString()
    {
        return level.name() + "武器 " + name;
    }
}
