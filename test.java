import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.lang.reflect.Method;


public class test {

    lab2 l;

    @Before
    public void SetUp(){
        l = new lab2();
    }
    
    @Test
    public void emptyList(){
        int[] array = {};
        assert(l.search(array, 0) == -1);
    }
}
