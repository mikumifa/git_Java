
import java.util.Comparator;

class LengthComparator implements Comparator<String> {
    public int compare(String a,String b){
        return Integer.compare(a.length(),b.length());
    }
}
