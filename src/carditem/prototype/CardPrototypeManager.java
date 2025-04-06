package carditem.prototype;

import carditem.factorymethod.Card;

import java.util.HashMap;
import java.util.Map;

// 卡片原型管理器
public class CardPrototypeManager
{
    private Map<String, Card> prototypes = new HashMap<>();

    // 注册原型
    public void registerPrototype(String key, Card card)
    {
        prototypes.put(key, card);
    }

    // 克隆卡片
    public Card getClone(String key)
    {
        Card prototype = prototypes.get(key);
        if (prototype == null)
        {
            throw new IllegalArgumentException("No prototype found for key: " + key);
        }
        return prototype.clone();
    }
}
