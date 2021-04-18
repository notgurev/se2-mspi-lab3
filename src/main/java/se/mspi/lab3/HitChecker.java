package se.mspi.lab3;

import static java.lang.Math.pow;

public class HitChecker {
    public Shot shoot(float x, float y, float r) {
        // Выкидывать исключение при R < 0 ?
        // todo переписать под вариант
        boolean result;
        if (x >= 0) {
            if (y >= 0) {
                // Ничего
                result = false;
            } else {
                // Треугольник, над прямой y = x - R
                result = y > x - r;
            }
        } else {
            if (y >= 0) {
                // Четверть круга
                result = pow(x, 2) + pow(y, 2) <= pow(r, 2);
            } else {
                // Прямоугольник
                result = x >= -r && y >= -((float) r) / 2;
            }
        }
        return new Shot(x, y, r, result);
    }
}
