
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.logging.Log;

public class hello{
    public static void main(String[] args) {
        
    
        
       
 
}
    
    
    
    
public static String getContentFromHtmlPage(String page) {
    StringBuilder sb = new StringBuilder();

    try {
        URLConnection connection = new URL(page).openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        in.close();
    } catch (IOException e) {
        // handle exception
    }

//    return Html.fromHtml(sb.toString()).toString();
}
}