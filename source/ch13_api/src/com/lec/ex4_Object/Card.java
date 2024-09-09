package com.lec.ex4_Object;
// Card c1 = new Card("다이아몬드", 7)
// Card c2 = new Card("다이아몬드", 7)
// c1.equals(c2) => true
// sysout(c1) => 카드 다이아몬드 7입니다
public class Card {
	// data
	private String kind; // ♥ ◆ ♠ ♣
	private int num;
	
	// 생성자함수
	public Card(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Card) {
			Card other = (Card)obj; // Card형으로 형변환
			boolean kindChk = kind.equals(other.kind); // 객체비교는 == 못 씀
			boolean numChk = num == other.num; // 숫자비교는 == 사용 가능
			return kindChk && numChk;
		}
		return false;
	}

	@Override
	public String toString() {
		return "카드 모양은 " + kind + "의 " + num + "입니다";
	}
}











