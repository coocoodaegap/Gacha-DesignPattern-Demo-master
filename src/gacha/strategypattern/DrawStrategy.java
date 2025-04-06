package gacha.strategypattern;

import carditem.factorymethod.CardRank;

import java.util.List;
import java.util.Map;

// 抽象类：抽卡策略
public interface DrawStrategy
{
    CardRank calculateDraw();

    String getDetail();

    Map<CardRank, List<String>> getPoolMap();
}
