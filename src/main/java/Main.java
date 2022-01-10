
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Baza[] base = {new Baza(), new Baza(), new Baza()};
        DriverBase[] base2 = {new DriverBase(), new DriverBase(), new DriverBase()};
        String data1 = new String(Files.readAllBytes(Path.of("Info.json")));
        String data2 = new String(Files.readAllBytes(Path.of("driver.json")));
        JSONArray json = new JSONArray(data1);
        JSONArray json2 = new JSONArray(data2);
        for (int i = 0; i < base.length; i++) {
            JSONObject js = json.getJSONObject(i);
            base[i].setId(js.getInt("id"));
            base[i].setDriver(js.getString("driver"));
            base[i].setName(js.getString("name"));
            base[i].setState(js.getString("state"));
        }
        for (int i = 0; i < base.length; i++) {
            JSONObject js = json2.getJSONObject(i);
            base2[i].setId(js.getInt("id"));
            base2[i].setName(js.getString("name"));
            base2[i].setBus("");
        }
        System.out.println();
        System.out.println("| ** | Bus           || Driver || State ||");
        System.out.println("+———+———————————————+————————+———————+");
        for (int i = 0; i < 3; i++) {
            System.out.printf("|%-3s", base[i].getId());
            System.out.printf("|%-15s", base[i].getName());
            System.out.printf("|%-8s", base[i].getDriver());
            System.out.printf("|%-6s", base[i].getState());
            System.out.println();
        }
        System.out.println("\n=============================");
        System.out.println("\n| ** ||Driver -id||Driver Name  ||  bus  ||");
        System.out.println("+———+—————+—————————+————————");
        for (int i = 0; i < 3; i++) {
            System.out.printf("|%-3s", base[i].getId());
            System.out.printf("|%-5s", "id " + base2[i].getId());
            System.out.printf("|%-9s", base2[i].getName());
            System.out.printf("|%-8s", base2[i].getBus());
            System.out.println();
        }
        System.out.println("chage a car");
        int a = scanner.nextInt();
        a--;
        while (true) {
            System.out.println(
                    "id        :      " + base[a].getId() +
                            "\nBus       :      " + base[a].getName() +
                            "\nDriver    :      " +
                            "\nState     :      " + base[a].getState());
            System.out.println("press 1 to change driver ");
            System.out.println("press 2 to send to the route ");
            System.out.println("press 3 to sent to the repairing ");
            break;
        }
        int b = scanner.nextInt();
        changeDriver(base,base2,a);
    }


    public static void changeDriver(Baza[] base ,DriverBase[] base2,int a){
        while (true) {
            System.out.println("-------------------------------");
            System.out.println("driver change ");
            System.out.println("");
            System.out.println("-------------Drivers-------------");
            for (int i = 0; i < base.length; i++) {
                System.out.printf("|%-3s", base2[i].getId());
                System.out.printf("|%-3s", base2[i].getId());
                System.out.printf("|%-15s", base2[i].getName());
                if (base[i].getName() == base[a].getName()) {
                    System.out.printf("|%-15s", base[a].getName());
                    System.out.println();
                }else {
                    System.out.println("");
                }
            }
            System.out.println();
            System.out.println("| ** || Bus           || Driver || State ||");
            System.out.println("+———+————————————+————————+———————+");
            for (int i = 0; i < 3; i++) {
                System.out.printf("|%-3s", base[i].getId());
                System.out.printf("|%-15s", base[i].getName());
                System.out.printf("|%-8s", base2[i].getName());
                System.out.printf("|%-6s", base[i].getState());
                System.out.println();
            }
            break;
        }
    }
}