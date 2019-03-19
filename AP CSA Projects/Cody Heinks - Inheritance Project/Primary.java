
/**
 * Write a description of class Primary here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Primary extends Weapon{
    String name;
    String description;
    int value;
    int damage;
    
    String fatality;
    public Primary(String keyword, String name, int value, int damage, String fatality){
        super(keyword, name, value, damage);
        this.fatality = fatality;
    }
    
    public String getFatal(){return fatality;}
}
