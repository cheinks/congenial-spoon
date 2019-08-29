
/**
 * Write a description of class Test2 here.
 *
 * @author Cody Heinks
 * @version 11.17.18
 */
public class Test2{
    String[] f = new String[7];//f for 7-segment display 'f'ormat
    public Test2(){
        f[0] = "_";
        f[1] = "|";
        f[2] = "|";
        f[3] = "_";
        f[4] = "|";
        f[5] = "|";
        f[6] = "_";
    }
    
    public void main(){
        display(f);
    }
    
    public void display(String[] ssd){
        System.out.println(" " + ssd[0] + " ");
        System.out.println(ssd[5] + ssd[6] + ssd[1]);
        //System.out.println(" " +  + " ");
        System.out.println(ssd[4] + ssd[3] + ssd[2]);
        //System.out.println(" " +  + " ");
    }
    
    public String[][] binToSSD(String x){
        String input = x;
        String[][] output;
        int length = input.length();
        String segment;
        String pos;
        
        if(length % 7 > 0){
            input = input.substring(0, length-length%7);
        }
        output = new String[length/7][7];
        
        int counter = 0;
        for(int i = 0; i < length/7; i++){
            segment = input.substring(counter, counter + 7);
            for(int j = 0; j<7; j++){
                pos = segment.substring(j, j+1);
                if(pos.equals("0")){
                    output[i][j] = " ";
                }else if(pos.equals("1")){
                    output[i][j] = f[j];
                }
            }
            display(output[i]);
            counter += 7;
        }
        
        return output;
    }
}
