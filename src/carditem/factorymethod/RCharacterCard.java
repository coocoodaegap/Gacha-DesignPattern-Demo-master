package carditem.factorymethod;

// 具体类：不同等级的角色卡
public class RCharacterCard extends CharacterCard
{
    public RCharacterCard(String name)
    {
        super(name, CardRank.R);
    }

    @Override
    public String toString()
    {
        return level.name() + "角色 " + name;
    }
}
