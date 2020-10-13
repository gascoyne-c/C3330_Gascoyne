public class Circle extends Shape2D {	
	public Circle(double radius) {
		this.area = Math.PI * Math.pow(radius, 2);
	}
	public String getName() {
		return "circle";
	}
	public double getArea() {
		return this.area;
	}
}