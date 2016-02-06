package test;
import static org.junit.Assert.*;
import driver.GetHTML;
import driver.CoAuthorCompilation;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;


public class CoAuthorCompilationTest {
  ArrayList<String> inputList=new ArrayList<String>();
  ArrayList<String> inputList1=new ArrayList<String>();
  ArrayList<String> inputList2=new ArrayList<String>();
  
  @Before
  public void setUp() throws Exception{
    String rawHTMLString = GetHTML.execute("sample1.html");
    String rawHTMLString1 = GetHTML.execute("sample2.html");
    inputList.add(rawHTMLString);
    inputList1.add(rawHTMLString1);
    inputList2.add(rawHTMLString);
    inputList2.add(rawHTMLString1);
    
  }
  
  @Test
  public void executeTest1(){
    assertEquals("Co-Author list sorted (Total:15):\n\tAdam Ameur\n\tAntony Joh"
        + "n Williams\n\tChristoph Steinbeck\n\tEgon Willighagen\n\tJanna Hasti"
        + "ngs\n\tJonathan Alvarsson\n\tKomorowski Jan\n\tNina Jeliazkova\n\tNo"
        + "el M. O'Boyle\n\tRajarshi Guha\n\tSam Adams\n\tSamuel Lampa\n\tSean "
        + "Ekins\n\tValentin Georgiev\n\tgilleain torrance",
        CoAuthorCompilation.execute(inputList));
  }
  
  @Test
  public void executeTest2(){
    assertEquals("Co-Author list sorted (Total:14):\n\tAbigail Sellen\n\tAndrew"
        + " D Miller\n\tBlair MacIntyre\n\tDeepak Jagdish\n\tE.D. Mynatt\n\tEls"
        + "a Eiriksdottir\n\tErika Shehan Poole\n\tGreg Turk\n\tIulian Radu\n\t"
        + "John Stasko\n\tKurt Luther\n\tThore Graepel\n\tXiang Cao\n\tYoun-ah "
        + "Kang",CoAuthorCompilation.execute(inputList1));
  }
  
  @Test
  public void executeTest3(){
    assertEquals("Co-Author list sorted (Total:29):\n\tAbigail Sellen\n\tAdam A"
        + "meur\n\tAndrew D Miller\n\tAntony John Williams\n\tBlair MacIntyre\n"
        + "\tChristoph Steinbeck\n\tDeepak Jagdish\n\tE.D. Mynatt\n\tEgon Willi"
        + "ghagen\n\tElsa Eiriksdottir\n\tErika Shehan Poole\n\tGreg Turk\n\tIu"
        + "lian Radu\n\tJanna Hastings\n\tJohn Stasko\n\tJonathan Alvarsson\n\t"
        + "Komorowski Jan\n\tKurt Luther\n\tNina Jeliazkova\n\tNoel M. O'Boyle"
        + "\n\tRajarshi Guha\n\tSam Adams\n\tSamuel Lampa\n\tSean Ekins\n\tTho"
        + "re Graepel\n\tValentin Georgiev\n\tXiang Cao\n\tYoun-ah Kang\n\tgil"
        + "leain torrance",CoAuthorCompilation.execute(inputList2));
    
  }
  
}
