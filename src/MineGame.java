import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import java.util.List;
import java.util.Random;


public class MineGame {
    private CanvasWindow canvas;
    private final int CANVAS_WIDTH = 500;
    private final int CANVAS_HEIGHT = 500;
    private Line line;
    private int tileSize = 110;
    private int tile_space_size = 160;
    private int spacing = (tile_space_size - tileSize) / 2;
    private List<Tile> tilesArrayList = new ArrayList<>();
    private boolean hit;
    private Random rand = new Random();
    private int greenCount = 0;


    public MineGame() {
        this.canvas = new CanvasWindow("Mine Game!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.black);


        Grid();


        canvas.onClick(event -> {
            double x = event.getPosition().getX();
            double y = event.getPosition().getY();
            for (Tile t : tilesArrayList) {
                if (t.contains(x, y)) {
                    t.reveal();
                    canvas.draw();
                    hit = true; 
                    if (t.isMine()) {
                        t.reveal();
                        canvas.removeAll();
                        showBomb();
                        showExplosion();
                        canvas.draw();
                        canvas.pause(2000);
                        greenCount = 0;
                        reset();

                    } else {
                        greenCount++;
                        if (greenCount == 6) {
                            canvas.removeAll();
                            showCongrats();
                            canvas.draw();
                            canvas.pause(2000);
                            greenCount = 0;
                            reset();
                        }
                    }
                    break;

                }
            }
        });
    }

    public void showBomb() {
        Image bomb = new Image("bomb.png");
        double x = (CANVAS_WIDTH - bomb.getWidth()) / 2;
        double y = (CANVAS_HEIGHT - bomb.getHeight()) / 2;

        bomb.setPosition(x, y);

        canvas.add(bomb);
    }

    public void showExplosion() {
        Image explosion = new Image("explosion.png");
        explosion.setPosition(-250, -100);
        explosion.setScale(CANVAS_WIDTH / explosion.getWidth(), CANVAS_HEIGHT / explosion.getHeight());

        canvas.add(explosion);
    }

    public void showCongrats() {
        Image congrats = new Image("congrats.png");
        double x = (CANVAS_WIDTH - congrats.getWidth()) / 2;
        double y = (CANVAS_HEIGHT - congrats.getHeight()) / 2;

        congrats.setPosition(x, y);

        canvas.add(congrats);
    }

    public void reset() {
        canvas.removeAll();
        tilesArrayList.clear();
        Grid();
    }

    public List<Tile> getTilesArrayList() {
        return tilesArrayList;
    }


    public void runGame() {
    }

    public void Grid() {
        line = new Line(125, 0, 20, 400); 
        line.addToCanvas(canvas);

        line = new Line(0, 125, 400, 20); 
        line.addToCanvas(canvas);

        line = new Line(250, 0, 20, 400); 
        line.addToCanvas(canvas);

        line = new Line(0, 250, 400, 20); 
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

    }
}