public class Square extends Shape {
    Square(int side) {
        this.setSide(side);
    }

    public int getSide() {
      return super.getWidth();
    }

    public void setSide(int side) {
        super.setWidth(side);
        super.setHeight(side);
    }
}
