import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[]args) throws IOException {
        // read in string

        String date = new String(Files.readAllBytes(Paths.get("info.json")));

        // read as json array

        JSONArray jsonArray = new JSONArray(date);
    Baza [] bazas = new Baza[jsonArray.length()];
        System.out.println("#  |    Bus          |  Driver  |  State ");
        System.out.println("———+—————————————————+——————————+—————————");

        for (int i =0; i< jsonArray.length();i++){
            bazas[i]= new Baza();
            String str = jsonArray.get(i).toString();
            JSONObject object = new JSONObject(str);
            bazas[i].setId(object.getInt("id"));
            bazas[i].setName(object.getString("name"));
            bazas[i].setDriver(object.getString("driver"));
            bazas[i].setState(object.getString("state"));

        }
        for (int i = 0; i < 3; i++) {
            System.out.println();
            System.out.print(bazas[i].getId()+"  |");
            System.out.printf("%18s",bazas[i].getName()+"   |");
            System.out.printf("%15s",bazas[i].getDriver()+"  | On");
            System.out.printf("%5s",bazas[i].getState());
        }

    }
}
