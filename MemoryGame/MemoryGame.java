package se.t2015090.card.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import se.t2015090.card.entity.CardDeck;

/**
 *神経衰弱ゲームのクラス
 *
 * @author Mizuki Emmei
 */
public class MemoryGame {

	private int numberOfCPU; //CPUの数
	private int numberOfCards; //カードを1から何の数字までにするか
	
	/**
	 * デフォルトコンストラクタ
	 */
	public MemoryGame() {

	}

	/**
	 * 
	 * @param a 
	 * CPUの数
	 * @param b
	 * カードを1から何の数字までにするか
	 */
	public MemoryGame(int a, int b) {
		this.setnumberOfCPU(a);
		this.setnumberOfCards(b);
	}

	private ArrayList<Player> list = new ArrayList<Player>();

	/*
	 * Userの情報を登録(名前と持ち点)
	 * 
	 */
	public void addUser() {

		System.out.println("名前を入力してください。");
		String name = inputString();
		System.out.println(name + "さんですね");
		Player s = new Player(name, 0);
		getList().add(s);

	}

	/**
	 * CPUをnumberOfCPUの数だけ登録
	 * 
	 */
	public void addCPU() {
		for (int k = 0; k < numberOfCPU; k++) {
			Player s = new Player("CPU" + (k + 1), 0);
			getList().add(s);
		}
	}

	/**
	 * CPUの数を取得
	 * @return CPUの数
	 */
	public int getnumberOfCPU() {
		return numberOfCPU;
	}

	
	/**
	 * CPUの数をセット
	 * @param numberOfCPU
	 * CPUの数
	 */
	public void setnumberOfCPU(int numberOfCPU) {
		this.numberOfCPU = numberOfCPU;
	}
	
	/**
	 * カードを1から何の数字までにするかを取得
	 * @return　カードを1から何の数字までにするか
	 */
	public int getnumberOfCards() {
		return numberOfCards;
	}

	/**
	 * カードを1から何の数字までにするかをセット
	 * @param numberOfCards
	 * カードを1から何の数字までにするか
	 */
	public void setnumberOfCards(int numberOfCards) {
		this.numberOfCards = numberOfCards;
	}

	/**
	 * 神経衰弱を開始する
	 * UserとCPUが順番に2枚ずつカードを選択していく
	 * 2枚のカードの数字が一致したときは、その2枚をジョーカーに置き換える。
	 * 神経衰弱の場は"○○○J○○J○"のように表し、CPUはJ以外の2枚を選択するように設定する
	 */
	public void startGame() {
		CardDeck l = new CardDeck(this.numberOfCards);
		l.createFullDeck();
		l.shuffle();
		int size = l.sizeCard();

		int fullsize = size;
		System.out.println("現在のカードの残り枚数は" + size + "です。");
		
		while (size > 0) {
			l.drawField(-1,-1);
			System.out.println("何番目と何番目のカードを選びますか？");
			int a;
			while(true) {
				a = inputNumber();
				if(a > 0)break;
				System.out.println("1以上の値を入力してください");
				}
			int b;
			while(true) {
				b = inputNumber();
				if(b > 0)break;
				System.out.println("1以上の値を入力してください");
				}

			if (a > fullsize || b > fullsize) {
				System.out.println(fullsize + "より小さい値を入力してください");
				continue;
			}

			else if (a == b) {
				System.out.println("違う番号を入力してください");
				continue;
			}
			
			else if(l.seeNumber(a)==0) {
				System.out.println(a + "番目のカードはジョーカーなので選択できません");
				continue;
			}
			
			else if(l.seeNumber(b)==0) {
				System.out.println(b + "番目のカードはジョーカーなので選択できません");
				continue;
			}
			l.drawField(a, b);
			System.out.println(a + "番目のカードは" + l.seeCard(a) + "です");
			System.out.println(b + "番目のカードは" + l.seeCard(b) + "です");
			if (l.judgeEquality(a, b) == true) {
				System.out.println("おめでとうございます！2枚のカードの数字は等しいです！");
				getList().get(0).plusPoint();
				l.takeCard(a);
				l.takeCard(b);
				size = size - 2;
			}
			if (size <= 0)
				break;
			System.out.println("現在のカードの残り枚数は" + size + "です。");
			System.out.println("----------------------------------------------");

			for (int k = 0; k < numberOfCPU; k++) {
				boolean x = playCPU(l, fullsize,k+1);
				if (x == true) {
					size = size - 2;
					System.out.println("2枚のカードの数字は等しいのでCPU" + (k + 1) + "にポイントが入ります");
					getList().get(k + 1).plusPoint();
					if (size <= 0)
						break;
				}
				if (size <= 0)
					break;
				System.out.println("現在のカードの残り枚数は" + size + "になりました。");
				System.out.println("----------------------------------------------");
				
			}
		}

		System.out.println("カードの残り枚数が" + size + "になったのでゲームを終了します。");
	}

