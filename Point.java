public class Point extends java.awt.Point{


    public Point(int x, int y){
	super(x, y);
    }


    public boolean equals(Point point){
	return this.x == point.x && this.y == point.y;
    }
}
