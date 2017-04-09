import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.webscrap4j.WebScrap;
import com.webscrap4j.WebScrapException;

public class Example {
 /**
  * @param args
  */
 public static void main(String[] args) {
    try
  {
   ArrayList<String> al=new ArrayList<String>();
   ArrayList<String> restaurants=new ArrayList<String>();
   WebScrap ws= new WebScrap();
         ws.setUrl("https://www.yelp.ca/search?find_loc=Waterloo,+ON,+Canada&start=0&cflt=restaurants");
   ws.startWebScrap();
      System.out.println("-------------------All anchor tag-----------------------------");
   al=ws.getImageTagData("a", "href");
   for(String adata: al)
   {
       
      
       // /biz/
//       String temp = adata.substring(0, 4);
     if(adata.startsWith("/biz/")){
        
          
         int second = adata.indexOf("-");
         
        
       StringBuilder temp = new StringBuilder(adata);
        temp.delete(0, 5);
 int number = temp.indexOf("?");
 
 
        if(number > 0){
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
//             System.out.println( finalRestaurant);
//                System.out.println(temp);
        }
         
       
        
     
     
       
       
       
         
  
     }
    
   }
   
      for (int i = 0; i < restaurants.size(); i++) {
          System.out.println(restaurants.get(i));
      }
   
   
//      System.out.println("-------------------Image data-----------------------------");
//   System.out.println(ws.getImageTagData("img", "src"));
//   System.out.println(ws.getImageTagData("img", "alt"));
//      System.out.println("-------------------Ul-Li Data-----------------------------");
//      
//      
// 
//   for(String str:al)
//   {
//    System.out.println(str);
//   }
     }
  catch(WebScrapException e)
  {
   e.printStackTrace();
  }
  
 }
 
 
 
 
 
}