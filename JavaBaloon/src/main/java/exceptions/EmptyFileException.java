package exceptions;

public class EmptyFileException extends RuntimeException{

    public EmptyFileException(String msg){
        super(msg);
    }
    public EmptyFileException(){
        super();
    }
}
