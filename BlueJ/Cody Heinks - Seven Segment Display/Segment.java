
/**
 * Write a description of class Segment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Segment{
    int position;
    String image; //Can be text or an image
    
    public Segment(int pos, boolean on){
        position = pos;
        if(on){
            if(pos == 0){image = "_";}
            else if(pos%3 == 0){image = "_";}
            else if(pos%2 == 0){image = "|";}
            else if(pos%2 == 1){image = "|";}
        }else{image = " ";}
    }
    
    public String getImage(){return image;}
    public void newImage(String c){image = c;}
}
