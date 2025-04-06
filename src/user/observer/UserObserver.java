package user.observer;

import carditem.factorymethod.Card;
import user.UserSingleton;

import java.util.Stack;

// 用户信息模块 (观察者)
public class UserObserver implements Observer
{
    @Override
    public void update(Stack<Card> cards, boolean limited, int drawCount, boolean missedPickUp)
    {
        for (Card card : cards)
        {
            UserSingleton.getInstance().getBackpack().addCard(card);
        }
        UserSingleton.getInstance().setLastDraws(limited, drawCount);
        UserSingleton.getInstance().setMissedPickUp(missedPickUp);
    }

    public int getTotalDrawCount(boolean limited)
    {
        return UserSingleton.getInstance().getLastDraws(limited);
    }

    public boolean isMissedPickUp() {
        return UserSingleton.getInstance().isMissedPickUp();
    }
}
