package singleton1;
// 싱글톤 패턴
/* 데이터 영역 메모리     | heap메모리 영역
 * 클래스(설계도) static | 일반변수        */
public class Single {
	// 데이터
	private int i;
	
	// 생성자
	private Single() {} // 아예 객체 못 만듦
	
//	INSTANCE 변수 생성
//	private static Single INSTANCE; // 변수이름은 대문자
//	public static Single getInstance() {
//		// 객체를 생성한 적 없으면 생성하고 그 주소를 return
//		// 객체를 생성한 적 있으면, 그 객체 주소를 return
//		if(INSTANCE == null) {
//			INSTANCE = new Single(); // private이라 클래스 내에서 생성 가능
//		}
//		return INSTANCE;
//	}
	
//	더 간단하게(실제 많이 쓰는 방법)
	private static Single INSTANCE = new Single();
	public static Single getInstance() {
		return INSTANCE;
	}
	
	// getter&setter
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}