package strategy1.step2;

public class Robot {
	// 객체의 이름을 가져오는 메소드 - object에 포함
	public void shape() {
		String className = getClass().getName();
		int idx = className.lastIndexOf("."); // 맨 마지막 "."의 위치
		String name = className.substring(idx+1); // idx+1번째부터 끝까지 스트링 추출
		System.out.println(name + "의 외형은 팔, 다리, 머리, 몸통이 있습니다 = = =");
	}
	public void actionWalk() {
		System.out.println("걸을 수 있습니다");
	}
	public void actionRun() {
		System.out.println("달릴 수 있습니다");
	}
}