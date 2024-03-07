import java.util.Random;

public class Orb {
	private String color;
	
	public Orb() {
		
		Random rand=new Random();
		switch(rand.nextInt(0,5))
		{case 0:
			this.color="Red";
			break;
		case 1: 
			this.color="Blue";
			break;
		case 2: 
			this.color="Yellow";
			break;
		case 3: 
			this.color="Purple";
			break;
		case 4:
			this.color="Green";
			break;
			}
		
		
	}
	public static Orb[][] orbArray() {
		Orb[][] orbsArray=new Orb[5][5];
		for (int i=0;i<orbsArray.length;i++) {
			for(int j=0;j<orbsArray[i].length;j++) {
				orbsArray[i][j]=new Orb();			}
		}
		return orbsArray;
	}
	public Orb(String color) {
		this .color=color;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString(){
		return this.color;
	}
	}
