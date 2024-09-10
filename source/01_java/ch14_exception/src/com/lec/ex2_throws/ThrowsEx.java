package com.lec.ex2_throws;

public class ThrowsEx {
	
	// Conductor
	public ThrowsEx() throws Exception {
		actionB();
	}
	// method
	private void actionB() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionB 전반부");
		actionA();
		System.out.println("actionB 후반부");
	}
	private void actionA() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionA 전반부");
		// 예외 의도적으로 만들기
		int [] arr = {0,1,3}; 
			System.out.println(arr[3]);
		System.out.println("actionA 후반부");
	}
}

// ArrayIndexOutOfBoundsException 예외type
// 블록이 끝나면 호출한 곳으로 돌아가
// ctrl + t : 메소드 계보
// 예외는 크게 두가지: RuntimeException(언체크 예외) / 체크 예외
// RuntimeException으로부터 상속받은, 런타임 아닌 예외type 쓸 거면 actionA-actionB-ThrowsEx-ThrowsTestMain 순으로 try-catch 해줘야 해
// e.printStackTrace(); 예외메시지를 더 자세하게