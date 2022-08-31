/**
 * 
 */
package de.mwe.dev.design.patterns.solid.lsp;

/**
 * @author mars
 * 
 */
public class Square extends Rectangle {

	public Square() {
	}

	public Square(int size) {
		width = height = size;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
		this.height = width;
	}

	@Override
	public void setHeight(int height) {
		this.width = height;
		this.height = height;
	}

}
