package b12.Java_Collection_Framework.bai_tap.Framework;
import java.util.Comparator;

public class SortProductByPrice implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice()>o2.getPrice()){
            return 1;
        }
        return -1;
    }
}
