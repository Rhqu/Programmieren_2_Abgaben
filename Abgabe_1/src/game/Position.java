package game;

public class Position {
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void left() {
        this.x--;
    }

    public void right() {
        this.x++;
    }

    public void up() {
        this.y--;
    }

    public void down() {
        this.y++;
    }

    @Override
    public String toString() {
        return String.format("Position (%d, %d)", (int) Math.round(x), (int) Math.round(y));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
