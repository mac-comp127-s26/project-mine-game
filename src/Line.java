import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;


public class Line {

private Rectangle line;

public Line(int x, int y, int width, int height) { 
    line = new Rectangle(x, y, width, height); 
        line.setFillColor(Color.BLACK);
}


public void addToCanvas(CanvasWindow canvas){
    canvas.add(line);

    }
}