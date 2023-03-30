package de.mwe.dev.dpatterns.structural.adapter;

public class Line {

  Point start, end;

  public Line(Point start, Point end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public String toString() {
    return "Line [start=" + start + ", end=" + end + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((start == null) ? 0 : start.hashCode());
    result = prime * result + ((end == null) ? 0 : end.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Line other = (Line) obj;
    if (start == null) {
      if (other.start != null)
        return false;
    } else if (!start.equals(other.start))
      return false;
    if (end == null) {
      if (other.end != null)
        return false;
    } else if (!end.equals(other.end))
      return false;
    return true;
  }
}
