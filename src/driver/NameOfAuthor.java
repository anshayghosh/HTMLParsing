package driver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameOfAuthor {

  public static String execute(String rawHTMLString){
    //finds and matches the location of the authors name.
    String finalOutput="";
    String reForAuthorExtraction =
        "<span id=\"cit-name-display\" "
            + "class=\"cit-in-place-nohover\">(.*?)</span>";
    Pattern patternObject = Pattern.compile(reForAuthorExtraction);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    while (matcherObject.find()) {
      finalOutput = "1.Name of Author:\n\t" + matcherObject.group(1);

  }
    return finalOutput;
  }
}
