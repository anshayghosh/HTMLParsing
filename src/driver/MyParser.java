//**********************************************************
//Assignment3:
//CDF user_name:c5ghosha
//
//Author:Anshay Ghosh
//
//
//Honor Code: I pledge that this program represents my own
//program code and that I have coded on my own. I received
//help from no one in designing and debugging my program.
//*********************************************************
package driver;
import java.util.ArrayList;

public class MyParser {
  
  public static String firstTitle;

/**
* @param args
*/
public static void main(String[] args) {
 execute(args);
}


private static void execute(String[] args) {
 // TODO Auto-generated method stub
 ArrayList<String> allRawHTML = new ArrayList<String>();
 String inputFiles[] = args[0].split(",");
 //runs a loop to run each class on the html.
 try{
   System.out.println("--------------------------------------------------------"
       + "---------------");
 for (String inputFile : inputFiles) {
   String rawHTMLString = GetHTML.execute(inputFile);
   rawHTMLString.replaceAll("&#39","'");
   System.out.println(NameOfAuthor.execute(rawHTMLString));
   System.out.println(NumberOfCitations.execute(rawHTMLString));
   System.out.println(I10Index.execute(rawHTMLString));
   System.out.println(First3Publications.execute(rawHTMLString));
   System.out.println( paperCitation.execute(rawHTMLString,firstTitle));
   System.out.println(TotalCoAuthors.execute(rawHTMLString));
   allRawHTML.add(rawHTMLString);
   System.out.println("--------------------------------------------------------"
       + "---------------");
 }
 System.out.println(CoAuthorCompilation.execute(allRawHTML));
 }
 catch(Exception e){
   System.out.println("malformed URL or cannot open connection to "
       + "given URL");
 }
}



  
}
