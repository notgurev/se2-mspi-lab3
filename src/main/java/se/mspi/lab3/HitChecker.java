package se.mspi.lab3;

import static java.lang.Math.pow;

public class HitChecker {
    public Shot shoot(float x, float y, float r) {
        if (r < 0) throw new IllegalArgumentException("Радиус не может быть меньше 0");
        boolean result;
        if (x >= 0) {
            if (y >= 0) {
                // Прямоугольник
                result = x <= r && y <= r / 2;
            } else {
                // Четверть круга
                result = pow(x, 2) + pow(y, 2) <= pow(r, 2);
            }
        } else {
            if (y >= 0) {
                // Треугольник
                result = y <= x + r / 2;
            } else {
                // Ничего
                result = x == 0 && y <= -r;
            }
        }
        return new Shot(x, y, r, result);
    }
}
