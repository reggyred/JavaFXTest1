package pl.sii.model;

public class Coordinates {

	float positionX;
	float positionY;

	public Coordinates() {
		this.positionX = 0;
		this.positionY = 0;
	}

	public Coordinates(float positionX, float positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public void setCoordinates(float positionX, float positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public Coordinates getCoordinates() {
		return this;
	}

	public void setX(float x) {
		positionX = x;
	}

	public void setY(float y) {
		positionY = y;
	}

	public double getX() {
		return positionX;
	}

	public double getY() {
		return positionY;
	}
}
