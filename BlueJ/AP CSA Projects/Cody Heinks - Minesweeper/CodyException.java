
/**
 * Write a description of class CodyException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CodyException extends Exception
{
    String message;
    public CodyException(){
        this("Unknown COdyError");
    }
    public CodyException(String message){
     this.message = message;
    }
}
