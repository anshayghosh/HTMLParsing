package test;
import static org.junit.Assert.*;
import driver.GetHTML;
import driver.TotalCoAuthors;

import org.junit.Before;
import org.junit.Test;


public class TotalCoAuthorsTest {
  String rawHTMLString;
  String rawHTMLString1;
  @Before
  public void setUp() throws Exception{
    rawHTMLString = GetHTML.execute("sample1.html");
    rawHTMLString1 = GetHTML.execute("sample2.html");
    
  }
  
  @Test
  public void executeTest1(){
    assertEquals("6. Total Co-Authors:\n\t15",
        TotalCoAuthors.execute(rawHTMLString));
  }
  
  @Test
  public void executeTest2(){
    assertEquals("6. Total Co-Authors:\n\t14",
        TotalCoAuthors.execute(rawHTMLString1));
  }
  
}
