package de.mwe.dev.dpatterns.structural.adapter.example;


interface Rectangle
{
  int getWidth();
  int getHeight();

  default int getArea()
  {
    return getWidth() * getHeight();
  }
}
