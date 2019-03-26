
/**
 * Write a description of class Shield here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shield extends Secondary{
    
    int durable;
    public Shield(String keyword, String name, int value, int damage){
        super(keyword, name, value, damage);
        durable = damage;
    }
    
    public int block(int damage){
        int newDamage = 0;
        if(durable >= damage){
            durable = (int)(durable * 0.9);
        }else{
            durable = 0;
            newDamage = damage - durable;
        }
        return newDamage;
    }
}
