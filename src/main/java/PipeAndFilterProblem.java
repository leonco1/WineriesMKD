import model.Pipe;
import service.impl.AddressFilter;
import service.impl.NameToUpper;
import service.impl.RemoveLocation;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class PipeAndFilterProblem {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        InputStream inputStream = PipeAndFilterProblem.class.getResourceAsStream("Vinarii_Makedonija.csv");
        InputStreamReader reader = new InputStreamReader(inputStream);
        Scanner scanner = new Scanner(reader);

        Pipe<String> pipe = new Pipe<>();
        NameToUpper nameToUpper = new NameToUpper();
        AddressFilter addressFilter = new AddressFilter();
        RemoveLocation removeLocation = new RemoveLocation();
        pipe.addFilter(nameToUpper);
        pipe.addFilter(addressFilter);
        pipe.addFilter(removeLocation);

        System.out.println("Winery Name,Address,Distance,Activities");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String filteredLine = pipe.runFilters(line);
            if(!Objects.equals(filteredLine, ""))
                System.out.println(filteredLine);
        }
        scanner.close();
    }
}
