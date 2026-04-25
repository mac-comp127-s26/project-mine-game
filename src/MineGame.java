import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;
import java.util.List;

public class MineGame {
    private CanvasWindow canvas;
    private final int CANVAS_WIDTH = 400;
    private final int CANVAS_HEIGHT = 400;
    private Line line;
    private Rectangle tile;
    private int tileSize = 90;// actual tile size
    private int tile_space_size = 132; // adjusts how far spaced between based on the number it gets used in spacing
    private int spacing = (tile_space_size - tileSize) / 2;// spacing in between squares
    private List<Tile> tilesArrayList = new ArrayList<>();
    private boolean hit;
    

    public MineGame() {
        this.canvas = new CanvasWindow("Mine Game!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.BLACK); // sets background color

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

        canvas.onClick(event -> {
            //System.out.println("clicked"); // just keeping this for now that we can keep checking it
            double x = event.getPosition().getX();
            double y = event.getPosition().getY();
            for (Tile t : tilesArrayList) {
                if (t.contains(x, y)) {
                    t.reveal();
                    hit= true; //created a new boolean variable up top.
                    break;   
                }
            }// if the click is outside..
            //the problem is that it only works when there is no green tile
            if (!hit){
                System.out.println("You Clicked Outside the tiles");
            }
        });
    }


    public List<Tile> getTilesArrayList() {
        return tilesArrayList;
    }

    public void runGame() {
    }


    public static void main(String[] args) {

        MineGame mg = new MineGame();
        System.out.println(mg.getTilesArrayList());

    }
}