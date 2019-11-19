class Shape {
    public void draw() {

    }
}
class Rect extends Shape{
    @Override
    public void draw() {
        super.draw();
        System.out.println("♦");
    }
}
class Cycle extends Shape{
    @Override
    public void draw() {
        super.draw();
        System.out.println("○");
    }
}
class Flower extends Shape {
    @Override
    public void draw() {
        super.draw();
        System.out.println("❀");
    }
}public class Test {
    public static void main(String[] args) {

    }
}
