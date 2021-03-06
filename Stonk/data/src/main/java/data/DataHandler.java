package data;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Class datahandler.
 */
public class DataHandler {

  // The filepath now dynamiclly finds the working directory of the user, and the
  // adds the path to the database
  private String file = System.getProperty("user.dir");

  // When running with "javafx:run", the working directory will be "ui".
  // This method removes the path into "ui", so the path finds the file in "data"
  private void adaptFilePath() {
    file = file.substring(0, file.indexOf("gr2135"))
        + "gr2135/Stonk/data/src/main/resources/database.json";
  }

  /**
   * Get all users.
   *
   * @return array of all users.
   */
  public JSONArray getAllUsers() {
    adaptFilePath();
    JSONParser parser = new JSONParser();
    JSONArray obj = new JSONArray();
    try (FileReader reader = new FileReader(file, StandardCharsets.UTF_8)) {
      obj = (JSONArray) parser.parse(reader);
    } catch (IOException | ParseException e) {
      System.out.println(e);
    }
    return obj;
  }

  /**
   * Writes the array to file.
   *
   * @param arr given array.
   * @throws IOException if it doesnt work.
   */
  public void writeToFile(String arr) throws IOException {
    adaptFilePath();
    FileOutputStream fileStream = new FileOutputStream(file, false);
    Writer writer = new OutputStreamWriter(fileStream, StandardCharsets.UTF_8);
    writer.write(arr);
    writer.close();
  }
}
