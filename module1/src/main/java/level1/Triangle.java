package level1;

public class Triangle {
    Triangle() {
    }
    public double area(int xa, int ya, int xb, int yb, int xc, int yc) {
        double trianglearea=Math.abs((double)(xa*(yb-yc)+xb*(yc-ya)+xc*(ya-yb))/2);
        return trianglearea;
    }
}