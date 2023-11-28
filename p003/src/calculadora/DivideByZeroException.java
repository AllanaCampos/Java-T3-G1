package calculadora;

public class DivideByZeroException extends ArithmeticException{

	private static final long serialVersionUID = 1L;

	public DivideByZeroException(String statment){
        super(statment);
    }
    
}