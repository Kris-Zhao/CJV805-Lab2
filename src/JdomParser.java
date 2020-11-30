import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * JdomParser class is to read and parse the cars.xml file using JDOM API. Print the parsed data in the console.
 * @author Yuhang Zhao, student#=150467199
 *
 */
public class JdomParser {

	public static void main(String[] args) {
	      try {
	    	  
	         // Create a DocumentBuilder
	         SAXBuilder saxBuilder = new SAXBuilder();

	         // Create a Document from a file 
	         File inputFile = new File("cars.xml");
	         Document document = saxBuilder.build(inputFile);

	         // Extract the root element
	         Element classElement = document.getRootElement();
	         System.out.println("Root element: " + classElement.getName());
	         
	         // Examine sub-elements
	         List<Element> carList = classElement.getChildren();
	         System.out.println("================================");

	         for (int i = 0; i < carList.size(); i++) {    
	        	 
	        	// Examine a single sub-element
	            Element car = carList.get(i);
	            System.out.println("\nElement :" 
	               + car.getName());
	            // Examine the attribute
	            Attribute attribute =  car.getAttribute("id");
	            System.out.println("Car# : " 
	               + attribute.getValue() );
	            
	            // Examine the sub-text nodes and print out
	            System.out.println("Year : " + car.getChild("year").getText());
	            System.out.println("Make : "+ car.getChild("make").getText());
	            System.out.println("Model : "+ car.getChild("model").getText());
	            System.out.println("Price : "+ car.getChild("price").getText());	            		
	         }
	      }catch(JDOMException e){
	         e.printStackTrace();
	      }catch(IOException ioe){
	         ioe.printStackTrace();
	      }
	   }
	}