import java.io.*;
public class TextFile {
    public static void toTxt(String press) throws IOException {
        File file = new File("logged_text.txt");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.print(press);

        if (press.equals("Space") || press.equals("Enter"))
            pw.append("\n");

        pw.close();
    }
}
