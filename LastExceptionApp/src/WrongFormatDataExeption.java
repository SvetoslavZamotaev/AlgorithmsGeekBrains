public class WrongFormatDataExeption extends Exception{
    public WrongFormatDataExeption(){
        super("Invalid format data");
    }

    public WrongFormatDataExeption(Throwable cause){
        super(cause);
    }
}
