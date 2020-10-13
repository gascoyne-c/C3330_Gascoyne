public class Triangle extends Shape2D {	
	public Triangle(double base, double height) {
		this.area = base * height / 2;
	}
	public String getName() {
		return "triangle";
	}
	public double getArea() {
		return this.area;
	}
}