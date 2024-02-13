import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*; 

/**
 * lab2
 */


public class lab2copy {

    public static void sort (int array[])
    {
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

    public static boolean binarySearch (int array[], int key){

        int x = -1;
        int l = 0;
        int r = array.length-1;

        do {
            x = (l+r)/2;
            if(key<array[x]){
                r = x-1;
            } else {
                l = x+1;
            }
        } while (!(key == array[x]) && !(l > r));

        if(key == array[x]){
            return true;
        } else {
            return false;
        }
    }

    public static boolean search (int array[], int key){
        int temp[] = array.clone();
        sort(temp);
        return binarySearch(temp, key);
    }

    public static void runTests(String path, int numTests) throws IOException 
    {
        File fp = new File(path);
        FileReader fr = new FileReader(fp); 
        BufferedReader br = new BufferedReader(fr);
        int counter_tests = 0; 
        
        
        for (int i = 0; i < numTests; i++) {
            String line = br.readLine();
            line = line.substring(1, line.length()-1);
            int tmp[] = Arrays.stream(line.split(", ")).mapToInt(Integer::parseInt).toArray();

            int key = Integer.parseInt(br.readLine());
            
            boolean search = search(tmp, key);
            
            boolean contains = false;
            for (int j = 0; j < tmp.length; j++) {
                if(tmp[j] == key){
                    contains = true;
                    break;
                }
            }
            
            if (search == contains) {
                counter_tests +=1;
            } else {
                System.out.println("Test # " + i + " failed. With key: " + key +" and array:" );
                System.out.println(Arrays.toString(tmp));
                System.out.println("Expected: " + contains + " but got: " + search +"\n");
            }

        }
        fr.close();

        System.out.println("Passed " + counter_tests + " of " + numTests);
    }

    public static void main(String[] args) throws IOException 
    {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Running pair-wise tests...");
            runTests("pair_wise_test_cases.txt", 10*i);

            System.out.println("\nRunning random tests...");
            runTests("random_test_cases.txt", 10*i);
            System.out.println("\n");
        }
    }
    
}