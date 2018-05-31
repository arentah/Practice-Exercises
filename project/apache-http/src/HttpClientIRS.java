import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

//http://www.technicalkeeda.com/java-tutorials/apache-httpclient-get-post-request-examples
//https://jsoup.org/cookbook/extracting-data/attributes-text-html
//http://www.irs.gov/uac/Authorized-IRS-e-file-Providers-for-Individuals

public class HttpClientIRS {

    private ArrayList<Client> clientArrayList = new ArrayList<>();

    void get(int zip_code) {
        Pattern pattern = Pattern.compile("([a-z &,'./]+)([0-9a-z .,#/\\-]+?), ([A-Z]{2}) "+zip_code+" ([a-z ]+) \\(([0-9]{10}) ([a-z ,]+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        String line;
        boolean flag = true;
        int inc = 1;

        while (true) {
            StringBuilder sb = new StringBuilder();
            try {
                HttpClient client = HttpClientBuilder.create().build();
                HttpGet get;
                if(flag) {
                    get = new HttpGet("https://www.irs.gov/efile-index-taxpayer-search?zip="+zip_code+"&state=All");
                    flag = false;
                }else {
                    get = new HttpGet("https://www.irs.gov/efile-index-taxpayer-search?zip=" + zip_code + "&state=All&page="+inc++);
                }
                HttpResponse response = client.execute(get);
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                while ((line = rd.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (UnsupportedOperationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Document doc = Jsoup.parse(sb.toString());
            org.jsoup.select.Elements elements = doc.getElementsByClass("views-field views-field-nothing-1 views-align-left");
            if(elements.size() == 0)
                break;

            for(int i = 0; i < elements.size(); i++){
                matcher = pattern.matcher(elements.get(i).text());
                while(matcher.find()) {
                    clientArrayList.add(new Client(matcher.group(1).trim().toUpperCase(),
                            matcher.group(2).trim()+", "+matcher.group(3).trim().toUpperCase()+" "+zip_code,
                            matcher.group(4).trim().toUpperCase(),matcher.group(5).trim(),matcher.group(6).trim()));
                }
            }
            elements.clear();
        }
    }

    ArrayList<Client> getClientArrayList() {
        return clientArrayList;
    }
}