import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;


public class Tile {
    private double  x;
    private double y;
    private double width;
    private double height;
    private boolean mine = false;

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
    }
    else{
    tile.setFillColor(Color.GREEN);
    }
    
}


public boolean contains(double x, double y){
       // return tile.getBounds().contains(x,y);

       //same logic here..check if it the click is inside the tiles..
       //did not work
       // tiles turn green though yay!
        return x>=this.x &&
        x<this.x+this.width &&
        y >=this.y &&
        y<this.y+this.height;

    }


}