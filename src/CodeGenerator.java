import java.io.PrintStream;
import java.util.HashMap;
import java.util.Stack;

public class CodeGenerator {
    Scanner scanner; // This was my way of informing CG about Constant Values detected by Scanner, you can do whatever you like

    // Define any variables needed for code generation
    HashMap<String, String> symbolTable = new HashMap<>();
    // hashes two strings and you can push them!
    Stack<String> semanticStack = new Stack<>();

    public CodeGenerator(Scanner scanner) {
        this.scanner = scanner;
    }

    public void Generate(String sem) {
        System.out.println(sem); // Just for debug

        switch (sem) {
            case "@push_func": {
                System.out.println("hey!!!!!");
                return;
            }
//            break;
            case "NoSem": {
                return;
            }
        }
//        break;

        /*
         * else if (sem.equals("SemanticRoutine1"))
         * {
         * 	...
         * }
         * else if (sem.equals("SemanticRoutine2"))
         * {
         * 	...
         * }
         */
    }

    public void FinishCode() // You may need this
    {

    }

    public void WriteOutput(String outputName) {
        // Can be used to print the generated code to output
        // I used this because in the process of compiling, I stored the generated code in a structure
        // If you want, you can output a code line just when it is generated (strongly NOT recommended!!)
    }
}
