public class Example4_7{
    public static void main(String[] args){
        Geometry geometry;
        geometry = new Geometry(260, 30, 60, 30, 40, 120, 80);
        System.out.println("几何图形中圆和矩形的位置关系是：");
        geometry.showState();
        System.out.println("几何图形重新调整了圆和矩形的位置关系");
        geometry.setRectanglePosition(220, 160);
        geometry.setCirclePosition(40, 30);
        System.out.println("调整后，几何图形中圆和矩形的位置关系是：");
        geometry.showState();

    }
}