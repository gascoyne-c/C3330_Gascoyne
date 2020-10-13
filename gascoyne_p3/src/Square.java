public class Square extends Shape2D {	
	public Square(double side_length) {
		this.area = Math.pow(side_length, 2);
	}
	public String getName() {
		return "square";
	}
	public double getArea() {
		return this.area;
	}
}