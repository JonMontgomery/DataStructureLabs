public class DuplicateKeyException extends RuntimeException{

	public DuplicateKeyException(){ super("Cannot insert duplicate keys"); }
	
}