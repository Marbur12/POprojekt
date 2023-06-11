/*import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InputOutputTest {
    @Test
    public void shouldTakeUserInput() {
        InputOutput inputOutput= new InputOutput();

        String input = "add 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("add 5", inputOutput.getInput());
    }
    @Test
    public void mainTest(){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("3\n4\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        UserInputExample.main(new String[0]);

        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "output:";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();
        assertEquals(output, "7");
    }

}
*/
