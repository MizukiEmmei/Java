package se.t2015090.card.entity;

/**
 * トランプのカードクラス
 *
 * @author Mizuki Emmei
 */
public class Card {
	private int suit; // 絵柄 (0:スペード，1:ダイヤ，2:ハート，3:クラブ, -1:ジョーカー)
	private int number; // 数字 (1-13, 0)

	/**
	 * 絵柄と数字を指定してカードを生成する
	 *
	 * @param suit
	 *            絵柄 (0:スペード，1:ダイヤ，2:ハート，3:クラブ, -1:ジョーカー)
	 * @param number
	 *            数字 (1-13)
	 */
	public Card(int suit, int number) {
		super();
		// 本当は絵柄，数字が範囲外だったときの例外処理もしたい
		this.suit = suit;
		this.number = number;
	}

	/**
	 * そのカードの絵柄を取得する
	 *
	 * @return 絵柄 (0:スペード，1:ダイヤ，2:ハート，3:クラブ, -1:ジョーカー)
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * そのカードの数字を取得する
	 *
	 * @return 数字 (1-13, 0)
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * そのカードの整数表現を取得する
	 *
	 * @return 整数表現 (0-51, -1)
	 */
	public int toIndex() {
		//自身の絵柄，数字で，staticメソッドから得る
		return getIndex(getSuit(), getNumber());
	}

	/**
	 * そのカードの文字列表現を取得する
	 *
	 * @return 文字列表現 (スペードA, スペード2, ...)
	 */
	public String toString() {
		//自身の絵柄，数字で，staticメソッドから得る
		return getString(getSuit(), getNumber());
	}

	/**
	 * そのカードの文字列表現を画面に表示する
	 */
	public void show() {
		System.out.println(toString());
	}

	/**
	 * 与えられた絵柄，数字から整数表現を計算して返す．すべてのカードで共通
	 *
	 * @param suit
	 *            絵柄 (0:スペード，1:ダイヤ，2:ハート，3:クラブ, -1:ジョーカー)
	 * @param number
	 *            数字 (1-13, 0)
	 * @return カードの整数表現 (0-51, -1)
	 */
	public static int getIndex(int suit, int number) {
		int index;

		if (suit == -1) {
			index = -1;
		} else {
			index = suit * 13 + number-1;
		}

		return index;

	}

	/**
	 * 与えられた絵柄，数字から文字列表現を決定して返す．すべてのカードで共通
	 *
	 * @param suit
	 *            絵柄 (0:スペード，1:ダイヤ，2:ハート，3:クラブ, -1:ジョーカー)
	 * @param number
	 *            数字 (1-13, 0)
	 * @return カードの文字列表現 (スペードA, スペード2, ...)
	 */
	public static String getString(int suit, int number) {
		String suitStr, numStr; // 絵柄文字列，数字文字列

		String[] sLabel = { "スペード", "ダイヤ", "ハート", "クラブ" };

		if (suit == -1) {
			suitStr = "ジョーカー";
			numStr = "";
		} else if (2 <= number && number <= 10) {
			suitStr = sLabel[suit];
			numStr = Integer.toString(number);
		} else {
			suitStr = sLabel[suit];
			switch (number) {
			case 1:
				numStr = "A";
				break;
			case 11:
				numStr = "J";
				break;
			case 12:
				numStr = "Q";
				break;
			case 13:
				numStr = "K";
				break;
			default:
				numStr = "存在しないカード";
			}
		}
		return suitStr + numStr;
	}
}
