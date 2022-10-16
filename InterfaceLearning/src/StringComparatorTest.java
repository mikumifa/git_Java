import java.util.Arrays;

public class StringComparatorTest {
    public static void main(String[] args) {
        String[] arr=new String[]{"dasd sa","das dsa","aaaaaaaaaa","q"};
        Arrays.sort(arr,new LengthComparator());
        System.out.println(arr.toString());
    }
}
