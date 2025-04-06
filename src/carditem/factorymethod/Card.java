package carditem.factorymethod;

// 抽象类：卡片
public abstract class Card implements Cloneable
{
    protected final String name;
    protected final CardRank level;

    public Card(String name, CardRank level)
    {
        this.name = name;
        this.level = level;
    }

    public String getName()
    {
        return name;
    }

    public CardRank getLevel()
    {
        return level;
    }

    // 实现原型模式的克隆方法
    @Override
    public Card clone()
    {
        try
        {
            return (Card) super.clone();
        } catch (CloneNotSupportedException e)
        {
            throw new RuntimeException("Clone not supported for card: " + name, e);
        }
    }

}





