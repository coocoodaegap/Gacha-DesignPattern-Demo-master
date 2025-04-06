package user.iterator;

import carditem.factorymethod.Card;

public interface CardIterator
{
    Card current();
    boolean hasNext();
    Card next();
    boolean hasPrevious();
    Card previous();
}
