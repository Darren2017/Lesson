public class Rectangle{
    double x, y, width, height;

    Rectangle(){}

    Rectangle(double x, double y){
        this.x = x;
        this.y = y;
    }

    Rectangle(double x, double y, double w, double h){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public void setX(double a){
        this.x = a;
    }

    public double getX(){
        return this.x;
    }

    public void setY(double b){
        this.y = b;
    }

    public double getY(){
        return this.y;
    }

    public void setWidth(double w){
        if(w > 0){
            this.width = w;
        }
    }

    public double getWidth(){
        return this.width;
    }

    public void setHeight(double h){
        if(h > 0){
            this.height = h;
        }
    }

    public double getHeight(){
        return this.height;
    }
}