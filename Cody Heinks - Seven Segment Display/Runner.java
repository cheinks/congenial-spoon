
/**
 * Write a description of class Runner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Runner{
    Conversions conversions = new Conversions();
    SevenSegmentDisplay[] line;
    String original;
    String binary;
    
    public Runner(String input){
        original = input;
        binary = convert(original);
        binToSSD(binary);
    }
    
    public String convert(String input){
        String output = "";
        String psn;
        for(int i = 0; i<input.length(); i++){
            psn = input.substring(i, i+1);
            if(psn.equals(" ")){
                output += "0000000";
            }else{
                int num = "0123456789".indexOf(psn);
                int letter = "abcdefghijklmnopqrstuvwxyz".indexOf(psn.toLowerCase());
                int punct = ".?!,;-\"".indexOf(psn.toLowerCase());
                
                if(num >= 0){
                    output += conversions.getNumbers()[num];
                }
                else if(letter >= 0){
                    output+= conversions.getLetters()[letter];
                }
                else if(punct >= 0){
                    output+= conversions.getPunctuation()[punct];
                }
            }      
        }
        return output;
    }
    public void binToSSD(String input){
        String binary = input;
        int length = input.length();
        String display;
        
        if(length % 7 > 0){
            binary = binary.substring(0, length - length % 7);
        }
        line = new SevenSegmentDisplay[length/7];
        
        int counter = 0;
        for(int i = 0; i < length/7; i++){
            display = binary.substring(counter, counter + 7);
            line[i] = new SevenSegmentDisplay(display);
            counter += 7;
        }
    }
    
    public void main(){
        for(int i = 0; i < line.length; i++){
            System.out.print(" " + line[i].ssd[0].getImage() + " " + " ");
        }
        System.out.println();
        for(int i = 0; i< line.length; i++){
            System.out.print(line[i].ssd[5].getImage() + line[i].ssd[6].getImage() + line[i].ssd[1].getImage() + " ");
        }
        System.out.println();
        for(int i = 0; i< line.length; i++){
            System.out.print(line[i].ssd[4].getImage() + line[i].ssd[3].getImage() + line[i].ssd[2].getImage() + " ");
        }
    }
}
