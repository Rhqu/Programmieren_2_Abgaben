package thd.gameobjects.base;

public class Position {
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        this(0, 0);
    }

    public Position(Position other) {
        this(other.getX(), other.getY());
    }

    public void left() {
        this.x--;
    }

    public void left(double pixel) {
        this.x -= pixel;
    }


    public void right() {
        this.x++;
    }

    public void right(double pixel) {
        this.x += pixel;
    }

    public void up() {
        this.y--;
    }

    public void up(double pixel) {
        this.y -= pixel;
    }

    public void down() {
        this.y++;
    }

    public void down(double pixel) {
        this.y += pixel;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public void updateCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void updateCoordinates(Position other) {
        this.x = other.getX();
        this.y = other.getY();
    }

    @Override
    public String toString() {
        return String.format("Position (%d, %d)", (int) Math.round(x), (int) Math.round(y));
    }

}
