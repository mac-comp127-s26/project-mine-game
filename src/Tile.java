import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;
//import javax.swing.Timer;
import edu.macalester.graphics.Image;




public class Tile {
    private double  x;
    private double y;
    private double width;
    private double height;
    private boolean mine = false;
    //private int greenCount = 0;

private Rectangle tile ; //extend rectangle .. 

public Tile(double x, double  y, double width, double height) { // sets intial Tile with fill color, X,Y Corsds
   this.x=x;
   this.y=y;
   this.width=width;
   this.height=height;
    tile = new Rectangle(x, y, width, height); // new square
    tile.setFillColor(Color.PINK);
}


public void addToCanvas(CanvasWindow canvas){
    canvas.add(tile);

}

public void setMineup (boolean mine){
    this.mine = mine;
}

public boolean isMine(){
    return mine;
}


public void reveal() {
    if (mine) {
        tile.setFillColor(Color.RED);
        //System.out.println("You stepped on the mine");
    }
    else{
    tile.setFillColor(Color.GREEN);

    }
    
}


public boolean contains(double x, double y){
        return x>=this.x &&
        x<this.x+this.width &&
        y >=this.y &&
        y<this.y+this.height;

    }


}