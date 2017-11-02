/*
 * Copyright (c) 2017. Schoultz Consulting, Sweden.
 */

package nu.schoultz.story1;

import java.io.*;

class ExpStory {

    private String line;
    private String json;


    String initiate(String filename) {

        InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream(filename);

        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(systemResourceAsStream, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        try {
            StringBuilder sb = new StringBuilder();
            line = null;
            line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }

            br.close();
            json = sb.toString().replace('\uFEFF', ' ');
        } catch (IOException e) {
            throw new GameException("Unknown problem", e);

        }

        return json;
    }
}
