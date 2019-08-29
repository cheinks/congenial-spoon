
/**
 * Write a description of class Conversions here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Conversions{
    private String[] numbers = new String[10];
    private String[] letters = new String[26];
    private String[] punctuation = new String[7];//
    
    public Conversions(){
        //##### Numbers #####
        numbers[0] = "1111110";
        numbers[1] = "0110000";
        numbers[2] = "1101101";
        numbers[3] = "1111001";
        numbers[4] = "0110011";
        numbers[5] = "1011011";
        numbers[6] = "1011111";
        numbers[7] = "1110000";
        numbers[8] = "1111111";
        numbers[9] = "1111011";
        
        //##### Letters #####
        letters[0] = "1110111";//A
        letters[1] = "0011111";//b
        letters[2] = "1001110";//C
        letters[3] = "0111101";//d
        letters[4] = "1001111";//E
        letters[5] = "1000111";//F
        letters[6] = "1011110";//G
        letters[7] = "0110111";//H
        letters[8] = "0000110";//I
        letters[9] = "0111100";//J
        letters[10] = "0101110";//k
        letters[11] = "0001110";//L
        letters[12] = "1110110";//M
        letters[13] = "0010101";//n
        letters[14] = "0011101";//o
        letters[15] = "1100111";//P
        letters[16] = "1110011";//q
        letters[17] = "0000101";//r
        letters[18] = "0011010";//S
        letters[19] = "0001111";//t
        letters[20] = "0011100";//u
        letters[21] = "0111110";//V
        letters[22] = "0111111";//W
        letters[23] = "0110111";//X
        letters[24] = "0111011";//Y
        letters[25] = "1101100";//Z
        
        //##### Punctuation #####
        punctuation[0] = "0010000";//.
        punctuation[1] = "1100101";//?
        punctuation[2] = "0101000";//!
        punctuation[3] = "0011000";//,
        punctuation[4] = "0011001";//;
        punctuation[5] = "0000001";//-
        punctuation[6] = "0100010";//"
    }
    
    public String[] getNumbers(){return numbers;}
    public String[] getLetters(){return letters;}
    public String[] getPunctuation(){return punctuation;}
}
