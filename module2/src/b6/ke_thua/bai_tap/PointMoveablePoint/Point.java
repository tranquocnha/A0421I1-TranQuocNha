package b6.ke_thua.bai_tap.PointMoveablePoint;

import java.util.Arrays;

public class Point {
    private float x =0;
    private float y=0;
    public Point(){}

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x,float y){
        this.x = x;
        this.y = y;
    }
    public float[] getXY(){
        float[] xy = new float[2];
        xy[0]=this.x;
        xy[1]=this.y;
        return xy;
    }
    @Override
    public String toString(){
        return "tọa độ của point2d "+"("+ Arrays.toString(getXY())+")";
    }
}
