package b6.ke_thua.bai_tap.Point2dPoint3d;

import java.util.Arrays;

public class Point3d extends Point2d {
    private float z = 0;

    public Point3d() {
    }

    public Point3d(float z) {
        this.z = z;
    }

    public Point3d(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setXYZ(float x, float y, float z) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }
    public float[] getXYZ() {
        float[] xyz = new float[3];
        xyz[0] = getX();
        xyz[1] = getY();
        xyz[2] = getZ();
        return xyz;
    }

    @Override
    public String toString() {
        return "tọa độ của point3d " + "(" + Arrays.toString(getXYZ()) + ")";
    }
}
