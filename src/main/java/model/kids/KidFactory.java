package model.kids;

//No instances of this class!
public abstract class KidFactory {
	
	private static int width, height;
	
	public static void setDimensions(int w, int h) {
		width = w;
		height = h;
	}
	
	public static Kid createKid(KidTypes type, float x, float y) {
		switch(type) {
		case SIMPLE_SAM:
			return new SimpleSam(x, y, width, height);
	    // TODO: add more cases for new kids
		}
		return null;
	}

}