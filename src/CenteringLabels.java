import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

import java.awt.*;

public class CenteringLabels extends GraphicsProgram {

    public void run () {
        GLabel label= new GLabel("This is Seun Salu trying to center this sentence font on my screen with Glabel");

        label.setFont("SanSerif = 36");
        label.setColor(Color.RED);

        double x = getWidth()- label.getWidth()/2; // This calculates the width of the screen minus the width of the sentence

        double y = getHeight() - label.getAscent()/2;  // The height of the screen minus the height of the ascent.

        // An ascent is the distance between the line under the sentence and an imaginary line drawn above the sentence

        add(label,x,y);
    }

}
