public class Pyramid extends Shape3D {	
	public Pyramid(double length, double width, double height) {
		this.area = length * width + length * Math.sqrt( Math.pow(width / 2, 2) + Math.pow(height, 2) ) + width * Math.sqrt( Math.pow(length / 2, 2) + Math.pow(height, 2) );
		this.volume = length * width * height / 3;		
	}
	public String getName() {
		return "pyramid";
	}
	public double getArea() {
		return this.area;
	}
	public double getVolume() {
		return this.volume;
	}
}