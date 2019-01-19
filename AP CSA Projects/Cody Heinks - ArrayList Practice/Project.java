
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
    //9
    public static ArrayList copy(ArrayList original){
        ArrayList copy = new ArrayList();
        for(Object e : original){
            copy.add(e);
        }
        return copy;
    }
    //10 ?
    public void shuffle(){
        for(String color : colors){}
    }
    //11
    public void reverse(){
        int pos = 0;
        String holder;
        for(int i = colors.size()-1; i > -1; i--){
            holder = colors.get(colors.size()-1);
            colors.add(pos, holder);
            colors.remove(colors.size()-1);
            pos++;
        }
    }
    //12
    public ArrayList extract(int start, int end){ //(inclusive, exclusive)
        ArrayList extraction = new ArrayList();
        for(int i = start; i < end; i++){
            extraction.add(colors.get(i));
        }
        return extraction;
    }
    //13 ?
    public static boolean compare(ArrayList a, ArrayList b){
        if(a.size()>b.size()){
            for(int i = 0; i < b.size(); i++){
                if(!a.get(i).equals(b.get(i))){
                    return false;
                }
            }
        }else{
            for(int i = 0; i < a.size(); i++){
                if(!a.get(i).equals(b.get(i))){
                    return false;
                }
            }
        }
        return true;
    }
    //14
    public void swap(int a, int b){
        String holder = colors.get(a);
        colors.set(a, colors.get(b));
        colors.set(b, holder);
    }
    //15
    public static ArrayList join(ArrayList a, ArrayList b){
        ArrayList c = new ArrayList();
        for(Object e : a){
            c.add(e);
        }
        for(Object e : b){
            c.add(e);
        }
        return c;
    }
    //16
    public static void clone(ArrayList original, ArrayList clone){
        for(int i = 0; i < original.size(); i++){
            clone.set(i, original.get(i));
        }
    }
    //17
    public static void empty(ArrayList list){
        for(int i = list.size(); i > -1; i--){
            list.remove(i);
        }
    }
    //18
    public static boolean isEmpty(ArrayList list){
        return list.size() == 0;
    }
    //19 ?
    public void trim(){}
    //20 ?
    public void increaseSize(){}
    //21
    public void replaceSecond(int e){
        colors.set(1, colors.get(e));
    }
    //22
    public void printAll(){
        for(int i = 0; i < colors.size(); i++){
            System.out.println(colors.get(i));
        }
    }
}
