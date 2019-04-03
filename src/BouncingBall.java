import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class BouncingBall extends GraphicsProgram {
    /** Diameter of the ball */
private static final double DIAM_BALL = 30;

/** Amount by which the velocity of Y is increased as a result of Gravity after every cycle or bounce */

private static final double GRAVITY = 3;

/** Animation delay or pause time between ball moves*/

private static final int DELAY = 50;

/** Initial X and Y location of the ball*/

private static final double X_START = DIAM_BALL/2;

private static final double Y_START = 100;

/** X velocity*/

private static final double X_VEL = 5;

/** Amount X velocity reduces when it bounces*/

private static final double BOUNCE_REDUCE = 0.9; // keeps 90% of its speed.

/**Starting X and Y velocity*/

private double Xvel = X_VEL; //unchanging

private double Yvel = 0.0; // changing from point 0,0 on the top of the screen down the screen and then bounce

/** Private instance variable*/

private GOval ball; // the ball to be created and that will be bouncing around


public void run (){

    setup(); // builds an oval ball that is filled in the starting location

    // simulation ends when the ball goes off right of the screen
    //End of screen

    while (ball.getX() < getWidth()){
        moveBall(); // move the ball

        checkForCollusion(); // check if ball has hit the bottom of the screen

        pause(DELAY); // once ball hits bottom,pause before bouncing the ball again



    }
}

/** Create and place ball*/

private void setup(){

    ball = new GOval(X_START, Y_START, DIAM_BALL, DIAM_BALL);

    ball.setFilled(true);

    add(ball);
}

/**Update and move ball */

private void moveBall () {
    // increases yvelocity due to gravity on every cycle

    Yvel+= GRAVITY;

    ball.move(Xvel,Yvel);// move the ball in the X and Y direction...X will be a constant movement but Y will vary up and down
}

/** Determine if ball collides with foor; update velocities and locations as appropriate */

private void checkForCollusion (){

    if (ball.getY() > getHeight() - DIAM_BALL) {// check if the Y location of the ball is greater than the height of the screen minus the ball's diameter.If it is,that means the ball has hit the bottom of the screen yet

        // change ball's Y velocity to now bounce upwards

        Yvel = -Yvel* BOUNCE_REDUCE; // now that the ball has hit bottom, we tell it to move in the opposite direction where Y is now decreasing (which is up...hence the minus) mu

        //it will slow down everytime it bounces as the operation above is always performed....only 90% or 0.9 (bounce_reduce) of the velocity is kept


        //Assume bounce will move ball an amount above the floor equal to the amount it would have dropped below the floor...check code below. The game works even without it.



        double diff =ball.getY()-(getHeight()) - DIAM_BALL;

        ball.move(0, -2*diff);
    }


}

}
