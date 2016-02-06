package test;
import static org.junit.Assert.*;
import driver.GetHTML;
import driver.NameOfAuthor;

import org.junit.Before;
import org.junit.Test;


public class NameOfAuthorTest {
  String rawHTMLString;
  String rawHTMLString1;
  @Before
  public void setUp() throws Exception{
    rawHTMLString = GetHTML.execute("sample1.html");
    rawHTMLString1 = GetHTML.execute("sample2.html");
    
  }
  
  @Test
  public void executeTest1(){
    assertEquals("1.Name of Author:\n\tOla Spjuth",
        NameOfAuthor.execute(rawHTMLString));
  }
  
  @Test
  public void executeTest2(){
    assertEquals("1.Name of Author:\n\tYan Xu",
        NameOfAuthor.execute(rawHTMLString1));
  }
  
}
