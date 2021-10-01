public class Square extends Shape {
    Square(int side) {
        this.setSide(side);
    }

    public void setSide(int side) {
        super.setWidth(side);
        super.setHeight(side);
    }
}
