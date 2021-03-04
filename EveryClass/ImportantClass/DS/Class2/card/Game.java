package card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        // 1. 初始化一副牌
        ArrayList<Card> cardList = initCardList();

        // 2. 进行洗牌
        shuffle(cardList);
        //Collections.shuffle(cardList);

        // 3. 黑桃 A 在不在这副牌中，在，所以，期望打印 true
        // 结果打印了 false，为什么？
//        Card spadeA = new Card(1, "♠");
//        System.out.println(cardList);
//        System.out.println(cardList.contains(spadeA));

        // 3. 准备三名玩家的手牌（存在牌的容器，通过 ArrayList<Card> 来表示）
        ArrayList<Card> playerA = new ArrayList<>();
        ArrayList<Card> playerB = new ArrayList<>();
        ArrayList<Card> playerC = new ArrayList<>();

        System.out.println("抓牌前:");
        System.out.println(cardList);
        // 4. 按照 A -> B -> C -> A -> B -> C ... 的顺序，轮流抓拍，没人抓 5 张牌
        for (int i = 0; i < 5; i++) {
            // 抓牌：1. 从牌堆（cardList）中删除出一张牌出来（头删/尾删），这里选择使用头删
            //       2. 把该牌放入玩家对应的手牌中

            // A 玩家抓牌
            Card card = cardList.remove(0);
            playerA.add(card);

            // B 玩家抓牌
            card = cardList.remove(0);
            playerB.add(card);

            // C 玩家抓牌
            card = cardList.remove(0);
            playerC.add(card);
        }

        System.out.println("抓牌后:");
        System.out.println(cardList);
        System.out.println(cardList.size());    // 52 - 15 = 37
        System.out.println("A: " + playerA);
        System.out.println("B: " + playerB);
        System.out.println("C: " + playerC);
    }

    private static void shuffle(ArrayList<Card> cardList) {
        Random random = new Random();
        for (int i = cardList.size() - 1; i > 0; i--) {
            // 下标为 [i] 要交换牌的其中一张
            // [0, i) 位置中，随机生成一个下标
            int randomIdx = random.nextInt(i);
            // 下标为 [randomIdx] 为交换牌的另一张

            // 交换
            Card tmpA = cardList.get(i);
            Card tmpB = cardList.get(randomIdx);
            cardList.set(i, tmpB);
            cardList.set(randomIdx, tmpA);
        }
    }

    private static ArrayList<Card> initCardList() {
        ArrayList<Card> cardList = new ArrayList<>();
        String[] suits = {"♥", "♠", "♣", "♦"};
        for (String suit : suits) {
            for (int rank = 1; rank <= 13; rank++) {
                Card card = new Card(rank, suit);

                cardList.add(card);
            }
        }

        return cardList;
    }
}
