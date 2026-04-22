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
    private int tileSize = 90;// actual tile size
    private int tile_space_size = 132; // adjusts how far spaced between based on the number it gets used in spacing
    private int spacing = (tile_space_size - tileSize) / 2;// spacing in between squares
    private List<Tile> tilesArrayList = new ArrayList<>();


    public MineGame() {
        this.canvas = new CanvasWindow("Mine Game", CANVAS_WIDTH, CANVAS_HEIGHT);
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