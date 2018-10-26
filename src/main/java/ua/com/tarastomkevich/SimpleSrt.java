package ua.com.tarastomkevich;

import java.io.*;
import static ua.com.tarastomkevich.GuiSrt.newNameFile;

public class SimpleSrt {
    public static String pathFileSrt;
    public static String strTemp;
    public static File fileSrt;

    public static void extractSrt() {
        int countStr = 0;
        fileSrt = new File(newNameFile);
        try (InputStream inputStream = new FileInputStream(pathFileSrt);
             OutputStream outputStream = new FileOutputStream(fileSrt)){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            System.out.println(fileSrt.getCanonicalPath());
            while (true) {
                    if((strTemp = bufferedReader.readLine())!= null){
                            if (!strTemp.isEmpty()&&(countStr++%3==2)) {
                                int c;
                                while (true){
                                    for (int i = 0; i < strTemp.length(); i++) {
                                        c = strTemp.charAt(i);
                                        bufferedWriter.write((char)c);
                                    }
                                    bufferedWriter.newLine();
                                    bufferedWriter.flush();
                                    break;
                                }
                            }
                    }else break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File opening failed");
            e.printStackTrace();
        }
    }
}


