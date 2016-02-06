package test;
import static org.junit.Assert.*;
import driver.GetHTML;
import driver.First3Publications;

import org.junit.Before;
import org.junit.Test;


public class First3PublicationsTest {
  String rawHTMLString;
  String rawHTMLString1;
  @Before
  public void setUp() throws Exception{
    rawHTMLString = GetHTML.execute("sample1.html");
    rawHTMLString1 = GetHTML.execute("sample2.html");
    
  }
  
  @Test
  public void executeTest1(){
    assertEquals("4. Title of the first 3 publications:\n\t-Face-tracking as an"
        + " augmented input in video games: enhancing presence, role-playing an"
        + "d control\n\t-Art of defense: a collaborative handheld augmented rea"
        + "lity board game\n\t-Sociable killers: understanding social relations"
        + "hips in an online first-person shooter game",
        First3Publications.execute(rawHTMLString1));
  }
  
  @Test
  public void executeTest2(){
    assertEquals("4. Title of the first 3 publications:\n\t-Bioclipse: an open "
        + "source workbench for chemo-and bioinformatics\n\t-The LCB data wareh"
        + "ouse\n\t-XMPP for cloud computing in bioinformatics supporting disco"
        + "very and invocation of asynchronous web services",
        First3Publications.execute(rawHTMLString));
  }
  
}
