
/**
 * lab2
 */
public class lab2 {

    public void sort (int array[])
    {
        System.out.println("tet");
        for (int i = 0; i < array.length -1; i++) {
            if (array[i] > array[i+1]) {
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                for (int j = i; j > 0; j--) {
                    if (array[j] < array[j-1]) {
                        int temp2 = array[j];
                        array[j] = array[j-1];
                        array[j-1] = temp2;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
    }

    public int binarySearch (int array[], int key){

        int x = -1;
        int l = 1;
        int r = array.length;

        do {
            x = (l+r)/2;
            if(key<array[x]){
                r = x-1;
            } else {
                l = x+1;
            }
        } while (!(key == array[x]) || !(l > r));

        if(key == array[x]){
            return x;
        } else {
            return -1;
        }
    }

    public int search (int array[], int key){
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
        return binarySearch(array, key);
    }



    public static void main(String[] args) {

    }
}