package strategy1.step3;

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
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
			
		} // for
	} // main
} // class
