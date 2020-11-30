import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


import getData.getDataFromOracle;
import getData.SportyCars;

/**
 * JdomCreateXml class is to use the returned array(getDataFromOracle.requestDataThroughThin()) to create an XML file named cars.xml
 * @author Yuhang Zhao, student#=150467199
 *
 */
public class JdomCreateXml {
	public static void main(String[] args) {
		try {
			SportyCars[] carsArray = getDataFromOracle.requestDataThroughThin();
			
			// root element
			Element carsElement = new Element("SportyCars");
			Document document = new Document(carsElement);
			
			for(int i = 1 ; i <= carsArray.length ; i++) {
				//car element
				Element car = new Element("Car");
				car.setAttribute(new Attribute("id", Integer.toString(i)));
				
				Element year = new Element("year");
				year.setText(Integer.toString(carsArray[i-1].getYear()));
				Element make = new Element("make");
				make.setText(carsArray[i-1].getMake());
				Element model = new Element("model");
				model.setText(carsArray[i-1].getModel());
				Element price = new Element("price");
				price.setText(Double.toString(carsArray[i-1].getPrice()));
				
				car.addContent(year);
				car.addContent(make);
				car.addContent(model);
				car.addContent(price);
				
				document.getRootElement().addContent(car);
			}
			
			XMLOutputter xmlOutput = new XMLOutputter();
			
			// display xml
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(document, System.out);
			
			// store xml file into cars.xml
			FileOutputStream fileStream = new FileOutputStream(new File("cars.xml"));
			xmlOutput.output(document, fileStream);
			
		} catch (IOException e) {
			e.printStackTrace();
			}
			
		
	}
}
