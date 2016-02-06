package driver;

import java.util.ArrayList;
import java.util.Collections;

public class CoAuthorCompilation {

  public static String execute(ArrayList<String> allRawHTML) {
    // TODO Auto-generated method stub
    //initiated a list and stored all the coauthor names
    ArrayList<String> AuthorList = new ArrayList<String>();
    for(String rawHTML:allRawHTML){
      AuthorList.addAll(TotalCoAuthors.getCoAuthors(rawHTML));
    }
    //removed duplicates
    ArrayList<String> finalAuthorList = new ArrayList<String>();
    for(String author:AuthorList){
      if(!finalAuthorList.contains(author))
        finalAuthorList.add(author);
    }
    //sorted and outputted list
    Collections.sort(finalAuthorList);
    String finalOutput ="Co-Author list sorted (Total:"+finalAuthorList.size()+
        "):";
    for(String author:finalAuthorList)
      finalOutput = finalOutput + "\n\t"+author;
    return finalOutput;
  }

  
}
