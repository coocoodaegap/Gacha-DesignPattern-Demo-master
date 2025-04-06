package user.observer;

import java.util.ArrayList;
import java.util.List;

// 被观察者接口
public abstract class Observable
{
    protected List<Observer> observers = new ArrayList<>(); // 观察者列表

    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }
    protected void removeObserver(Observer observer)
    {
        observers.add(observer);
    }
    protected abstract void notifyObservers();
}

