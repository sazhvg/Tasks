package ua.kyiv.sazhyn.volodymyr.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircleTest {

    private static final int SAMPLE_RADIUS = 5;
    private Circle testCircle = new Circle(SAMPLE_RADIUS);

    @Test(expected = IllegalStateException.class)
    public void failToCrateCircleNegativeRadiusThrow() {
        new Circle(-1*SAMPLE_RADIUS);
    }

    @Test(expected = IllegalStateException.class)
    public void setRadiusNegativeThrow(){
        testCircle.setRadius(-1*SAMPLE_RADIUS);
    }
    @Test
    public void checkAreaCircle(){
        assertEquals((SAMPLE_RADIUS * SAMPLE_RADIUS * Math.PI), testCircle.getArea(), 0.01);
    }

    @Test
    public void testNameCircle(){
        assertEquals("коло", testCircle.getName());
    }

    @Test
    public void checkRadiusCircle(){
        assertEquals(SAMPLE_RADIUS, testCircle.getRadius(), 0);
    }

}
