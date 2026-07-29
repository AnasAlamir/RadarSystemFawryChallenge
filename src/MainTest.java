import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testMainOutput() {
        // Capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Run your main method
            Main.main(new String[]{});

            // Expected output
            String expectedOutput = """
                    No Fines yet
                    Traffic fine for car ABC1234
                    Total amount: 400
                    Violations:
                    - speed of 94 exceeded max allowed 80 : 300 EGP
                    - Seatbelt not fastened : 100 EGP
                    Traffic fine for car CCC3344
                    Total amount: 500
                    Violations:
                    - speed of 65 exceeded max allowed 60 : 500 EGP
                    Traffic fine for car DEF4455
                    Total amount: 100
                    Violations:
                    - Seatbelt not fastened : 100 EGP
                    ==========================
                    getAllFines
                    GetFineDto{plateNumber='ABC1234', totalViolationsAmount=400}
                    GetFineDto{plateNumber='CCC3344', totalViolationsAmount=500}
                    GetFineDto{plateNumber='DEF4455', totalViolationsAmount=100}
                    ==========================
                    getAllViolationsCounts
                    {Truck Speed=1, Seat Belt=2, Private Car Speed=1}
                    """;

            // Normalize line endings (\r\n vs \n)
            String actualOutput = outContent.toString().replace("\r\n", "\n").trim();
            expectedOutput = expectedOutput.replace("\r\n", "\n").trim();

            assertEquals(expectedOutput, actualOutput);

        } finally {
            // Restore console output
            System.setOut(originalOut);
        }
    }
}