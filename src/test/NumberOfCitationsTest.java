package test;

import static org.junit.Assert.*;
import driver.GetHTML;
import driver.NumberOfCitations;

import org.junit.Before;
import org.junit.Test;


public class NumberOfCitationsTest {
  String rawHTMLString;
  String rawHTMLString1;
  @Before
  public void setUp() throws Exception{
    rawHTMLString = GetHTML.execute("sample1.html");
    rawHTMLString1 = GetHTML.execute("sample2.html");
    
  }
  
  @Test
  public void executeTest1(){
    assertEquals("2. Number of All Citations:\n\t437",
        NumberOfCitations.execute(rawHTMLString));
  }
  
  @Test
  public void executeTest2(){
    assertEquals("2. Number of All Citations:\n\t263",
        NumberOfCitations.execute(rawHTMLString1));
  }
  
}

