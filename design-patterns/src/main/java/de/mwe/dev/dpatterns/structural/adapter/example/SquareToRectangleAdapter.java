package de.mwe.dev.dpatterns.structural.adapter.example;

class SquareToRectangleAdapter implements Rectangle
{
  Square square;

  public SquareToRectangleAdapter(Square square)
  {
      this.square = square;
  }
  
  @Override
  public int getWidth(){
      return square.side;
  }

  @Override
  public int getHeight(){
      return square.side;
  }

  public static void main(String[] args) {

  }
}
