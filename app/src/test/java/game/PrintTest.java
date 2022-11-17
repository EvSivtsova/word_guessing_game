package game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrintTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Print print;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        print = new Print();
    }

    @Test
    public void testAsksToInputPlayerNumber1() {
        print.askToInputPlayerNumber();
        Assert.assertEquals("\nPlease enter the number of players: 1 or 2\n", outContent.toString());
    }

    @Test
    public void testAsksToInputPlayerName_OnePlayerGame() {
        print.askToEnterNameForOnePlayer();
        Assert.assertEquals("\nPlease enter your name:\n", outContent.toString());
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
}
