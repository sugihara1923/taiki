import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PlayingCardsGame {

public static void main(String[] args) {

ArrayList<String> CardsList = new ArrayList<String>(); // 52枚のトランプを格納する配列
ArrayList<String> PlayerCards = new ArrayList<String>(); // Playerの手札を格納する配列
ArrayList<String> ComputerCards = new ArrayList<String>(); // Computerの手札を格納する配列
String yesnoFlag = "y"; // 勝負を続けるかを判定するための変数
String choiceFlag = ""; // 勝負するかカードを追加するかを判定するための変数
int matchCount = 1, winCount = 0,loseCount = 0, drawCount= 0;
Scanner scan = new Scanner(System.in); // 入力用クラス

// ここから下がコンソールに表示する処理
System.out.println("ブラックジャックを始めます。");

// yesnoFlagが"y"である限りループする
do {
System.out.println("\n*"+matchCount+"回戦＊\n");

// 初期化
CardsList.clear();
PlayerCards.clear();
ComputerCards.clear();

// 52枚のトランプを格納
CardsList=getInitialCardsList();

// 初期状態：PlayerとComputerの手札に２枚追加
for(int i=0;i<2;i++)PlayerCards.add(SelectCard(CardsList));
for(int i=0;i<2;i++)ComputerCards.add(SelectCard(CardsList));

// CardsListからPlayerとComputerの手札に追加したカードを削除する
for(int i=0;i<2;i++)CardsList.remove(SearchEqualCard(CardsList,PlayerCards));
for(int i=0;i<2;i++)CardsList.remove(SearchEqualCard(CardsList,ComputerCards));

// Playerの手札を表示
System.out.print("あなたの手札＞　");
ShowCards(PlayerCards);

System.out.println("\n");

System.out.println("勝負しますか？カードを追加しますか？");
System.out.print("勝負：1　追加：2　—-→ ");
choiceFlag=scan.next();

while(choiceFlag.equals("2")) {

// Playerの手札に１枚追加
PlayerCards.add(SelectCard(CardsList));
// CardsListからPlayerの手札に追加したカードを削除する
CardsList.remove(SearchEqualCard(CardsList,PlayerCards));
// Playerの手札を表示
System.out.print("\nあなたの手札＞　");
ShowCards(PlayerCards);

System.out.println("\n勝負しますか？カードを追加しますか？");
System.out.print("勝負：1　追加：2　—-→ ");
choiceFlag=scan.next();
}

// Computerの手札を決定(17点以上になるように)
while(getCardsScore(ComputerCards)<17) {
ComputerCards.add(SelectCard(CardsList));
CardsList.remove(SearchEqualCard(CardsList,ComputerCards));
}

// Computerの手札を表示
System.out.print("\n相手の手札＞　");
ShowCards(ComputerCards);

System.out.println("\n");
System.out.println("＜最終スコア＞");
System.out.println("あなた： "+getCardsScore(PlayerCards)+"　相手： "+getCardsScore(ComputerCards));
System.out.println("");

if(MatchResult(getCardsScore(PlayerCards),getCardsScore(ComputerCards))=="win") {
System.out.println("あなたの勝ちです。");
winCount+=1;
}else if(MatchResult(getCardsScore(PlayerCards),getCardsScore(ComputerCards))=="BJwin") {
System.out.println("BlackJack!! あなたの勝ちです。");
winCount+=1;
}else if(MatchResult(getCardsScore(PlayerCards),getCardsScore(ComputerCards))=="draw"){
System.out.println("引き分けです。");
drawCount+=1;
}else if(MatchResult(getCardsScore(PlayerCards),getCardsScore(ComputerCards))=="BJlose") {
System.out.println("BlackJack!! あなたの負けです。");
loseCount+=1;
}else {
System.out.println("あなたの負けです。");
loseCount+=1;
}
matchCount += 1;

System.out.println("\n勝負を続けますか？");
System.out.print("YES：y　NO：n　—-→ ");
yesnoFlag=scan.next();

}while(yesnoFlag.equals("y"));

System.out.println();
System.out.println("成績　"+winCount+"勝"+loseCount+"敗"+drawCount+"分\n");
System.out.println("お疲れ様でした!");

}

public static void ShowCards(ArrayList<String> cardsList){

for(String card : cardsList) {
System.out.print(card+" ");
}
}

    public static String SelectCard(ArrayList<String> cardsList) {

        Random r = new Random(); // ランダムな数値を生成

        return cardsList.get(r.nextInt(cardsList.size() - 1));
    }

    public static String SearchEqualCard(ArrayList<String> cardsList, ArrayList<String> cards) {

        // cardListとcardsを比較し、等しいカードを返す
        for (String c : cardsList) {
            for (String card : cards) {
                if (card.equals(c)) {
                    return card;
                }
            }
        }
        return null; // 等しいカードが無かった場合、nullを返す
    }

    public static int getCardsScore(ArrayList<String> cards) {

        int score = 0;
        boolean aceFlag = false;
        boolean jackFlag = false;

        for (String initialcard : getInitialCardsList()) {
            for (String card : cards) {
                if (card.equals(initialcard)) {
                    if (getInitialCardsList().indexOf(card) % 13 + 1 > 10) {
                        // J,Q,Kは10としてカウント
                        score += 10;
                        if (getInitialCardsList().indexOf(card) % 13 + 1 == 11) {
                            // Jがでたことを記録
                            jackFlag = true;
                        }
                    } else if (getInitialCardsList().indexOf(card) % 13 + 1 == 1) {
                        // Aがでたことを記録
                        aceFlag = true;
                        score += 1;
                    } else {
                        score += getInitialCardsList().indexOf(card) % 13 + 1;
                    }
                }
            }
        }
        // Aを1として数えるか11として数えるかを決定
        // もし11として数えて21以下だった場合は11としてscoreに加算する
        if (aceFlag == true && score + 10 < 22)
            score = score + 10;
        // AとJの２枚が出てBlackJackとなった場合、scoreを100とする
        if (aceFlag == true && jackFlag == true && score == 21)
            score = 100;
        return score;
    }

public static String MatchResult(int playerscore,int computerscore) {

String result="win";

if((playerscore < computerscore && computerscore < 22)||
(playerscore > 21 && computerscore < 22)) {
result="lose";
}else if(playerscore == computerscore ||
(playerscore > 21 && computerscore > 21))result="draw";
if(playerscore==100)result="BJwin";
if(computerscore==100)result="BJlose";
return result;
}

public static ArrayList<String> getInitialCardsList(){

ArrayList<String> CardsList = new ArrayList<String>();

for(int i=0;i<13;i++) {
if(i==0)CardsList.add("♣A");
if(0<i&&i<10)CardsList.add("♣"+(i+1));
if(i==10)CardsList.add("♣J");
if(i==11)CardsList.add("♣Q");
if(i==12)CardsList.add("♣K");
}for(int i=0;i<13;i++) {
if(i==0)CardsList.add("♠A");
if(0<i&&i<10)CardsList.add("♠"+(i+1));
if(i==10)CardsList.add("♠J");
if(i==11)CardsList.add("♠Q");
if(i==12)CardsList.add("♠K");
}for(int i=0;i<13;i++) {
if(i==0)CardsList.add("♥A");
if(0<i&&i<10)CardsList.add("♥"+(i+1));
if(i==10)CardsList.add("♥J");
if(i==11)CardsList.add("♥Q");
if(i==12)CardsList.add("♥K");
}for(int i=0;i<13;i++) {
if(i==0)CardsList.add("♦A");
if(0<i&&i<10)CardsList.add("♦"+(i+1));
if(i==10)CardsList.add("♦J");
if(i==11)CardsList.add("♦Q");
if(i==12)CardsList.add("♦K");
}
return CardsList;
}
}