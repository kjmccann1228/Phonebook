import java.util.Map.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
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

    public String reverseLookUp(String number)
    {
        String toReturn = "Number not found.";
        for(Entry<String, String> e : pb.entrySet())
        {
            if(number.equals(e.getValue()))
            {
                toReturn = e.getKey();
            }

        }
        return toReturn;
    }
}
