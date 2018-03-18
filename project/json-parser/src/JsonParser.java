import org.json.*;
import java.io.File;
import org.apache.commons.io.FileUtils;


public class JsonParser {

    public static void main(String[] args){
        try {
            readJSON();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readJSON() throws Exception {
        File file = new File("./json/sample.json");
        String content = FileUtils.readFileToString(file, "utf-8");
        JSONObject sample = new JSONObject(content);

        JSONArray jsonArray = sample.getJSONArray("features");

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        System.out.println(jsonObject.getString("type"));

        //https://www.codevoila.com/post/65/java-json-tutorial-and-example-json-java-orgjson
    }
}
