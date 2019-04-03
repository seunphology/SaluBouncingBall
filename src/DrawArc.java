import acm.graphics.GArc;
import acm.program.GraphicsProgram;

public class DrawArc extends GraphicsProgram {

  // private static final double DIAMETER  = 0.8*;

    public void run () {
        /** We want to draw an Arc with starting and sweeping angles of 0 and 90 degrees.
         * A starting angle is the first angle that is drawn in the anticlockwise direction (can be made clockwise if we put a + sign in front of it
         *
         * A sweeping angle is the angle that continues from where the start angle ends...usually larger and anticlockwise except a + sign is added
         * In this,we assume that the diameter of the circle is 0.8 that of the height of the screen, hence the getheigh*0.8
         *
         * 40 and 70 are the assumed coordinates of the window center*/

        GArc a1 = new GArc(getHeight()*0.8, getHeight()*0.8, 0, 90);

        add(a1, 40- getHeight()*0.8/2, 70-getHeight()*0.8/2);

        a1.setFilled(true); // fill up the arc for fun

        add(a1);
    }
}
