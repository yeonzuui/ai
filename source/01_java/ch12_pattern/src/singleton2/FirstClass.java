package singleton2;

public class FirstClass {
	// 생성자 함수
	public FirstClass() {
		System.out.println("FistClass 생성자 실행 중 - - - - -");
		SingletonClass firstSingletonObj = SingletonClass.getInstance();
		System.out.println("싱글톤 객체의 i값 : " + firstSingletonObj.getI());
		firstSingletonObj.setI(999);
		System.out.println("싱글톤 객체의 수정한 i값 : " + firstSingletonObj.getI());
	}
}
