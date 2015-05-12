package model.kids;

//No instances of this class!
public abstract class KidFactory {
	
	public static Kid createKid(KidTypes type, float x, float y) {
		switch(type) {
		case SIMPLE_SAM:
			return new SimpleSam(x,y);
	    // TODO: add more cases for new kids
		}
		return null;
	}

}