package b6.ke_thua.bai_tap.PointMoveablePoint;

import java.util.Arrays;

public class MovablePoint extends Point {
    private float xSpeed = 0;
    private float ySpeed = 0;
    public MovablePoint(){}

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] speed = new float[2];
        speed[0] = getxSpeed();
        speed[1] = getySpeed();
        return speed;
    }
    @Override
    public String toString() {
        return super.toString() + "," + "speed=(" + Arrays.toString(getSpeed()) + ")";
    }

    public String move() {
        this.setX(getX() + xSpeed);
        this.setY(getY() + ySpeed);
        return toString();
    }
}
