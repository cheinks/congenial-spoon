
/**
 * Write a description of class Project here.
 *
 * @author Cody Heinks
 * @version 1.18.19
 */
import java.util.ArrayList;
public class Project{
    ArrayList<String> colors;
    //1
    public Project(){
        colors = new ArrayList();
        colors.add("Red");
        colors.add("Orange");
        colors.add("Yellow");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Indigo");
        colors.add("Violet");
        System.out.println(colors);
    }
    //2
    public void display(){
        for(String color : colors){
            System.out.println(color);
        }
    }
    //3
    public void addPos1(String newColor){
        colors.add(0, newColor);
    }
    //4
    public String getColor(int index){
        return colors.get(index);
    }
    //5
    public void update(int pos, String newColor){
        colors.set(pos, newColor);
    }
    //6
    public void removeP3(){
        colors.remove(2);
    }
    //7
    public boolean search(String element){
        for(String color : colors){
            if(element.equals(color)){
                return true;
            }
        }
        return false;
    }
    //8 ?
    public void sort(){}
    //9 ?
    public static void copy(ArrayList original, ArrayList copy){
        copy = original;
    }
    //10 ?
    public void shuffle(){
        for(String color : colors){
            
        }
    }
    //11
    public void reverse(){
        int pos = 0;
        String holder;
        for(int i = colors.size()-1; i > 0; i--){
            holder = colors.get(i);
        }
    }
}
