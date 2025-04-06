package user.observer;

import carditem.factorymethod.Card;

import java.util.Stack;

// 抽象观察者接口
public interface Observer
{
    void update(Stack<Card> cards, boolean limited, int drawCount, boolean isMissedPickUp);
}
