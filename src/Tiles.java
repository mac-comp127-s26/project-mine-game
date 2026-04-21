import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;


public class Tiles {

private Rectangle tile;

public Tiles(int x, int y, int width, int height) { // sets intial Tile with fill color, X,Y Corsds
    tile = new Rectangle(x, y, width, height); // new square
        tile.setFillColor(Color.pink);
}


public void addToCanvas(CanvasWindow canvas){
    canvas.add(tile);

    }
}