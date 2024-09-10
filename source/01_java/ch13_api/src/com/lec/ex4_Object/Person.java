package com.lec.ex4_Object;
// Person p1 = new Person(9812121021452L)
// Person p2 = new Person(9812121021452L)
// p1.equals(p2) => true
// sysout(p1) => 주민번호는 9812121021452입니다.
public class Person extends Object{
	private long juminNo; // 982121021452L
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	// toString override
	@Override
	public String toString() {
		return "주민번호는 " + juminNo;
	}
	@Override
	public boolean equals(Object obj) {
		// p1.equals(p2) p1.juminNo와 p2의 juminNo 비교결과 return
		// p1은 this, p2는 obj => juminNo와 obj.juminNo 비교
		if (obj != null && obj instanceof Person) { // obj가 null 아니고, obj이 Person형일때
			Person other = (Person)obj; // Person형으로 형변환 
			boolean juminNoChk = juminNo == other.juminNo;
			return juminNoChk;
		}
		return false;
	}
}
