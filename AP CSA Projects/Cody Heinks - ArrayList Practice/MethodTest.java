
/**
 * Write a description of class MethodTest here.
 *
 * @author Cody Heinks
 * @version 2.1.19
 */
import java.util.ArrayList;
import java.lang.Math;
public class MethodTest{
    public static void test1(){
        Project p = new Project();
        System.out.println(p.colors);
    }
    
    public static void test2(){
        Project p = new Project();
        p.display();
    }
    
    public static void test3(){
        Project p = new Project();
        System.out.println(p.colors);
        p.addPos1("Magenta");
        System.out.println(p.colors);
    }
    
    public static void test4(){
        Project p = new Project();
        System.out.println(p.colors);
        System.out.println("3");
        System.out.println(p.getColor(3));
    }
    
    public static void test5(){
        Project p = new Project();
        System.out.println(p.colors);
        System.out.println("6, Purple");
        p.update(6, "Purple");
        System.out.println(p.colors);
    }
    
    public static void test6(){
        Project p = new Project();
        System.out.println(p.colors);
        p.removeP3();
        System.out.println(p.colors);
    }
    
    public static void test7(){
        Project p = new Project();
        System.out.println(p.colors);
        System.out.println("Indigo");
        System.out.print(p.search("Indigo"));
    }
    
    public static void test8(){
        Project p = new Project();
        ArrayList<Integer> numbers = new ArrayList();
        for(int i = 10; i > 0; i--){
            numbers.add(new Integer((int)(Math.random()*10)));
        }
        System.out.println(numbers);
        System.out.println(p.sort(numbers));
    }
    
    public static void test9(){
        Project p = new Project();
        System.out.println(p.colors);
        System.out.println(p.copy(p.colors));
    }
    
    public static void test10(){
        Project p = new Project();
        System.out.println(p.colors);
        System.out.println(p.shuffle(p.colors));
    }
    
    public static void test11(){
        Project p = new Project();
        System.out.println(p.colors);
        p.reverse();
        System.out.println(p.colors);
    }
    
    public static void test12(){
        Project p = new Project();
        System.out.println(p.colors);
        System.out.println("1 - 4");
        System.out.println(p.extract(1, 4));
    }
    
    public static void test13(){
        Project p = new Project();
        ArrayList<Integer> numbers1 = new ArrayList();
        for(int i = 3; i > 0; i--){
            numbers1.add(new Integer((int)(Math.random()*10)));
        }
        ArrayList<Integer> numbers2 = new ArrayList();
        for(int i = 3; i > 0; i--){
            numbers2.add(new Integer((int)(Math.random()*10)));
        }
        System.out.println(numbers1);
        System.out.println(numbers2);
        System.out.println(p.compare(numbers1, numbers2));
    }
    
    public static void test14(){
        Project p = new Project();
        System.out.println(p.colors);
        System.out.println("Swap 3 and 6");
        p.swap(3, 6);
        System.out.println(p.colors);
    }
    
    public static void test15(){
        Project p = new Project();
        ArrayList<Integer> numbers1 = new ArrayList();
        for(int i = 5; i > 0; i--){
            numbers1.add(new Integer((int)(Math.random()*10)));
        }
        ArrayList<Integer> numbers2 = new ArrayList();
        for(int i = 5; i > 0; i--){
            numbers2.add(new Integer((int)(Math.random()*10)));
        }
        System.out.println(numbers1);
        System.out.println(numbers2);
        System.out.println(p.join(numbers1, numbers2));
    }
    
    public static void test16(){
        Project p = new Project();
        ArrayList l = new ArrayList();
        System.out.println(p.colors);
        l = p.clone(p.colors);
        System.out.println(l);
    }
    
    public static void test17(){
        Project p = new Project();
        System.out.println(p.colors);
        p.empty(p.colors);
        System.out.println(p.colors);
    }
    
    public static void test18(){
        Project p = new Project();
        System.out.println(p.colors);
        System.out.println(p.isEmpty(p.colors));
    }
    
    public static void test19(){
        Project p = new Project();
        System.out.println(p.colors);
        p.trim(p.colors);
        System.out.println(p.colors);
    }
    
    public static void test20(){
        Project p = new Project();
        System.out.println(p.colors);
        System.out.println(p.colors.size());
        p.increaseSize(p.colors, 5);
        System.out.println(p.colors);
        System.out.println(p.colors.size());
    }
    
    public static void test21(){
        Project p = new Project();
        System.out.println(p.colors);
        System.out.println("Replace with index 4");
        p.replaceSecond(4);
        System.out.println(p.colors);
    }
    
    public static void test22(){
        Project p = new Project();
        System.out.println(p.colors);
        p.printAll();
    }

    public static void main(String[] args){
        
    }
}
