public class WrongInputSizeException extends Exception{


    public WrongInputSizeException(){
        super("Wrong input size data, must be 4");
    }

    public WrongInputSizeException(Throwable cause){
        super(cause);
    }

}
