package ch11.lectures.portableexample;

public abstract class AbstractPortable implements Portable {
	private double weight;
	
	@Override public double getWeight() {return weight;};
	
	@Override public void setWeight(double weight) {this.weight = weight;};
	
	@Override public String toString() {return getClass().getName() + "[weight=" + weight + "]";};
}
