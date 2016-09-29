import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by kurtmccann on 9/28/16.
 */
public class PhoneBookTest
{
    @Test
    public void lookUpTest()
    {
        PhoneBook pb1 = new PhoneBook();
        ArrayList<String> testList = new ArrayList<>();
        testList.add("(920) 227-8980");
        testList.add("(920) 435-3279");
        pb1.pb.put("Bernie Mac", testList);
        List<String> expected = testList;
        List<String> actual = pb1.lookUp("Bernie Mac");
        assertEquals(expected, actual);
    }
    @Test
    public void lookUpFailTest()
    {
        PhoneBook pb1 = new PhoneBook();
        ArrayList<String> testList = new ArrayList<>();
        testList.add("(920) 227-8980");
        testList.add("(920) 435-3279");
        pb1.pb.put("Zach Waterman", testList);
        List<String> actual = pb1.lookUp("Carl Sagan");
        assertNull(actual);
    }
    @Test
    public void addTest()
    {
        PhoneBook pb1 = new PhoneBook();
        ArrayList<String> testList = new ArrayList<>();
        testList.add("(920) 227-8980");
        testList.add("(920) 435-3279");
        pb1.add("Zach Waterman", testList);
        ArrayList expected = testList;
        List<String> actual = pb1.pb.get("Zach Waterman");
        assertEquals(expected, actual);
    }

    @Test
    public void removeTest()
    {
        PhoneBook pb1 = new PhoneBook();
        ArrayList<String> testList = new ArrayList<>();
        testList.add("(920) 227-8980");
        testList.add("(920) 435-3279");
        pb1.pb.put("Zach Waterman", testList);
        pb1.remove("Zach Waterman");
        List<String> actual = pb1.pb.get("Zach Waterman");
        assertNull(actual);
    }

    @Test
    public void removeFailTest()
    {
        PhoneBook pb1 = new PhoneBook();
        ArrayList<String> testList = new ArrayList<>();
        testList.add("(920) 227-8980");
        testList.add("(920) 435-3279");
        pb1.pb.put("Zach Waterman", testList);
        pb1.remove("Chuck Berry");
        int expected = 1;
        int actual = pb1.pb.size();
        assertEquals(actual, expected);
    }

    @Test
    public void listAllEntriesTest()
    {
        PhoneBook pb1 = new PhoneBook();

        ArrayList<String> testList1 = new ArrayList<>();
        testList1.add("(920) 227-8980");
        testList1.add("(920) 435-3279");
        pb1.pb.put("Zach Waterman", testList1);

        ArrayList<String> testList2 = new ArrayList<>();
        testList2.add("(608) 498-5622");
        pb1.pb.put("Don Cheadle", testList2);

        ArrayList<String> testList3 = new ArrayList<>();
        testList3.add("(999) 999-8980");
        testList3.add("(999) 435-9999");
        testList3.add("(920) 432-0117");
        pb1.pb.put("Timmy Niner", testList3);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("[Don Cheadle, (608) 498-5622]");
        expected.add("[Timmy Niner, (999) 999-8980, (999) 435-9999, (920) 432-0117]");
        expected.add("[Zach Waterman, (920) 227-8980, (920) 435-3279]");
        List<String> actual = pb1.listAllEntries();

        assertEquals(expected, actual);
    }

    @Test
    public void reverseLookUpTest()
    {
        PhoneBook pb1 = new PhoneBook();
        ArrayList<String> testList = new ArrayList<>();
        testList.add("(920) 227-8980");
        testList.add("(920) 435-3279");
        pb1.pb.put("Bernie Mac", testList);
        String expected = "Bernie Mac";
        String actual = pb1.reverseLookUp("(920) 227-8980");
        assertEquals(expected, actual);
    }

    @Test
    public void reverseLookUpFailTest()
    {
        PhoneBook pb1 = new PhoneBook();
        ArrayList<String> testList = new ArrayList<>();
        testList.add("(920) 227-8980");
        testList.add("(920) 435-3279");
        pb1.pb.put("(Bernie Mac", testList);
        String actual = pb1.reverseLookUp("Rob Dyrdek");
        String expected = "Number not found.";
        assertEquals(expected, actual);
    }
}
