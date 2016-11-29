// source: https://www.youtube.com/watch?v=qG286LQM6BU
public class EnemyRobotAdapter implements EnemyAttacker {

	EnemyRobot theRobot;
	public EnemyRobotAdapter(EnemyRobot newRobot) {
		theRobot = newRobot;
	}
	@Override
	public void fireWeapon() {
		theRobot.smashWithHands();
	}

	@Override
	public void driveForward() {
		theRobot.walkForward();
	}

}
