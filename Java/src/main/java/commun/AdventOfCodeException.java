package commun;

public class AdventOfCodeException extends Exception {

	private static final long serialVersionUID = 1L;

	public AdventOfCodeException(String message) {
		super(message);
	}

	public AdventOfCodeException(String message, Throwable cause) {
		super(message, cause);
	}

}
