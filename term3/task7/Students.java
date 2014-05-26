package task7;

public class Students implements Comparable<Students> {
	private String name;
	private int point;

	public Students(String name, int point) {
		this.name = name;
		this.point = point;
	}

	public String getnName() {
		return name;
	}

	public int getPoint() {
		return point;
	}

	public String toString() {
		return name + " " + point;

	}

	@Override
    public int compareTo(Students s1) {
			if(s1.point > point) {
				return 1;
			}
			else if (s1.point < point){
				return -1;
			}
			else {
				return 0;
			}
		
       
    }
}
