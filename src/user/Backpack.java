package user;

import carditem.factorymethod.Card;
import user.iterator.CardIterator;
import user.iterator.CharacterCardIterator;
import user.iterator.WeaponCardIterator;

import java.util.*;

// 背包类
public class Backpack
{
    private final List<Card> cards = new ArrayList<>();

    // 添加卡片
    public void addCard(Card card)
    {
        cards.add(card);
    }

    // 显示所有角色卡
    public CardIterator getCharacterCardIterator() {
        return new CharacterCardIterator(cards);
    }

    // 获取武器卡迭代器
    public CardIterator getWeaponCardIterator() {
        return new WeaponCardIterator(cards);
    }

    // 显示卡片集合
    private void displayCards(CardIterator iterator) {
        List<Card> filteredCards = new ArrayList<>();
        while (iterator.hasNext()) {
            filteredCards.add(iterator.next());
        }

        // 统计
        Map<Card, Integer> statistics = new TreeMap<>((c1, c2) -> {
            int a = c2.getLevel().compareTo(c1.getLevel());
            return a == 0 ? c2.getName().compareTo(c1.getName()) : a;
        });
        for (Card card : filteredCards) {
            statistics.put(card, statistics.getOrDefault(card, 0) + 1);
        }

        // 显示
        statistics.forEach((name, count) ->
                System.out.println(name + " x" + count)
        );
    }

    // 显示所有角色卡
    public void displayCharacterCards() {
        System.out.println("================");
        System.out.println("背包 - 角色卡:");
        displayCards(getCharacterCardIterator());
        System.out.println("================");
    }

    // 显示所有武器卡
    public void displayWeaponCards() {
        System.out.println("================");
        System.out.println("背包 - 武器卡:");
        displayCards(getWeaponCardIterator());
        System.out.println("================");
    }
}
