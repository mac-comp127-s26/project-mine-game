import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

public class MineGame {
    private CanvasWindow canvas;
    private final int CANVAS_WIDTH = 400;
    private final int CANVAS_HEIGHT = 400;
    private Line line;

    public MineGame() {
        this.canvas = new CanvasWindow("Mine Game", CANVAS_WIDTH, CANVAS_HEIGHT);

        line = new Line(canvas);
        line.addToCanvas(canvas);
        
    }

    public void runGame() {

    }




    public static void main(String[] args) {

        new MineGame();
    }
    
}
