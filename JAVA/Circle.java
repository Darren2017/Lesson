public class Circle{
    double x, y, radius;

    Circle(){}

    Circle(double x, double y){
        this.x = x;
        this.y = y;
    }

    Circle(double radius){
        this.radius = radius;
    }

    Circle(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void setX(double a){
        this.x = a;
    }

    public double getX(){
        return x;
    }

    public void setY(double b){
        this.y = b;
    }

    public double getY(){
        return this.y;
    }

    public void setRadius(double r){
        this.radius = r;
    }

    public double getRadius(){
        return this.radius;
    }
}