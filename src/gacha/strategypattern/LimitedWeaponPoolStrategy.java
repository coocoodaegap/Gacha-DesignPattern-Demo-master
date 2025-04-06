package gacha.strategypattern;

import carditem.factorymethod.CardRank;

import java.util.*;

public class LimitedWeaponPoolStrategy implements DrawStrategy
{
    private static final double PROB_SSR = 0.01;
    private static final double PROB_SR = 0.08;

    private Random random;

    private Map<CardRank, List<String>> poolMap;

    public LimitedWeaponPoolStrategy()
    {
        random = new Random();
        poolMap = new HashMap<>();
        poolMap.put(CardRank.R, Arrays.asList("兵卫矛", "禁卫盾", "翠弹弓", "见习法杖", "赤铁剑"));
        poolMap.put(CardRank.SR, Arrays.asList("三叉戟", "冲击盾", "雷爆", "邵伍法典", "紫色心情"));
        poolMap.put(CardRank.SSR, Arrays.asList("最锋利的矛", "最坚固的盾", "朽木重弩", "天火权杖", "权位之『剑』"));
        poolMap.put(CardRank.LIMITED_SSR, Arrays.asList("列夫的史前宝书"));
    }

    @Override
    public CardRank calculateDraw()
    {
        double roll = random.nextDouble();
        if (roll < PROB_SSR) return CardRank.SSR;
        else if (roll < PROB_SSR + PROB_SR) return CardRank.SR;
        else return CardRank.R;
    }

    @Override
    public String getDetail()
    {
        return "限定SSR概率：" + (PROB_SSR * 50) + "%，SSR概率：" + (PROB_SSR * 50) + "%，SR概率：" + (PROB_SR * 100) + "%\n";
    }

    @Override
    public Map<CardRank, List<String>> getPoolMap()
    {
        return this.poolMap;
    }

}
