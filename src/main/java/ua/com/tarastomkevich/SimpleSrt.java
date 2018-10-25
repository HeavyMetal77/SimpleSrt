package ua.com.tarastomkevich;

import java.io.*;

public class SimpleSrt {
    public static String pathFileSrt;

    public static void extractSrt() {
        int countStr = 0;
        try (InputStream inputStream = new FileInputStream(pathFileSrt)){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String strTemp;
                    if((strTemp = bufferedReader.readLine())!= null){
                            if (!strTemp.isEmpty()&&(countStr++%3==2)) {
                                System.out.println(strTemp);
                            }
                    }else break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(pathFileSrt);
        } catch (IOException e) {
            System.out.println("File opening failed");
            e.printStackTrace();
        }
    }
}


