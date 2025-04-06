package carditem.factorymethod;

public class SRCharacterCard extends CharacterCard
{
    public SRCharacterCard(String name)
    {
        super(name, CardRank.SR);
    }

    @Override
    public String toString()
    {
        return level.name() + "角色 " + name;
    }
}
