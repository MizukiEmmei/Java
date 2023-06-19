package se.t2015090.card.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



	/**
	 * main関数を含む関数
	 * @author Mizuki Emmei
	 *
	 */
public class SystemMain {
	/**
	 * main関数
	 * @param args
	 * System
	 */
	public static void main(String[] args) {
		int a,b;
		System.out.println("神経衰弱を開始します。");
		System.out.println("CPUの数はいくつにしますか？");
		while(true) {
		a = inputNumber();
		if(a>0)break;
		System.out.println("1以上の値を入力してください");
		}
		
		System.out.println("カードは1から何の数字までを使用しますか?");
		while(true) {
		b = inputNumber();
		if(b>0)break;
		System.out.println("1以上の値を入力してください");
		}
		
		MemoryGame l = new MemoryGame(a, b);
		l.addUser();
		l.addCPU();
		l.showRecords();
		l.startGame();
		l.showRecords();

	}

	/**
	 * キーボードから数字を入力する
	 * @return number
	 * 入力された数字
	 */
	public static int inputNumber() {
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
}