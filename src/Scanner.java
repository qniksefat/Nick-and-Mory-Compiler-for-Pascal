
import java.io.*;

/**
 * This is the template of class 'scanner'. You should place your own 'scanner class here and
 * your scanner should match this interface.
 */
public class Scanner {
    public String CV;
    public int x = 0;
    int lineNumber = 1;

    Reader reader = new FileReader(Program.inputPath);
    Yylex yylex = new Yylex(reader);

    Scanner(String filename) throws Exception {
        File f = new File(filename);
        if (!f.exists())
            throw new Exception("File does not exist: " + f);
        if (!f.isFile())
            throw new Exception("Should not be a directory: " + f);
        if (!f.canRead())
            throw new Exception("Can not read input file: " + f);
        // ...
    }

    public String NextToken() throws Exception {
        String s = yylex.yylex();
        return s;
//        if(s.equals(Yylex.sym.err) | s.equals(Yylex.sym.EOF))   return Yylex.sym;
    }
//    public String NextToken() throws Exception {
//        if (this.x == 0) {
//            this.x = 1;
//            return "func";
//
//        } else  return "$";
//    }

}
