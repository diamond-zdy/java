abstract class Shape2 {
   /* public void func() {
        System.out.println("func()");
    }*/
    public abstract void draw();//抽象方法
}
class Rect2 extends Shape2{
    @Override
    public void draw() {
        System.out.println("♦");
    }
}
class Cycle2 extends Shape2{
    @Override
    public void draw() {
        System.out.println("○");
    }
}
class Flower2 extends Shape2 {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}
public class TestDemo2 {
    public static void drawMap (Shape2 shape2) {
        shape2.draw();
    }
    public static void main(String[] args) {
        Rect2 rect2 = new Rect2();
        Cycle2 cycle2 = new Cycle2();
        Flower2 flower2 = new Flower2();
        drawMap(rect2);
        drawMap(cycle2);
        drawMap(flower2);
    }
}