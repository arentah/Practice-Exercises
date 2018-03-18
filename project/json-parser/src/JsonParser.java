import org.json.*;
import java.io.File;
import org.apache.commons.io.FileUtils;


public class JsonParser {

    public static void main(String[] args){

        JSONObject jsonObject = new JSONObject("{\"name\": \"John\"}");

        String type = jsonObject.getString("name");

        System.out.println(type);

    }

}
