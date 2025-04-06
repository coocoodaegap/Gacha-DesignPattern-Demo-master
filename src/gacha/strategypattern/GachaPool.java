package gacha.strategypattern;

import carditem.factorymethod.*;
import carditem.prototype.CardPrototypeManager;

import java.util.*;

public class GachaPool
{
    CardPrototypeManager cardPrototypeManager;
    Map<CardRank, List<String>> prototypeMap;
    CardFactory characterFactory;
    CardFactory weaponFactory;

    public GachaPool()
    {
        characterFactory = new CharacterCardFactory();
        weaponFactory = new WeaponCardFactory();
        this.cardPrototypeManager = new CardPrototypeManager();
        this.prototypeMap = new HashMap<>();
        bindSampleData();
    }

    private void bindSampleData()
    {
        registerPrototype("查理", characterFactory.createCard("查理", CardRank.R));
        registerPrototype("大卫", characterFactory.createCard("大卫", CardRank.R));
        registerPrototype("爱德华", characterFactory.createCard("爱德华", CardRank.R));
        registerPrototype("乔治", characterFactory.createCard("乔治", CardRank.R));
        registerPrototype("伊万", characterFactory.createCard("伊万", CardRank.R));
        registerPrototype("杜尔特", characterFactory.createCard("杜尔特", CardRank.SR));
        registerPrototype("寇德", characterFactory.createCard("寇德", CardRank.SR));
        registerPrototype("希尔维亚", characterFactory.createCard("希尔维亚", CardRank.SR));
        registerPrototype("旺仔", characterFactory.createCard("旺仔", CardRank.SR));
        registerPrototype("季子", characterFactory.createCard("季子", CardRank.SR));
        registerPrototype("柯尼茨", characterFactory.createCard("柯尼茨", CardRank.SSR));
        registerPrototype("彪约恩", characterFactory.createCard("彪约恩", CardRank.SSR));
        registerPrototype("渡鸦", characterFactory.createCard("渡鸦", CardRank.SSR));
        registerPrototype("艾格妮丝", characterFactory.createCard("艾格妮丝", CardRank.SSR));
        registerPrototype("卡卡", characterFactory.createCard("卡卡", CardRank.SSR));
        registerPrototype("列芙娜", characterFactory.createCard("列芙娜", CardRank.LIMITED_SSR));
        registerPrototype("兵卫矛", weaponFactory.createCard("兵卫矛", CardRank.R));
        registerPrototype("禁卫盾", weaponFactory.createCard("禁卫盾", CardRank.R));
        registerPrototype("翠弹弓", weaponFactory.createCard("翠弹弓", CardRank.R));
        registerPrototype("见习法杖", weaponFactory.createCard("见习法杖", CardRank.R));
        registerPrototype("赤铁剑", weaponFactory.createCard("赤铁剑", CardRank.R));
        registerPrototype("三叉戟", weaponFactory.createCard("三叉戟", CardRank.SR));
        registerPrototype("冲击盾", weaponFactory.createCard("冲击盾", CardRank.SR));
        registerPrototype("雷爆", weaponFactory.createCard("雷爆", CardRank.SR));
        registerPrototype("邵伍法典", weaponFactory.createCard("邵伍法典", CardRank.SR));
        registerPrototype("紫色心情", weaponFactory.createCard("紫色心情", CardRank.SR));
        registerPrototype("最锋利的矛", weaponFactory.createCard("最锋利的矛", CardRank.SSR));
        registerPrototype("最坚固的盾", weaponFactory.createCard("最坚固的盾", CardRank.SSR));
        registerPrototype("朽木重弩", weaponFactory.createCard("朽木重弩", CardRank.SSR));
        registerPrototype("天火权杖", weaponFactory.createCard("天火权杖", CardRank.SSR));
        registerPrototype("权位之『剑』", weaponFactory.createCard("权位之『剑』", CardRank.SSR));
        registerPrototype("列夫的史前宝书", weaponFactory.createCard("列夫的史前宝书", CardRank.LIMITED_SSR));
    }

    private void registerPrototype(String name, Card card)
    {
        cardPrototypeManager.registerPrototype(name, card);
    }

    public void setPrototypeMap(Map<CardRank, List<String>> poolMap)
    {
        this.prototypeMap = poolMap;
    }

    public Card getByLevel(CardRank level)
    {
        List<String> candidates = prototypeMap.get(level);
        Random random = new Random();
        int id = random.nextInt(candidates.size());
        String cardName = candidates.get(id);
        return cardPrototypeManager.getClone(cardName);
    }

    public Card getByName(String cardName)
    {
        return cardPrototypeManager.getClone(cardName);
    }
}
