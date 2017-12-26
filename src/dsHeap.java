import java.util.Arrays;
import java.util.ArrayList;

public class dsHeap {

    ArrayList<Integer> heap;

    public dsHeap(){
        this.heap = new ArrayList<>();
    }

    // (i / 2) - Parent
    // (2 * i) + 1 - Left child
    // (2 * i) + 2 - Right child

    private void siftDown(){
        // Assumption that last element has already been moved to the root, so just find the right place for it.
        int k = 0;
        int l = (2 * k) + 1;

        // Always check left, due to BFS insert the left node has to always exist.
        while(l < heap.size()){
            int max = l;
            int r = l + 1;

            if(r < heap.size() && heap.get(r) > heap.get(max)){
                max = r;
            }

            // Next swap the root with max if required.
            if(heap.get(k) < heap.get(max)){
                int temp = heap.get(k);
                heap.set(k, heap.get(max));
                heap.set(max, temp);
                k = max;
                l = (2 * k) + 1;
            } else {
                break;
            }
        }
    }

    private void siftUp(){
        int k = heap.size() - 1;

        while(k > 0){
            int par = (k - 1)/2;
            if(heap.get(par) < heap.get(k)){
                int temp = heap.get(k);
                heap.set(k, heap.get(par));
                heap.set(par, temp);

                k = par;
            } else {
                break;
            }
        }
    }

    public void insert(int toAdd){

        heap.add(toAdd);
        siftUp();
    }

    public int delete(){

        if(heap.size() == 0){
            return -1;
        }

        if(heap.size() == 1){
            return heap.remove(0);
        }

        int hold = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        siftDown();

        return hold;
    }

    public String toString() {
        return heap.toString();
    }

    public static void main(String[] args){

        int[] arr = {1, 6, 8, 2, 3, 5, 4};

        dsHeap list = new dsHeap();

        for(int i : arr){
            list.insert(i);
            //System.out.println(i + " : " + list.toString());
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(list.delete() + " ");
        }
    }
}
