/**
 * Created by Trevor on 7/28/2016.
 */

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Member {
    private ArrayList<String> names;
    public Member() {
        names = new ArrayList<String>();
    }

    public boolean writeJson() {
        URL oracle = null;
        try {
            oracle = new URL("https://us.api.battle.net/wow/guild/Sentinels/Ageless?fields=members&locale=en_US&apikey=ccp72vdm8uf8pckf3ub57jcxyj7ggn4p");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));

            PrintWriter out = new PrintWriter("guild.json");

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                out.print(inputLine);
            in.close();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void update() {
        writeJson();
        setNames();
    }

    public void setNames() {
        String s;
        try {
            BufferedReader br = new BufferedReader(new FileReader("guild.json"));
            s = br.readLine();
            while(s.contains("character" + '"' +":{" + '"' + "name" + '"' + ":" + '"')) {
                int start = s.indexOf("character" + '"' + ":{" + '"' + "name" + '"' + ":" + '"') + 20;
                int end = s.indexOf('"', start);
                names.add(s.substring(start, end).toLowerCase());
                //System.out.println("hi");
                s = s.substring(end);
            }
           /* for(int x = 0; x < names.size(); x ++) {
                System.out.println(names.get(x));

            } **/
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getNames() {
        return names;
    }
}
