package exceptions;

public class FileAlreadyExistsException extends RuntimeException{

    public FileAlreadyExistsException(String msg){
        super(msg);
    }
}
