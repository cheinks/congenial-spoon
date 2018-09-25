
/**
 * This is a (P)izza.
 *
 * @author Cody Heinks
 * @version 9.7.18
 */
public class Pizza
{
    //Fields
    private String crust;
    private int pieces;
    private String brand;
    private boolean pepperoni;
    private boolean vegetables;
    
    //Constructor
    public Pizza(String crust, int pcs, String brand, boolean ppp, boolean combo){
        this.crust = crust;
        pieces = pcs;
        this.brand = brand;
        pepperoni = ppp;
        vegetables = combo;
    }
    public Pizza(){
        this("Thin", 8, "DiGiorno", true, true);
    }
    
    //Accessors
    public String getCrust(){
        return crust;
    }
    public int getPieces(){
        return pieces;
    }
    public String getBrand(){
        return brand;
    }
    public boolean getPpp(){
        return pepperoni;
    }
    public boolean getCombo(){
        return vegetables;
    }
    
    //Mutators
    public void setCrust(String crust){
        this.crust = crust;
    }
    public void setPieces(int pieces){
        this.pieces = pieces;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setPpp(boolean ppp){
        pepperoni = ppp;
    }
    public void setCombo(boolean combo){
        vegetables = combo;
    }
    
    //Methods
    public static void orderPizza(){
        System.out.println("Your pizza will arrive in 20 minutes");
        System.out.println("1 hour later: *ding dong*");
    }
    public void eatPizza(){
        System.out.println("Mmm... Delicious");
        pieces--;
    }
    public void cheeseAndPeppers(){
        System.out.println("Pass me the cheese and peppers please!");
        System.out.println();
        System.out.println("Oh, darn! I put too much. Guess I'll give this to the dog");
    }
}
