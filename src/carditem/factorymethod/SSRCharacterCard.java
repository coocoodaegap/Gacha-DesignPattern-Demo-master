package carditem.factorymethod;

public class SSRCharacterCard extends CharacterCard
{
    public SSRCharacterCard(String name)
    {
        super(name, CardRank.SSR);
    }
    public SSRCharacterCard(String name, CardRank attach)
    {
        super(name, attach);
    }

    @Override
    public String toString()
    {
        return level.name() + "角色 " + name;
    }
}
