
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
    
    
    public void merge(int[] list, int leftBound, int rightBound){
        int divide;
        // left < divide <= right
        // left inclusive, right exclusive
        int limit = leftBound + rightBound;
        int[] tempArray = new int[rightBound - leftBound];
        if(limit % 2 == 0){
            divide = limit / 2;
        }else{
            divide = (limit / 2) + 1;
        }
        int leftI = leftBound;
        int rightI = divide;
        for(int i = 0; i < tempArray.length; i++){
            System.out.println("Left: "+leftI+" Right: "+rightI);
            if(rightI == rightBound || list[leftI] <= list[rightI]){
                tempArray[i] = list[leftI];
                leftI++;
            }else if(leftI == divide || list[leftI] > list[rightI]){
                tempArray[i] = list[rightI];
                rightI++;
            }
        }
        SortingTest.display(tempArray);
        
        
    }
}
