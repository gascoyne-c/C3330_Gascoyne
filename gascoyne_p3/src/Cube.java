public class Cube extends Shape3D {	
	public Cube(double side_length) {
		this.area = 6 * Math.pow(side_length, 2);
		this.volume = Math.pow(side_length, 3);
	}
	public String getName() {
		return "cube";
	}
	public double getArea() {
		return this.area;
	}
	public double getVolume() {
		return this.volume;
	}
}