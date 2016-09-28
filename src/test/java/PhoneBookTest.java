import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Created by kurtmccann on 9/28/16.
 */
public class PhoneBookTest
{
    @Test
    public void lookUpTest()
    {
        PhoneBook pb1 = new PhoneBook();
        pb1.pb.put("Bernie Mac", "(999) 999-9999");
        String expected = "(999) 999-9999";
        String actual = (String) pb1.lookUp("Bernie Mac");
        assertEquals(expected, actual);
    }
    @Test
    public void lookUpFailTest()
    {
        PhoneBook pb1 = new PhoneBook();
        String actual = pb1.lookUp("Carl Sagan");
        assertNull(actual);
    }
    @Test
    public void addTest()
    {
        PhoneBook pb1 = new PhoneBook();
        pb1.add("Zach Waterman", "(414) 867-5309");
        String expected = "(414) 867-5309";
        String actual = pb1.pb.get("Zach Waterman");
        assertEquals(expected, actual);
    }

//    @Test
//    public void addFailTest()
//    {
//        PhoneBook pb1 = new PhoneBook();
//        pb1.add("Zach Waterman", "(414) 867-5309");
//        String actual = (String) pb1.pb.get("Chuck Berry");
//        assertNull(actual);
//    }

    @Test
    public void removeTest()
    {
        PhoneBook pb1 = new PhoneBook();
        pb1.pb.put("Zach Waterman", "(414) 867-5309");
        pb1.remove("Zach Waterman");
        String actual = pb1.pb.get("Zach Waterman");
        assertNull(actual);
    }

    @Test
    public void removeFailTest()
    {
        PhoneBook pb1 = new PhoneBook();
        pb1.pb.put("Zach Waterman","(414) 867-5309");
        pb1.remove("Chuck Berry");
        int expected = 1;
        int actual = pb1.pb.size();
        assertEquals(actual, expected);
    }

    @Test
    public void reverseLookUpTest()
    {
        PhoneBook pb1 = new PhoneBook();
        pb1.pb.put("Bernie Mac", "(999) 999-9999");
        String expected = "Bernie Mac";
        String actual = pb1.reverseLookUp("(999) 999-9999");
        assertEquals(expected, actual);
    }

    @Test
    public void reverseLookUpFailTest()
    {
        PhoneBook pb1 = new PhoneBook();
        pb1.pb.put("Bernie Mac", "(999) 999-9999");
        String actual = pb1.reverseLookUp("Rob Dyrdek");
        String expected = "Number not found.";
        assertEquals(expected, actual);
    }
}
