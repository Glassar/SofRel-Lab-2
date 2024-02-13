import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;  
import java.io.IOException;


public class test {


    static void randomTests(int numTests, int arrayLength, int intRange) throws IOException{

        FileWriter fw = new FileWriter("random_test_cases500.txt"); 
        Random rand = new Random();
        
        
        for (int index = 0; index < numTests; index++) {
            int tmp[] = new int[arrayLength];
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = rand.nextInt(intRange);
            }
            fw.write(Arrays.toString(tmp) + "\n");
            fw.write(rand.nextInt(intRange) + "\n");
            
        }
        fw.close(); 
    }

    static void pairwiseTests(int arrayLength, int defaultValue, int[] keys) throws IOException {
        FileWriter fw = new FileWriter("pair_wise_test_cases500.txt"); 

        int tmp[] = new int[arrayLength];

        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = defaultValue;
        }

        for (int j = 0; j < tmp.length; j++) {
            tmp[j]  = arrayLength-j;
            for (int i = j+1; i < tmp.length+1; i++) {
                if(i == arrayLength){
                    for (int k = 1; k < keys.length; k++) {
                        fw.write(Arrays.toString(tmp) + "\n");
                        fw.write(keys[k] + "\n");
                    }
                } else 
                {
                    tmp[i] = arrayLength-i;
                    fw.write(Arrays.toString(tmp) + "\n");
                    fw.write(keys[0] + "\n");
                    tmp[i] = defaultValue;
                }
            }
            tmp[j]  = defaultValue;
        }
        fw.close(); 
    }

    public static void main(String[] args) throws IOException {
        randomTests(100, 500, 500);
        pairwiseTests(500, 0, new int[]{1, 0, 10, 500});
    }
}
