package com.lec.ex3_spaekerTv;

public class Tv implements IVolume { // 상속

	// 데이터
	private int volumeLevel;            // 볼륨수준
	private final int MAX_VOLUME = 100; // 볼륨 상한
	private final int MIN_VOLUME = 0;   // 볼륨 하한
	public Tv() {
		volumeLevel = 10;
	}
	
	@Override
	public void volumeUp() { // 볼륨을 1씩 Up
		if(volumeLevel < MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV 볼륨을 1올려 현재 볼륨은 : " + volumeLevel);
		}else {
			System.out.println("TV 볼륨이 최대치("+MAX_VOLUME+")여서 올리지 못했습니다");
		} // if
	} //volumeUp
	
	@Override
	public void volumeUp(int i) { // 볼륨을 i씩 Up
		if(volumeLevel == MAX_VOLUME) {
			System.out.println("TV 볼륨이 최대치("+ MAX_VOLUME +")이여서 못 올려요");
		}else if((volumeLevel+i) <= MAX_VOLUME) {
			volumeLevel += i;
			System.out.println("TV 볼륨을 "+i+"만큼 올려 현재 볼륨은 : " + volumeLevel);
		}else {
			int temp = MAX_VOLUME - volumeLevel; // 가능한 만큼만 증가시킴
			volumeLevel = MAX_VOLUME;
			System.out.println("TV 볼륨을 " + temp + "만큼 올려 최대치에 도달했습니다");
		} // if
	} //volumeUp
	
	@Override
	public void volumeDown() { // 볼륨을 1씩 Down
		if(volumeLevel > MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV 볼륨을 1내려 현재 볼륨은 : " + volumeLevel);
		}else {
			System.out.println("TV 볼륨이 최소치("+MIN_VOLUME+")여서 내리지 못했습니다");
		} // i
	} // volumeDown

	@Override
	public void volumeDown(int i) { // 볼륨을 i씩 Down
		if(volumeLevel == MIN_VOLUME) {
			System.out.println("TV 볼륨이 최소치("+ MIN_VOLUME +")이여서 못 내려요");
		}else if(volumeLevel-i >= MIN_VOLUME) {
			volumeLevel -= i;
			System.out.println("TV 볼륨을 "+i+"만큼 내려 현재 볼륨은 : " + volumeLevel);
		}else { // 현재 볼륨=3, i=5
			int temp = volumeLevel - MIN_VOLUME; // 가능한 만큼만 감소시킴
			System.out.println("TV 볼륨 " + temp + "만큼 내려 최소치에 도달했습니다");
		} // if
		
	} // volumeDown
} // class
