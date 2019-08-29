
/**
 * Write a description of class Sorter here.
 *
 * @author Cody Heinks
 * @version 2.21.19
 */
public class Sorter{
    public Sorter(){}

    public int[] bubble(int[] list){
        int middleMan;
        for(int lastSortedIndex = list.length - 1; lastSortedIndex > 0; lastSortedIndex--){
            for(int currentIndex = 0; currentIndex < lastSortedIndex; currentIndex++){
                if(list[currentIndex] > list[currentIndex + 1]){
                    middleMan = list[currentIndex];
                    list[currentIndex] = list[currentIndex + 1];
                    list[currentIndex + 1] = middleMan;
                }
            }
        }
        return list;
    }

    public int[] insertion(int[] list){
        int middleMan;
        int pointer;
        int toBeSorted;
        for(int split = 1; split < list.length; split++){
            pointer = split - 1;
            toBeSorted = list[split];
            while(pointer >= 0 && toBeSorted < list[pointer]){
                middleMan = list[pointer];
                list[pointer] = toBeSorted;
                list[pointer + 1] = middleMan;
                pointer--;
            }
        }
        return list;
    }

    public int[] selection(int[] list){
        int middleMan;
        for(int nextSlot = 0; nextSlot < list.length; nextSlot++){
            int lowestIndex = nextSlot;
            for(int i = nextSlot; i < list.length; i++){
                if(list[i] < list[lowestIndex]){
                    lowestIndex = i;
                }
            }
            middleMan = list[nextSlot];
            list[nextSlot] = list[lowestIndex];
            list[lowestIndex] = middleMan;
        }
        return list;
    }

    public int[] merge(int[] list){
        int divide;
        int[] left; int leftI;
        int[] right; int rightI;
        if(list.length % 2 == 0){
            divide = list.length / 2;
            left = new int[divide];
            right = new int[divide];
        }else{
            divide = 1 + list.length / 2;
            left = new int[divide];
            right = new int[divide - 1];
        }
        for(int i = 0; i < list.length; i++){
            if(i < divide){
                left[i] = list[i];
            }else{
                right[i - divide] = list[i];
            }
        }
        if(list.length > 1){
            left = merge(left);
            right = merge(right);
        }
        leftI = 0;
        rightI = 0;
        for(int i = 0; i < list.length; i++){
            if(rightI == right.length || leftI < left.length && left[leftI] <= right[rightI]){
                list[i] = left[leftI];
                leftI++;
            }else if(leftI == left.length || rightI < right.length && right[rightI] < left[leftI]){
                list[i] = right[rightI];
                rightI++;
            }
        }
        return list;
    }
}
