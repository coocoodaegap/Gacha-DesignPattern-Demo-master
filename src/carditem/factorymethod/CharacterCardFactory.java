package carditem.factorymethod;

// 角色卡工厂
public class CharacterCardFactory implements CardFactory
{
    @Override
    public Card createCard(String name, CardRank level)
    {
        switch (level)
        {
            case R:
                return new RCharacterCard(name);
            case SR:
                return new SRCharacterCard(name);
            case SSR:
                return new SSRCharacterCard(name);
            case LIMITED_SSR:
                return new SSRCharacterCard(name, CardRank.LIMITED_SSR);
        }
        return null;
    }
}
