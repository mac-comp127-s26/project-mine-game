import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;

// import edu.macalester.graphics.Rectangle;
import java.util.List;
import java.util.Random;


public class MineGame {
    private CanvasWindow canvas;
    private final int CANVAS_WIDTH = 500;
    private final int CANVAS_HEIGHT = 500;
    private Line line;
    private int tileSize = 90;// actual tile size
    private int tile_space_size = 132; // adjusts how far spaced between based on the number it gets used in spacing
    private int spacing = (tile_space_size - tileSize) / 2;// spacing in between squares
    private List<Tile> tilesArrayList = new ArrayList<>();
    private boolean hit;
    private Random rand = new Random();
    private boolean redTile = false ;


    public MineGame() {
        this.canvas = new CanvasWindow("Mine Game!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.black); // sets background color


        Grid();

        // line = new Line(125, 0, 20, 400); // first vertical line
        // line.addToCanvas(canvas);

        // line = new Line(0, 125, 400, 20); // first horizontal line
        // line.addToCanvas(canvas);

        // line = new Line(250, 0, 20, 400); // second vertical line
        // line.addToCanvas(canvas);

        // line = new Line(0, 250, 400, 20); // second horizontal line or bottom
        // line.addToCanvas(canvas);

        // for (int row = 0; row < 3; row++) {
        //     for (int col = 0; col < 3; col++) {
        //         int x = col * tile_space_size + spacing;
        //         int y = row * tile_space_size + spacing;
        //         Tile tile = new Tile(x, y, tileSize, tileSize);
        //         tilesArrayList.add(tile);
        //         tile.addToCanvas(canvas);
        //     }
        // }

        // int randomIndex = rand.nextInt(tilesArrayList.size());
        // tilesArrayList.get(randomIndex).setMineup(true);
         

        canvas.onClick(event -> {
            System.out.println(tilesArrayList); // just keeping this for now that we can keep checking it
            double x = event.getPosition().getX();
            double y = event.getPosition().getY();
            for (Tile t : tilesArrayList) {
                if (t.contains(x, y)) {
                    t.reveal();
                    canvas.draw();
                    hit = true; // created a new boolean variable up top.
                    if (t.isMine()) {
                        t.reveal();
                        canvas.removeAll();
                        showBomb();
                        showExplosion();
                        canvas.draw();
                        canvas.pause(2500); // should we make it less time?
                        canvas.add(getText());
                        reset();
    
                    }
                    break;
                    
                }
            }// if the click is outside..
             // the problem is that it only works when there is no green tile
            if (!hit) {
                System.out.println("You Clicked Outside the tiles");
            }
        });
    }

    public void showBomb() {
        Image bomb = new Image("bomb.png");
        bomb.setPosition(-70, 30);
        bomb.setScale(CANVAS_WIDTH / bomb.getWidth(), CANVAS_HEIGHT / bomb.getHeight()
    );

    canvas.add(bomb);
    }

    public void showExplosion() {
        Image explosion = new Image("explosion.png");
        explosion.setPosition(-250, -100);
        explosion.setScale(CANVAS_WIDTH / explosion.getWidth(), CANVAS_HEIGHT / explosion.getHeight()
    );

    canvas.add(explosion);
    }


    public void reset(){
        canvas.removeAll();
        tilesArrayList.clear();
        Grid();
    }

    public List<Tile> getTilesArrayList() {
        return tilesArrayList;
    }

    public GraphicsText getText(){
            GraphicsText loseText = new GraphicsText("YOU LOSE!!",40,100);
                    loseText.setFontSize(90);
                    loseText.setFillColor(Color.red);
                    return loseText;

        }

    public void runGame() {
    }
public void Grid(){
    line = new Line(125, 0, 20, 400); // first vertical line
        line.addToCanvas(canvas);

        line = new Line(0, 125, 400, 20); // first horizontal line
        line.addToCanvas(canvas);

        line = new Line(250, 0, 20, 400); // second vertical line
        line.addToCanvas(canvas);

        line = new Line(0, 250, 400, 20); // second horizontal line or bottom
        line.addToCanvas(canvas);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int x = col * tile_space_size + spacing;
                int y = row * tile_space_size + spacing;
                Tile tile = new Tile(x, y, tileSize, tileSize);
                tilesArrayList.add(tile);
                tile.addToCanvas(canvas);
            }
        }
        int randomIndex = rand.nextInt(tilesArrayList.size());
        tilesArrayList.get(randomIndex).setMineup(true);
}

    public static void main(String[] args) {

        MineGame mg = new MineGame();
        mg.getText();

    }
}