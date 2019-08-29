
/**
 * Write a description of class SevenSegmentDisplay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SevenSegmentDisplay{
    Segment[] ssd = new Segment[7];
    public SevenSegmentDisplay(String segs){
        if(segs.length() == 7){
            for(int i = 0; i < 7; i++){
                if(segs.substring(i, i+1).equals("0")){
                    ssd[i] = new Segment(i, false);
                }
                else if(segs.substring(i, i+1).equals("1")){
                    ssd[i] = new Segment(i, true);
                }
            }
        }
    }
    
    public void format(){
        System.out.println(" " + ssd[0].getImage() + " ");
        System.out.println(ssd[5].getImage() + ssd[6].getImage() + ssd[1].getImage());
        //System.out.println(" " +  + " ");
        System.out.println(ssd[4].getImage() + ssd[3].getImage() + ssd[2].getImage());
        //System.out.println(" " +  + " ");
    }
}
