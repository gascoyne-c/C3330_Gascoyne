public class Sphere extends Shape3D {	
	public Sphere(double radius) {
		this.area = 4 * Math.PI * Math.pow(radius, 2);
		this.volume = 4.0 / 3.0 * Math.PI * Math.pow(radius, 3);
	}
	public String getName() {
		return "sphere";
	}
	public double getArea() {
		return this.area;
	}
	public double getVolume() {
		return this.volume;
	}
}