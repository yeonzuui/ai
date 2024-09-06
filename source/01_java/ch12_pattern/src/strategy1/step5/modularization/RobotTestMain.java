package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyHigh;
import strategy1.step4.interfaces.KnifePlay;

public class RobotTestMain {
	public static void main(String[] args) {
		// 객체 변수 생성
		SuperRobot    superRobot    = new SuperRobot();
		StandardRobot standardRobot = new StandardRobot();
		LowRobot      lowRobot      = new LowRobot();
		
		// Robot 배열 생성
		Robot [] robots = {superRobot, standardRobot, lowRobot};
		
		// 확장 for문을 통한 호출
		for (Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
			System.out.println(); // 개행
		}
		
		System.out.println("슈퍼로봇의 나는 부품을 높~~~~~~이 나는 기능으로 업그레이드");
		superRobot.setFly(new FlyHigh());
		
		superRobot.shape();
		superRobot.actionFly();
		robots[0].actionFly();
		System.out.println();
		
		System.out.println("로우로봇의 knife 부품을 '장난감 검이 있습니다' 기능으로 업그레이드");
		lowRobot.setKnife(new KnifePlay());
		
		lowRobot.shape();
		lowRobot.actionKnife();
		robots[2].actionKnife();
	} // main
} // class
