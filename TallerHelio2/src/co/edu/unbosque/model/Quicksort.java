package co.edu.unbosque.model;
import java.util.Stack;

public class Quicksort {

    private int x;
    private int y;

    Quicksort(){

    }

    Quicksort(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }


    public void setY(int y) {
        this.y = y;
    }

    public void swap (long[] arr, int i, int j){
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int partition(long a[], int start, int end){
        long pivot = a[end];
        int pIndex = start;

        for (int i = start; i < end; i++){
            if (a[i] <= pivot)
            {
                swap(a, i, pIndex);
                pIndex++;
            }
        }

        swap (a, pIndex, end);
        return pIndex;
    }

    public long[] iterativeQuicksort(long[] a){

        Stack<Quicksort> stack = new Stack<>();

        int start = 0;
        int end = a.length - 1;

        stack.push(new Quicksort(start, end));

        while (!stack.empty())
        {
            start = stack.peek().getX();
            end = stack.peek().getY();
            stack.pop();
            int pivot = partition(a, start, end);

            if (pivot - 1 > start) {
                stack.push(new Quicksort(start, pivot - 1));
            }

            if (pivot + 1 < end) {
                stack.push(new Quicksort(pivot + 1, end));
            }
            System.out.println();
        }
        return a;
    }

}