package gacha.strategypattern;

import carditem.factorymethod.CardRank;

import java.util.*;

// 普通卡池策略
public class NormalPoolStrategy implements DrawStrategy
{
    private static final double PROB_SSR = 0.01;
    private static final double PROB_SR = 0.08;

    private Random random;

    private Map<CardRank, List<String>> poolMap;

    public NormalPoolStrategy()
    {
        random = new Random();
        poolMap = new HashMap<>();
        poolMap.put(CardRank.R, Arrays.asList("查理", "大卫", "爱德华", "乔治", "伊万"));
        poolMap.put(CardRank.SR, Arrays.asList("杜尔特", "寇德", "希尔维亚", "旺仔", "季子"));
        poolMap.put(CardRank.SSR, Arrays.asList("柯尼茨", "彪约恩", "渡鸦", "艾格妮丝", "卡卡"));
    }

    @Override
    public CardRank calculateDraw()
    {
        double roll = random.nextDouble();
        if (roll < PROB_SSR) return CardRank.SSR;
        else if (roll < PROB_SSR + PROB_SR) return CardRank.SR;
        else return CardRank.R;
    }

    public String getDetail()
    {
        return "SSR概率：" + (PROB_SSR * 100) + "%，SR概率：" + (PROB_SR * 100) + "%\n";
    }

    @Override
    public Map<CardRank, List<String>> getPoolMap()
    {
        return this.poolMap;
    }

}
