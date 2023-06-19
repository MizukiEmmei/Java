package se.t2015090.card.entity;

import java.util.ArrayList;
import java.util.Collections;
/**
 * トランプの山クラス
 *
 * @author Mizuki Emmei
 */


public class CardDeck {
	
	private ArrayList <Card> cards = new ArrayList<Card>(); 
	private int number;
	/**
	 *デフォルトコンストラクタ
	 */
	public CardDeck() {
		
	}
	
	public CardDeck(int number) {
		this.number = number;
	}
	/**
	 * トランプの山を作成
	 */
	public void createFullDeck(){
		for(int i=0;i<4;i++) {
			for(int j=0; j<this.number ;j++) {
				Card s = new Card(i,j+1);
				cards.add(s);
			}
		}
		
		/*
		 *ジョーカーは神経衰弱では不要
				 * */
	}
	

	
	/**
	 * シャッフルします
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	/**
	 * カードを一番最後に追加します
	 * @param card
	 * 追加カード
	 */
	public void addCard(Card card) {
		cards.add(card);
	}
	
	/**
	 * i番目に任意のカードを追加します
	 *@param i
	 *何番目か
	 *@param card
	 *追加カード
	 */
	public void addCard(int i,Card card) {
		cards.add(i-1,card);
	}
	
	/**
	 * 一番上のカードを取り出します
	 * @return s
	 */
	public Card takeCard() {
		Card s = cards.get(0);
		cards.remove(0);
		return s;
	}
	
	/**
	 * i番目のカードを取り出します
	 * i番目を取り出した後、そこにはジョーカーを代入する（カードが存在しないことを意味する。）
	 * @param i
	 * 何番目を取り出すか
	 * @return s
	 */
	public Card takeCard(int i) {
		Card s = cards.get(i-1);
		Card empty = new Card(-1,0);
		cards.set(i-1, empty);
		return s;
	}
	
	
	/**
	 * i番目のカードを見ます
	 * @param i
	 * 何番目をみるか
	 * @return s
	 */
	public int sizeCard() {
		return cards.size();
	}
	
	/**
	 * i番目のカードの番号を見ます
	 * @param i
	 * 何番目をみるか
	 * @return 
	 * @return s
	 */
	public  int seeNumber(int i) {
		Card s = cards.get(i-1);
		return s.getNumber();
	
	}
	
	/**
	 * カードデッキからa番目とb番目カードが一致しているか否かを取得する
	 * @param a 
	 *デッキの上から何番目のカードを選択するか
	 * @param b
	 * a以外でデッキの上から何番目のカードを選択するか
	 * @return True or False
	 */
	public boolean judgeEquality(int a,int b) {
		if(seeNumber(a)==0 || seeNumber(b)==0)return false;
		if(seeNumber(a) == seeNumber(b)) return true;
		
		else return false;
	}
	
	
	
	
	/**
	 * i番目のカードを見ます
	 * @param i
	 * 何番目をみるか
	 * @return s
	 */
	public Card seeCard(int i) {
		Card s = cards.get(i-1);
		return s;
	}
	
	/**
	 * 指定されたカードを探します
	 * @param suit
	 * 指定カードの絵柄
	 * @param number
	 * 指定カードの数字
	 * @return 探したカードが何番目にあるか、存在しない場合は-1を返します。
	 */
	public int searchCard(int suit, int number){
		Card s = new Card(suit,number);
		int s1 = s.getSuit();
		int s2= s.getNumber();
		for(int i=0 ;i<cards.size() ;i++) {
			Card t=cards.get(i);
			int t1 = t.getSuit();
			int t2 = t.getNumber();
			if(t1 == s1 && t2 == s2) {
				return i+1;
			}
		}
		System.out.println("カードが見つかりませんでした");
		return -1;
	}

	
	
	/**
	 * ゲームにおける場を描画する
	 * @param a
	 * プレイヤーが選択したa番目のカードとb番目のカードを●、それ以外を○、Jと表し、選んだカードの位置を視覚化できるようにする。
	 * @param b
	 * プレイヤーが選択したa番目のカードとb番目のカードを●、それ以外を○、Jと表し、選んだカードの位置を視覚化できるようにする。
	 */
	public void drawField(int a,int b) {
		int i=1;
		for(Card x : cards) {
			if(i == a||i == b)System.out.printf("●");
			else if(x.getNumber()==0)System.out.printf(" J ");
			else System.out.printf("○");
			
			i++;
		}
		System.out.println();
	}
	
	
	/**
	 * 山の中身を表示します。
	 */
	public void showAllCards() {
		int i=0;
		for(Card x : cards) {
			System.out.printf("%2d番目のカードは%sです\n" , i+1, x.toString() );
			i++;
		}
	}
	
	/**
	 * カードの山の配列を返します
	 * @return　カードの山cards
	 */
	public ArrayList<Card> getAllCards() {
		return cards;
	}

}