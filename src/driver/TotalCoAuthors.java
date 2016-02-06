package driver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class TotalCoAuthors {
  public static String currentAuthor;
  

  public static ArrayList<String> getCoAuthors(String rawHTMLString){
    //finds the location fo the first co author.
    String location = "Co-authors</div><div style=\"padding:.5em; border:.3em s"
        + "olid #9FD9A7\"><a class=\"cit-dark-link\" href=\"(.*?)\" title=\""
        + "(.*?)\">";
    ArrayList<String> AuthorList = new ArrayList<String>();
    Pattern patternObject = Pattern.compile(location);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    if(matcherObject.find()) {
      currentAuthor=matcherObject.group(2);
      while(getNextAuthor(rawHTMLString)!=""){
        //runs method to iterate through list of authors and
        //add them to the final list
        AuthorList.add(currentAuthor);
        currentAuthor = getNextAuthor(rawHTMLString);
      }
      AuthorList.add(currentAuthor);
      return AuthorList;
    }
    else
      return AuthorList;
    
  }
  public static String getNextAuthor(String rawHTMLString){
    //uses the name of the current author to get the name of the next and 
    //terminate when necessary
    String location = currentAuthor +"</a><br><a class=\"cit-dark-link\" href"
        + "=\"(.*?)\" title=\"(.*?)\">(.*?)</a><br>";
    Pattern patternObject = Pattern.compile(location);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    String output = "";
    if(matcherObject.find()){
      output = output+matcherObject.group(3);
    }
    return output;
  }

  public static String execute(String rawHTMLString) {
    // TODO Auto-generated method stub
    String finalOutput="";
    ArrayList<String> finalList = getCoAuthors(rawHTMLString);
    finalOutput = "6. Total Co-Authors:\n\t" + finalList.size();
    return finalOutput;
  }
}
