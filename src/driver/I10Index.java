package driver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class I10Index {

  public static String execute(String rawHTMLString){
    //recieving the location on the html code and then matching the value.
    String finalOutput="";
    String reForIndexExtraction =
       ">i10-index</a></td><td class=\"cit-borderleft cit-data\">(.*?)</td><td "
        + "class=\"cit-borderleft cit-data\">(.*?)</td></tr></tbody></table>";
    Pattern patternObject = Pattern.compile(reForIndexExtraction);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    while (matcherObject.find()) {
      finalOutput = "3. Number i10-index after 2009:\n\t" + 
    matcherObject.group(2);
  }
    return finalOutput;
  }
}
