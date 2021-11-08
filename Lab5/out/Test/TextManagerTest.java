import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class TextManagerTest {
    @Test
    public void testEmptyInput() throws IOException {
        String text="";
        String result = TextManager.Replace(text);
        Assert.assertTrue(result.isEmpty());
    }
    @Test
    public void testInputWithNoToReplace() throws IOException {
        String text="Lorem ipsum dolor sit amet, consectetuer adipiscing elit.";
        String result = TextManager.Replace(text);
        Assert.assertEquals("Lorem ipsum dolor sit amet, consectetuer adipiscing elit.",result);
    }
    @Test
    public void testInputWithMatch() throws IOException {
        String text="Lorem ipsum dolor sit in amet, consectetuer the adipiscing elit.";
        String result = TextManager.Replace(text);
        Assert.assertEquals("Lorem ipsum dolor sit amet, consectetuer adipiscing elit.",result);
    }
}