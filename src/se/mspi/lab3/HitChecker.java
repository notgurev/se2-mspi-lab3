package se.mspi.lab3;

import static java.lang.Math.pow;

public class HitChecker {
    private static boolean doCheck(int x, float y, int R) {
        // Выкидывать исключение при R < 0 ?
        // todo переписать под вариант
        if (x >= 0) {
            if (y >= 0) {
                // Ничего
                return false;
            } else {
                // Треугольник, над прямой y = x - R
                return y > x - R;
            }
        } else {
            if (y >= 0) {
                // Четверть круга
                return pow(x, 2) + pow(y, 2) <= pow(R, 2);
            } else {
                // Прямоугольник
                return x >= -R && y >= -((float) R) / 2;
            }
        }
    }
}
