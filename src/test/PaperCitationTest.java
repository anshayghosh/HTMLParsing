package test;
import static org.junit.Assert.*;
import driver.GetHTML;
import driver.paperCitation;

import org.junit.Before;
import org.junit.Test;


public class PaperCitationTest {
  String rawHTMLString;
  String rawHTMLString1;
  @Before
  public void setUp() throws Exception{
    rawHTMLString = GetHTML.execute("sample1.html");
    rawHTMLString1 = GetHTML.execute("sample2.html");
    
  }
  
  @Test
  public void executeTest1(){
    assertEquals("5. Total paper citation (first 5 papers):\n\t239",
        paperCitation.execute(rawHTMLString,"Bioclipse: an open source workbenc"
            + "h for chemo-and bioinformatics"));
  }
  
  @Test
  public void executeTest2(){
    assertEquals("5. Total paper citation (first 5 papers):\n\t158",
        paperCitation.execute(rawHTMLString1,"Face-tracking as an augmented inp"
            + "ut in video games: enhancing presence, role-playing and "
            + "control"));
  }
  
}
