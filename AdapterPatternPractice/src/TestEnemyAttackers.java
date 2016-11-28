// source: https://www.youtube.com/watch?v=qG286LQM6BU
public class TestEnemyAttackers {
	public static void main(String[] args) {
		EnemyTank tank = new EnemyTank();
		EnemyRobot robot = new EnemyRobot();
		EnemyAttacker robotAdapter = new EnemyRobotAdapter(robot);
		
		System.out.println("The Robot");
		robot.walkForward();
		robot.smashWithHands();
		
		System.out.println("The Tank");
		tank.driveForward();
		tank.fireWeapon();
		
		System.out.println("The Robot with Adapter");
		robotAdapter.driveForward();
		robotAdapter.fireWeapon();
	}
}
