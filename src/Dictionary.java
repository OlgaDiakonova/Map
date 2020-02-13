
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    Map<String, String> pair;

    public Dictionary() {
        pair = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "pair=" + pair +
                '}';
    }
}
