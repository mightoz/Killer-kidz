package model.entity.kids;

/**
 * KidFactory
 * @author  MarieKlevedal
 * @version 1.0
 */
//No instances of this class!
public abstract class KidFactory {
	
	public static Kid createKid(KidTypes type, float x, float y) {
		switch(type) {
		case SIMPLE_SAM:
			return new SimpleSam(x, y);
		case SINESTER:
			return new SinEster(x, y);
		case DIZZY_DORIZ:
			return new DizzyDoriz(x, y);
		}
		return null;
	}

}