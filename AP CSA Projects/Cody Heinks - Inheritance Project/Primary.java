
/**
 * Write a description of class Primary here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Primary extends Weapon{
    String name;
    int value;
    int damage;
    
    String fatality;
    public Primary(String keyword, String name, int value, int damage){
        super(keyword, name, value, damage);
        fatality = "The enemy, collapses to your feet, leaving you victorious";
    }
    
    public String getFatal(){return fatality;}
    public void setFatal(String newFatal){fatality = newFatal;}
}
