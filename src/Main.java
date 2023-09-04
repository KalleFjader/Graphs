import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class Main{
    public static void main(String[] args) throws Cyclefound, IOException {
        System.out.println("Choose: Graph1, Graph2, Names, Cities");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice = reader.readLine();
        if(Objects.equals(choice, "Graph1")){
            GraphChoice.Graph1();
        }else if(Objects.equals(choice, "Graph2")){
            GraphChoice.Graph2();
        }else if(Objects.equals(choice, "Names")){
            GraphChoice.Names();
        }else if(choice == "Cities"){
            GraphChoice.Cities();
        }

    }
}

