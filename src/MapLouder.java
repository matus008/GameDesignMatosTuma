import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MapLouder {

    public boolean loud(){
        try(BufferedReader bf = new BufferedReader(new FileReader("src\\Map.txt"))) {
            String line;
            while((line  = bf.readLine()) != null){
                String[] lines = line.split(";");


            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
