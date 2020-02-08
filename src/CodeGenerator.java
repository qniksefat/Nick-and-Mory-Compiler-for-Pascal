import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class CodeGenerator {
    Scanner scanner; // This was my way of informing CG about Constant Values detected by Scanner, you can do whatever you like

    HashMap<String, String> funcRetType = new HashMap<>();
    int lastVarNum = 1;
    int lastFuncNum = 1;
    HashMap<String, String> llvmType = new HashMap<>();
    Stack<String> ss = new Stack<>();
    String code;
    ArrayList<String> CODE = new ArrayList<>();
    // Define any variables needed for code generation
    HashMap<String, String> symbolTable = new HashMap<>();
    // hashes two strings and you can push them!
    Stack<String> semanticStack = new Stack<>();

    public CodeGenerator(Scanner scanner) {
        this.scanner = scanner;

        llvmType.put("integer", "i32");
        llvmType.put("char", "i8");
        llvmType.put("boolean", "i1");
        llvmType.put("real", "double");
        llvmType.put("string", "i8*");
    }

    public void Generate(String sem) {
        System.out.println(sem); // Just for debug
        switch (sem) {
//            System.out.println(CODE.get(0));
            case "@@push_func_name": {
                code = "@" + scanner.STP();
                System.out.println(scanner.STP());
                System.out.println(code);
                ss.push(scanner.STP());
                break;
            }
            case "@@func_lparen": {
                code += "(";
                ss.push("$");
                break;
            }
            case "@@func_rparen": {
                HashMap<String, Integer> arg = new HashMap<>();
                while (true) {
                    String temp = ss.peek();
                    if (!temp.equals("$")) {
                        arg.put(ss.pop(), lastVarNum);
                        lastVarNum++;
                    } else {
                        System.out.println("falgahfhalhfalhglahlf");
                        ss.pop();
                        break;
                    }
                    code += llvmType.get(ss.pop());

                }
                break;
            }
            case "@@func_ret_type": {
                String ret = scanner.STP();
                ss.push(ret);
                System.out.println("a;jfahf " + ret);
                code = "define " + llvmType.get(ret) + code;
                CODE.add(code);
                break;
            }
            case "@@begin": {
                CODE.add("{");
            }
            break;
            case "@@end": {
                CODE.add("}");
                System.out.println("===============" + code);
            }
            break;
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
