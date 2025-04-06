package gacha.statepattern;

import carditem.factorymethod.Card;
import carditem.factorymethod.CardRank;
import gacha.strategypattern.GachaPool;
import user.observer.Observable;
import user.observer.Observer;

import java.util.*;

// 抽卡上下文
public class DrawContext extends Observable
{
    private int drawCount;
    private int guaranteeCount;
    private boolean isLimited;
    private boolean missedPickUp;
    private boolean hasFiveStar;
    private DrawState state;

    private Stack<Card> drawResults;
    private GachaPool gachaPool;


    public DrawContext(int drawCount, boolean isLimited, boolean missedPickUp, int guaranteeCount, GachaPool gachaPool) {
        this.drawCount = drawCount;
        this.hasFiveStar = false;
        this.isLimited = isLimited;
        this.missedPickUp = missedPickUp;
        this.guaranteeCount = guaranteeCount;
        this.gachaPool = gachaPool;
        this.state = new NormalState(this);
        drawResults = new Stack<>();
    }

    public int getDrawCount() {
        return drawCount;
    }

    public void addDraw(Card card) {
        this.drawResults.add(card);
    }

    public void incrementDrawCount()
    {
        this.drawCount++;
    }

    public void newDraw() {
        this.drawResults.clear();
    }

    private void clearDrawCount() {
        drawCount = 0;
    }

    public void displayResults()
    {
        notifyObservers();
        int cnt = 0;
        if(this.hasFiveStar)
        {
            System.out.println("\033[33m哇！金色传说~\033[0m");
            this.hasFiveStar = false;
        }
        for (Card result : drawResults)
        {
            if(result.getLevel() == CardRank.SR)
                System.out.print("\033[35m");
            else if(result.getLevel() == CardRank.SSR)
                System.out.print("\033[33m");
            else if(result.getLevel() == CardRank.LIMITED_SSR)
                System.out.print("\033[31m");
            System.out.printf("- %-20s\033[0m", result);
            if(++cnt == 5)
            {
                System.out.println();
                cnt = 0;
            }
        }
        if(cnt != 0) System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void setDrawnItem(CardRank cardLevel) {
        if(cardLevel == CardRank.SSR || cardLevel == CardRank.LIMITED_SSR)
        {
            if (cardLevel == CardRank.SSR)
            {
                if (this.isLimited && this.missedPickUp)
                {
                    cardLevel = CardRank.LIMITED_SSR;
                    this.setMissedPickUp(false);
                } else this.setMissedPickUp(true);
            }
            this.hasFiveStar = true;
            clearDrawCount();
        }
        Card drawnItem = gachaPool.getByLevel(cardLevel);
        this.addDraw(drawnItem);
    }

    public DrawState getState() {
        return state;
    }

    public void setState(DrawState state) {
        this.state = state;
    }

    public boolean isLimited()
    {
        return isLimited;
    }

    public boolean getMissedPickUp()
    {
        return missedPickUp;
    }

    public int getGuaranteeCount()
    {
        return guaranteeCount;
    }

    public boolean handleState()
    {
        return this.state.handleState();
    }

    public void setMissedPickUp(boolean missedPickUp)
    {
        this.missedPickUp = missedPickUp;
    }

    @Override
    public void notifyObservers()
    {
        for (Observer observer : observers) {
            observer.update(this.drawResults, isLimited, drawCount, isLimited);
        }
    }

    public boolean tenDrawAllR()
    {
        if (this.drawResults == null || this.drawResults.size() < 9) return false;
        return true;
    }

//    public void debug()
//    {
//        System.out.print(this.getState().getClass() + " : ");
//        for (Card54 c : drawResults)
//        {
//            System.out.print(c + " ");
//        }
//        System.out.println(" - Limited: " + this.isLimited());
//    }
}

