import java.util.Scanner;

public class Class_13_Durts {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String[] buf = console.nextLine().trim().split("\\s+");
		double cx = Double.parseDouble(buf[0]);
		double cy = Double.parseDouble(buf[1]);
		double r = Double.parseDouble(console.nextLine().trim());
		int numPoints = Integer.parseInt(console.nextLine().trim());
		buf = console.nextLine().trim().split("\\s+");
		console.close();
		for(int i=0; i<numPoints; i++)
		{
			double px = Double.parseDouble(buf[2*i]);
			double py= Double.parseDouble(buf[2*i+1]);
			System.out.println(WithinTarget(px, py, cx, cy, r)?"yes":"no");
		}
	}

	private static boolean WithinTarget(double px, double py, double cx,
			double cy, double r) {
		if(	inRectangle(px, py, cx-r/2.0, cx+r/2.0, cy-r, cy+r)
			||
			inRectangle(px, py, cx-r, cx+r, cy-r/2.0, cy+r/2.0)
		){
			return true;
		}
		return false;
	}

	private static boolean inRectangle(double x, double y, double xMin,
			double xMax, double yMin, double yMax) {
		if(x>=xMin && x<=xMax && y>=yMin && y<=yMax){
			return true;
		}
		return false;
	}
}