	/**
	 * CPUのターンに行うことを実装している
	 * @param l
	 *神経衰弱で用いているカードデッキ
	 * @param fullsize
	 *デッキのカード枚数
	 * @param k
	 * 何番目のCPUのターンか
	 * @return　CPUが引いた2枚のカードの数字が一致しているか否か
	 */
	public boolean playCPU(CardDeck l, int fullsize,int k) {
		int a, b;
		while (true) {
			a = randomCard(fullsize);
			b = randomCard(fullsize);
			if (a != b && l.seeNumber(a) != 0 && l.seeNumber(b) != 0)
				break;
		}

		System.out.println("CPU"+k+"は" + a + "番目と" + b + "番目のカードを選択しました");
		l.drawField(a,b);
		System.out.println(a + "番目のカードは" + l.seeCard(a) + "です");
		System.out.println(b + "番目のカードは" + l.seeCard(b) + "です");
		boolean x = l.judgeEquality(a, b);
		if (x == true) {
			l.takeCard(a);
			l.takeCard(b);
		}

		return x;

	}

	/**
	 * @param fullsize
	 * 乱数の最大値
 	 * @return　1からfullsizeまでの乱数
	 * 1からfullsizeまでの乱数を返す
	 */
	public int randomCard(int fullsize) {
		Random rand = new Random();
		int a = rand.nextInt(fullsize) + 1;
		return a;
	}

	
	/**
	 * 各プレイヤーの名前と持ち点を表示
	 */
	public void showRecords() {
		System.out.println("----------------------------------------------");
		for (Player s : getList()) {
			s.showRecord();
		}
		System.out.println("----------------------------------------------");
	}
	
	

	/**
	 * キーボードから入力された数字を取得
	 * @return 入力された数字
	 */
	public int inputNumber() {
		int number;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			number = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			System.err.println("フォーマット例外です．もう一度．");
			number = inputNumber(); // 再帰呼び出し
		} catch (IOException e) {
			System.err.println("入出力例外です．もう一度．");
			number = inputNumber(); // 再帰呼び出し
		}

		return number;
	}

	
	/**
	 * キーボードから入力された文字列を取得
	 * @return 入力された文字列
	 */
	public String inputString() {
		String line;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			line = br.readLine();
		} catch (NumberFormatException e) {
			System.err.println("フォーマット例外です．もう一度．");
			line = inputString(); // 再帰呼び出し
		} catch (IOException e) {
			System.err.println("入出力例外です．もう一度．");
			line = inputString(); // 再帰呼び出し
		}

		return line;
	}

	/**
	 * listを取得
	 * @return　list
	 */
	public ArrayList<Player> getList() {
		return list;
	}

	/**
	 * listをセット
	 * @param list
	 * プレイヤーのリスト
	 */
	public void setList(ArrayList<Player> list) {
		this.list = list;
	}
	
	

}
