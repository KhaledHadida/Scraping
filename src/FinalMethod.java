
import com.webscrap4j.WebScrap;
import com.webscrap4j.WebScrapException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin Yu
 */
public class FinalMethod {

    String tests;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        FinalMethod d = new FinalMethod();


        System.out.println(d.FinalMethods(1));

    }

    public String FinalMethods(int option) {
        try {
            ArrayList<String> al = new ArrayList<String>();
            ArrayList<String> restaurants = new ArrayList<String>();
            WebScrap ws = new WebScrap();
            ws.setUrl("https://www.yelp.ca/search?find_loc=Waterloo,+ON,+Canada&start=0&cflt=restaurants");
            ws.startWebScrap();
            System.out.println("-------------------All anchor tag-----------------------------");
            al = ws.getImageTagData("a", "href");
            for (String adata : al) {


                // /biz/
//       String temp = adata.substring(0, 4);
                if (adata.startsWith("/biz/")) {


                    int second = adata.indexOf("-");


                    StringBuilder temp = new StringBuilder(adata);
                    temp.delete(0, 5);
                    int number = temp.indexOf("?");


                    if (number > 0) {
                        for (int i = 0; i < temp.length(); i++) {



                            char temporary = temp.charAt(i);
                            if (temporary == '-') {
                                int first = temp.indexOf("-");
                                temp.deleteCharAt(first);
                                temp.replace(first, first, " ");



                            }

                        }

                        String finalRestaurant = temp.substring(0, number);
                        String tempsss = "" + finalRestaurant;
                        restaurants.add(tempsss);
                    }










                }

            }

            for (int i = 0; i < restaurants.size(); i++) {
//                System.out.println(restaurants.get(i));
            }

            tests = restaurants.get(option);
            return restaurants.get(option);
        } catch (WebScrapException e) {
            e.printStackTrace();
        }
        return tests;



    }
}
