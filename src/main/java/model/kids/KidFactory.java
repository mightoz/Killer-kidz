package model.kids;

//No instances of this class!
public abstract class KidFactory {
	
	public static Kid createKid(KidTypes type, float x, float y) {
        switch(type) {
		case SIMPLE_SAM:
			return new SimpleSam(x, y);
		case SINESTER:
			return new SinEster(x, y);
		}
		return null;
	}

}