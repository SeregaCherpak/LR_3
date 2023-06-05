package abs.servlet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;

public class New {
    private static String pathStr = "C:\\Users\\Сергей\\Desktop\\Институт\\4\\LR2\\src\\main\\webapp\\car.json";
    private static  Path path = Paths.get(pathStr);
    public static void writeToFile(Car res) throws IOException {
        String CarString = "";
        CarString += res.getMark() + ";";
        CarString += res.getModel() + ";";
        CarString += res.getPrice() + ";";
        CarString += res.getYear() + ";";
        CarString += res.getEngine_capacity() + "\n";
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        Files.write(path, CarString.getBytes(), StandardOpenOption.APPEND);
    }
    public static ArrayList<Car> readSeriesFromFile() throws IOException {
        if (Files.exists(path)) {
            BufferedReader reader = new BufferedReader(new FileReader(pathStr));
            String data = reader.readLine();
            ArrayList<Car> car = new ArrayList<>();
            while (data != null) {
                String[] parameters = data.split(";");
                Car tempcar = new Car(parameters[0], parameters[1], parameters[2], parameters[3],parameters[4]);
                car.add(tempcar);
                data = reader.readLine();
            }
            reader.close();
            return car;
        }
        return null;
    }
}
