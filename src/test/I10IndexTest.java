package test;
import static org.junit.Assert.*;
import driver.GetHTML;
import driver.I10Index;

import org.junit.Before;
import org.junit.Test;


public class I10IndexTest {
  String rawHTMLString;
  String rawHTMLString1;
  @Before
  public void setUp() throws Exception{
    rawHTMLString = GetHTML.execute("sample1.html");
    rawHTMLString1 = GetHTML.execute("sample2.html");
    
  }
  
  @Test
  public void executeTest1(){
    assertEquals("3. Number i10-index after 2009:\n\t12",
        I10Index.execute(rawHTMLString));
  }
  
  @Test
  public void executeTest2(){
    assertEquals("3. Number i10-index after 2009:\n\t9",
        I10Index.execute(rawHTMLString1));
  }
  
}
