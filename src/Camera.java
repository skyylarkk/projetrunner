import javafx.geometry.Rectangle2D;

public class Camera {

    private double x;
    private Integer y;



    public Camera(double x, Integer y) {
        this.x = x;
        this.y = y;
    }
    public void setX(double x) {
        this.x = x;
    }


    @Override
    public String toString() {
        return "Camera{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}
