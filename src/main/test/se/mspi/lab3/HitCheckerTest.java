package se.mspi.lab3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HitCheckerTest {
    private HitChecker hitChecker;
    private final int r = 10;

    @Before
    public void init() {
        hitChecker = new HitChecker();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionOnNegativeRadius() {
        hitChecker.shoot(69, 42, -1);
    }

    @Test
    public void firstQuarterTest(){
        for (int y = 0; y <= r; y++){
            for (int x = 0; x <= r; x++){
                assertEquals(hitChecker.shoot(x, y, r).isSuccessful(),y <= r/2);
            }
        }
    }

    @Test
    public void secondQuarterTest(){
        for (int y = 0; y < r; y++){
            for (int x = 0; x >= -r; x--){
                assertEquals(hitChecker.shoot(x, y, r).isSuccessful(), y <= x + r/2);
            }
        }
    }

    @Test
    public void thirdQuarterTest(){
        for (int y = -1; y >= -r; y--){
            for (int x = -1; x >= -r; x--){
                assertFalse(hitChecker.shoot(x, y, r).isSuccessful());
            }
        }
    }

    @Test
    public void fourthQuarterTest(){
        for (int y = 0; y >= -r; y--){
            for (int x = 0; x < r; x++){
                assertEquals(hitChecker.shoot(x, y, r).isSuccessful(),
                        x*x + y*y <= r*r);
            }
        }
    }

    @Test
    public void shotOutsideTest(){
        for (int i = 0; i < 5; i++){
            float constant = (float) (Math.random()  + 1.1)*r;
            assertFalse(hitChecker.shoot(constant, constant, r).isSuccessful());
            assertFalse(hitChecker.shoot(-constant, constant, r).isSuccessful());
            assertFalse(hitChecker.shoot(-constant, -constant, r).isSuccessful());
            assertFalse(hitChecker.shoot(constant, -constant, r).isSuccessful());
        }
    }

    @Test
    public void scalabilityTest(){
        boolean firstQ = hitChecker.shoot(1, 1, 1).isSuccessful();
        boolean secondQ = hitChecker.shoot(-1, 1, 1).isSuccessful();
        boolean thirdQ = hitChecker.shoot(-1, -1, 1).isSuccessful();
        boolean fourthQ = hitChecker.shoot(1, -1, 1).isSuccessful();

        for (int i = 0; i < 5; i++) {
            float constant = (float) Math.random();
            assertEquals(hitChecker.shoot(constant, constant, constant).isSuccessful(), firstQ);
            assertEquals(hitChecker.shoot(-constant, constant, constant).isSuccessful(), secondQ);
            assertEquals(hitChecker.shoot(-constant, -constant, constant).isSuccessful(), thirdQ);
            assertEquals(hitChecker.shoot(constant, -constant, constant).isSuccessful(), fourthQ);
        }
    }
}
