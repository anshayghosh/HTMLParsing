package driver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOfCitations {

  public static String execute(String rawHTMLString){
    //Finds and matches the location with the citations
    String finalOutput="";
    String reForCitationExtraction =
        ">Citations</a></td><td class=\"cit-borderleft cit-data\">(.*?)</td>";
    Pattern patternObject = Pattern.compile(reForCitationExtraction);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    while (matcherObject.find()) {
      finalOutput = "2. Number of All Citations:\n\t" + matcherObject.group(1);

  }
    return finalOutput;
  }
}
