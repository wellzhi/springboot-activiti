package com.dapeng.flow;

import java.io.*;

public class RuntimeTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("mvn -v");
        printMessage(process.getInputStream());
        int value = process.waitFor();
        System.out.println(value);

    }

    private static void printMessage(final InputStream input) {
        new Thread(new Runnable() {
            public void run() {
                Reader reader = new InputStreamReader(input);
                BufferedReader bf = new BufferedReader(reader);
                String line = null;
                try {
                    while ((line = bf.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
