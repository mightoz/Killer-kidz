package model.entity.kids;

/**
 * Name:	KidFactory
 * About:	This is where all the evil kids are created. 
 * 			There are no instances of this class (it's abstract).
 * @author  MarieKlevedal
 * @version 1.0
 */
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