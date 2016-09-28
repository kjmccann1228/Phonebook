import java.util.Map;
import java.util.HashMap;
/**
 * Created by kurtmccann on 9/28/16.
 */
public class PhoneBook
{
    protected Map<String, String> pb = new HashMap<>();

    public void add(String name, String number)
    {
        this.pb.put(name, number);
    }

    public String lookUp(String name)
    {
        return pb.get(name);
    }

    public void remove(String name)
    {
        this.pb.remove(name);
    }
}
