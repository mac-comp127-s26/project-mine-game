import edu.macalester.graphics.CanvasWindow;

public class MineGame {
    private CanvasWindow canvas;
    private final int CANVAS_WIDTH = 400;
    private final int CANVAS_HEIGHT = 400;

    public MineGame() {
        this.canvas = new CanvasWindow("Mine Game", CANVAS_WIDTH, CANVAS_HEIGHT);

        
    }
    

    public void runGame() {
    }




    public static void main(String[] args) {
        new MineGame();
    }
    
}
