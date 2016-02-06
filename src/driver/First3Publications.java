package driver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class First3Publications {

  public static String execute(String rawHTMLString){
    //initiated to recieve the first title and equated it to the static variable
    String reForPublicationExtraction =
        "class=\"cit-dark-link\">Year</a></td></tr> <tr class=\"cit-table item\">"
        + "<td id=\"col-title\"><a href=\"(.*?)\" class=\"cit-dark-large-link\">"
        + "(.*?)</a><br>";
    Pattern patternObject = Pattern.compile(reForPublicationExtraction);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    String finalOutput = "";
    while (matcherObject.find()) {
      finalOutput = finalOutput+matcherObject.group(2);
  }
    MyParser.firstTitle = finalOutput;
    //ran the method to consistently add titles to the final output
    //and returned the final output
    String nextTitle = getNextTitle(finalOutput,rawHTMLString);
    finalOutput = finalOutput + "\n\t-"+nextTitle;
    String finalTitle = getNextTitle(nextTitle,rawHTMLString);
    finalOutput = finalOutput + "\n\t-"+finalTitle;
    finalOutput = "4. Title of the first 3 publications:\n\t-" + finalOutput;
    return finalOutput;
  }

  //method to get the next title on the list
  public static String getNextTitle(String previousTitle,String rawHTMLString){
    //using the location and matching based on the previous title
    String titleLocation = "class=\"cit-dark-large-link\">"+previousTitle+
        "</a><br><span class=\"cit-gray\">(.*?)</span>"
        + "<br><span class=\"cit-gray\">(.*?)</span></td>"
        + "<td id=\"col-citedby\"><a class=\"cit-dark-link\" "
        + "href=\"(.*?)\">(.*?)</a></td><td id=\"col-asterisk\"></td><td "
        + "id=\"col-year\">(.*?)</td></tr> <tr class=\"cit-table item\"><td "
        + "id=\"col-title\"><a href=\"(.*?)\" class=\"cit-dark-large-link\">"
        + "(.*?)"
        + "</a><br>";
    Pattern patternObject = Pattern.compile(titleLocation);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    String nextTitle = "";
    while(matcherObject.find()){
      nextTitle =  matcherObject.group(7);
    }
    return nextTitle;
  }
}
