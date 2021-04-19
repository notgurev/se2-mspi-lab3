package se.mspi.lab3;

import org.junit.*;
import org.junit.rules.ExpectedException;

public class HitCheckerTest {
    private HitChecker hitChecker;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void whenNegativeRadius(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Радиус не может быть меньше 0");
        hitChecker.shoot(69, 42, -1);
    }
}
