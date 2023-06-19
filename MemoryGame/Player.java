package se.t2015090.card.game;

public class Player {
	private String name; //プレイヤーの名前
	private int point; //プレイヤーの持ち点

	
	public Player() {

	}
	
	/**
	 * 名前と持ち点を指定してプレイヤーを設定
	 * 
	 * @param name
	 * playerの名前
	 * @param point
	 * Playerの持ち点
	 */
	public Player(String name, int point) {
		this.setName(name);
		this.setPoint(point);
	}

	/**
	 * playerの持ち点+1
	 */
	public void plusPoint() {
		point++;
	}

	/**
	 * そのプレイヤーの名前を取得
	 * @return 名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * そのプレイヤーの名前をセット
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * そのプレイヤーの持ち点を取得
	 * @return
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * そのプレイヤーの持ち点をセット
	 * @param point
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * プレイヤーの情報を記述
	 */
	public void showRecord() {
		System.out.println(name + "さんのポイントは" + point + "です．");
	}

}
