package user.iterator;

import carditem.factorymethod.Card;
import carditem.factorymethod.CharacterCard;

import java.util.List;
import java.util.stream.Collectors;

// 角色卡迭代器
public class CharacterCardIterator implements CardIterator
{
    private final List<Card> cards;
    private int index = 0;

    public CharacterCardIterator(List<Card> cards) {
        this.cards = cards.stream().filter(card -> card instanceof CharacterCard)
                .collect(Collectors.toList());
    }

    @Override
    public Card current()
    {
        return cards.get(index);
    }

    @Override
    public boolean hasNext() {
        return index < cards.size();
    }

    @Override
    public Card next() {
        if (hasNext()) {
            return cards.get(index++);
        }
        throw new IllegalStateException("这是最后一个元素。");
    }

    @Override
    public boolean hasPrevious() {
        return index > 0;
    }

    @Override
    public Card previous() {
        if (hasPrevious()) {
            return cards.get(--index);
        }
        throw new IllegalStateException("这是第一个元素。");
    }

}
