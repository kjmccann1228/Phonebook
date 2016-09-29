import java.util.*;
import java.util.Map.*;

/**
 * Created by kurtmccann on 9/28/16.
 */
public class PhoneBook
{
    protected Map<String, List<String>> pb = new TreeMap<>();

    public void add(String name, List<String> numbers)
    {
        this.pb.put(name, numbers);
    }

    public List<String> lookUp(String name)
    {
        return pb.get(name);
    }

    public void remove(String name)
    {
        this.pb.remove(name);
    }

    public List<String> listAllEntries()
    {
        List<String> entryList = new ArrayList<>();
        for(String name : this.pb.keySet())
        {
            List<String> nextEntry = new ArrayList<>();
            nextEntry.add(name);
            nextEntry.addAll(1, pb.get(name));
            entryList.add(nextEntry.toString());
        }
        return entryList;
    }

    public String reverseLookUp(String number)
    {
        String toReturn = "Number not found.";
        for(Entry<String, List<String>> e : pb.entrySet())
        {
            for(String s : e.getValue())
            {
                if(s.equals(number))
                {
                    return e.getKey();
                }
            }
        }
        return toReturn;
    }
}
