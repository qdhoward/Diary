package Fun.Amazon;

public class HeapSort {
    public void heapSort(int[] array) {
        //sanity check
        if (array == null || array.length == 0) return;
        int len = array.length;
// step 1. heapify : make it a max heap
        heapify(array);
        // step 2. for loop swap
        //for loop ,  poll 1 from top and push bush to the end( a pointer at the right end)
        for (int i = array.length - 1; i >=0 ; i--){
            //max heap, so make the i as the largest
            swap(array, 0, i);
            // we need to maintain the [0, len -1] part of the arr
            //after each swap, the len of the heap is decreased by 1
            percolateDown(array, 0, i);
        }
    }

    // make it the max heap: the last non-leaf root
    private void heapify(int[] array){
        int len = array.length;
        //from the last root index percolate down
        for(int i = len / 2 - 1; i >= 0; i--){     //  -1 /  2 = 0 ,  len/2 - 1
            percolateDown(array, i, len);
        }
    }


    // maxHeap: index increasing: index is the root
    private void percolateDown(int[] array, int index, int len){
        while (index <= (len - 2)/2) {
            int left = index * 2 + 1;
            int right = index * 2+ 2;
            int max = index;
            if(left < len && array[left] > array[max]){
                max = left;
            }
            if(right < len && array[right] > array[max]){
                max = right;
            }
// no need to do anything
            if(max == index){
                break;
            }
            swap(array, index, max);
            index = max;
        }
    }

    private void swap(int[] array, int a, int b) {

    }

}
