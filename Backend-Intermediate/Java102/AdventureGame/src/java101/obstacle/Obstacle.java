package java101.obstacle;

public abstract class Obstacle {
    private Obstacle obstacle; //TODO- obstacle List.
    private int obstacleNumber;

    public Obstacle(Obstacle obstacle, int obstacleNumber) {
        this.obstacle = obstacle;
        this.obstacleNumber = obstacleNumber;
    }
    public abstract void appear();

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public int getObstacleNumber() {
        return obstacleNumber;
    }

    public void setObstacleNumber(int obstacleNumber) {
        this.obstacleNumber = obstacleNumber;
    }
}
