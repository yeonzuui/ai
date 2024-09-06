package strategy1.step2;

public class RobotTestMain {
	public static void main(String[] args) {
		// 객체 변수 생성
		SuperRobot superRobot = new SuperRobot();
		StandardRobot standardRobot = new StandardRobot();
		LowRobot lowRobot = new LowRobot();
		
		// Robot 배열 생성
		Robot [] robots = {superRobot, standardRobot, lowRobot};
		
		// 확장 for문을 통한 호출
		for (Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			// 객체 형변환
			if(robot instanceof SuperRobot) { // instanceof: 객체의 타입을 물어봄
				SuperRobot tempRobot = (SuperRobot)robot;
				tempRobot.actionFly();
				tempRobot.actionMissile();
				tempRobot.actionKnife();
			}else if (robot instanceof StandardRobot) {
				StandardRobot tempRobot = (StandardRobot)robot;
				tempRobot.actionFly();
				tempRobot.actionMissile();
				tempRobot.actionKnife();
			}else if (robot instanceof LowRobot) {
				LowRobot tempRobot = (LowRobot)robot;
				tempRobot.actionFly();
				tempRobot.actionMissile();
				tempRobot.actionKnife();
		    } // if
		} // for
	} // main
} // class
