package singleton2;

public class SingletonClass {
	// 데이터(인스턴스변수)
	private int i;
	private static SingletonClass INSTANCE = new SingletonClass();
	
	// 생성자
	private SingletonClass() {
		i = 10; // 객체 데이터가 가질 초기값 설정
	}
	
	// 메소드
	public static SingletonClass getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new SingletonClass();
		}
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
