package utils;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class ReadFile {

  public static ArrayList<String> Read() {

    ArrayList<String> dados = new ArrayList<String>();

    try {
      File myObj = new File("usuarios.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        dados.add(data);
      }
      myReader.close();

    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    return dados;

  }
}