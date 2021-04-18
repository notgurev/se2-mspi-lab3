package se.mspi.lab3;

public class Shot {
    private float x;
    private float y;
    private float r;
    private boolean successful;

    public Shot(float x, float y, float r, boolean successful) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.successful = successful;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String fancyResult() {
        return String.format("x = %s, y = %s, r = %s, результат: %s", x, y, r, successful ? "попадание" : "промах");
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
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

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }
}
