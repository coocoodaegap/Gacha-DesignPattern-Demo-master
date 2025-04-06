package carditem.factorymethod;

// 武器卡工厂
public class WeaponCardFactory implements CardFactory
{
    @Override
    public Card createCard(String name, CardRank level)
    {
        switch (level)
        {
            case R:
                return new RWeaponCard(name);
            case SR:
                return new SRWeaponCard(name);
            case SSR:
                return new SSRWeaponCard(name);
            case LIMITED_SSR:
                return new SSRWeaponCard(name, CardRank.LIMITED_SSR);
        }
        return null;
    }
}
