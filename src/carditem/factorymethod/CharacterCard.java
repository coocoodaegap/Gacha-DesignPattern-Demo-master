package carditem.factorymethod;

// 抽象类：角色卡
public abstract class CharacterCard extends Card
{
    public CharacterCard(String name, CardRank level)
    {
        super(name, level);
    }
}
