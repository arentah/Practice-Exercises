import org.json.*;
import java.io.File;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

public class JsonParser {

    public static void main(String[] args){
        JsonParser parser = new JsonParser();
        try {
            parser.readJSON();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readJSON() throws Exception {
        String path = "C:\\Users\\Aren\\IdeaProjects\\practice-exercises\\project\\json-parser\\json\\sample.json";
        File file = new File(path);
        //File file = new File("./json/sample.json");
        String content = FileUtils.readFileToString(file, "utf-8");
        JSONObject sample = new JSONObject(content);
        JSONArray jsonArray = sample.getJSONArray("features");

        String type;

        ArrayList<Double> res = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            try{
                type = jsonObject.getString("type");
                JSONArray jsonArray1 = jsonObject.getJSONObject("geometry").getJSONArray("dimensions");
                res.addAll(printDouble(jsonArray1));

                Double[] tmp = arrayListToDoubleArray(printDouble(jsonArray1));
                System.out.println("----------------");
                System.out.println(type);
                for(Double d : tmp)
                    System.out.print(d+" ");
                System.out.println("\n****************\n");
            }catch(Exception e){
                System.out.println("failing at: " + i +" error: "+ e);
            }
        }
        System.out.println("-----total------");
        for(Double d : res)
            System.out.print(d+" ");
        System.out.println("\n****************");
        //https://www.codevoila.com/post/65/java-json-tutorial-and-example-json-java-orgjson
    }


    private static ArrayList<Double> printDouble(JSONArray array) throws IllegalArgumentException{
        ArrayList<Double> res = new ArrayList<>();
        for(Object obj : array){
            if(obj instanceof Double){
                res.add((Double) obj);
            }else if(obj instanceof JSONArray){
                res.addAll(printDouble((JSONArray)obj));
            }else{
                throw new IllegalArgumentException("Invalid input... Expecting array of Double or arrays of arrays");
            }
        }
        return res;
    }

    private Double[] arrayListToDoubleArray(ArrayList<Double> array){
        Double[] result = new Double[array.size()];
        for(int i = 0; i < array.size(); i++){
            result[i] = array.get(i);
        }
        return result;
    }

    private double[] jsonToDoubleArray(JSONArray jsonArray){
        double[] result = new double[jsonArray.length()];
        for(int i = 0; i < jsonArray.length(); i++){
            result[i] = jsonArray.getDouble(i);
        }
        return result;
    }
}





