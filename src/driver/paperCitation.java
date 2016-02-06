package driver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class paperCitation {
  public static String currentTitle;

  public static String execute(String rawHTMLString,String firstTitle){
    String finalOutput;
    //finds the location and matches that of the first integer value
    String integerLocation = firstTitle+"</a><br><span class=\"cit-gray\">(.*?)"
       + "</span><br><span class=\"cit-gray\">(.*?)</span></td><td id=\"col-cit"
       + "edby\"><a class=\"cit-dark-link\" href=\"(.*?)\">(.*?)</a></td><td id"
        + "=\"col-asterisk\"></td><td id=\"col-year\">(.*?)</td></tr> <tr class"
        + "=\"cit-table item\"><td id=\"col-title\"><a href=\"(.*?)\" class=\""
        + "cit-dark-large-link\">(.*?)</a>";
    int finalVal = 0;
    Pattern patternObject = Pattern.compile(integerLocation);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    while (matcherObject.find()) {
    finalVal = finalVal +Integer.parseInt(matcherObject.group(4));
    currentTitle = matcherObject.group(7);
    }
    int previousInt = finalVal;
    for(int i =0;i<4;i++){
      //runs method to continuously append values
      previousInt = nextValue(rawHTMLString,previousInt);
      finalVal = finalVal + previousInt;
    }
    finalOutput = "5. Total paper citation (first 5 papers):\n\t" +finalVal;
    return finalOutput;
  }
  
  public static int nextValue(String rawHTMLString, int currentVal){
    //using the previous value and current title locates the next value
    String integerLocation = currentVal+"</a></td><td id=\"col-asterisk"
        + "\"></td><td id=\"col-year\">(.*?)</td></tr> <tr class=\"cit-table it"
        + "em\"><td id=\"col-title\"><a href=\"(.*?)\" class=\"cit-dark-large-l"
        + "ink\">"+currentTitle+"</a><br><span class=\"cit-gray\">(.*?)</span><"
            + "br><span cl"
        + "ass=\"cit-gray\">(.*?)</span></td><td id=\"col-citedby\"><a class=\""
        + "cit-dark-link\" href=\"(.*?)\">(.*?)</a></td><td id=\"col-asterisk\""
        + "></td><td id=\"col-year\">(.*?)</td></tr> <tr class"
        + "=\"cit-table item\"><td id=\"col-title\"><a href=\"(.*?)\" class=\""
        + "cit-dark-large-link\">(.*?)</a>";
    Pattern patternObject = Pattern.compile(integerLocation);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    int finalVal = 0;
    //updates the most recent title and returns the current value;
    while (matcherObject.find()) {
     finalVal = Integer.parseInt(matcherObject.group(6));
     currentTitle = matcherObject.group(9);
    }
    return finalVal;
  }
}
