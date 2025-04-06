package carditem.factorymethod;

// 抽象工厂接口
public interface CardFactory
{
    Card createCard(String name, CardRank level);
}
