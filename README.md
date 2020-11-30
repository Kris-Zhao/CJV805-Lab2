# CJV805-Lab2

Lab2 Assignment Submission 
========================================================
I/we declare that the attached assignment is my/our own work in accordance with Seneca
Academic Policy. No part of this assignment has been copied manually or electronically from any
other source (including web sites) or distributed to other students.
Name(s):Yuhang Zhao           Student ID(s):150467199


Reflection: For each coding part, You should explain briefly (50-100 words) explain what your
code is doing and what is the logic behind your ideas.

In this lab2, there are actually two packages.

Task2:
The first package called "getData" is to get sporty cars data from oracle database. OracleInfo.java stores the info of my oracle database.
The SportyCars.java is a Javabean class for SportyCars.
The getDataFromOracle.java is using THIN driver to connect to my Oracle database. It would return an array whose every element is a Sporty Car. 
This array includes all data from SPORTYCARS table.

The second default package is to execute a set of tasks in this lab.
Firstly, JdomCreateXml.java is to use the returned array to create an XML file named cars.xml. Here I use Jdom to create this XML file. More specifically,
I just construct this file using many elements and populate these elements with returned array. Then display and store it. I also write a cars.xsl file  
to style the cars.xml file so that the XML file can be presented in web browsers in an HTML table. I link the cars.xsl file inside cars.xml.

Then using XmlStylizer class to generate an HTML file named cars.html from cars.xml and cars.xsl files. 

Task3:
JdomParser class is to read and parse the cars.xml file using JDOM API. It will print the parsed data on Console.

Task4:
XML Document Object Model:
The DOM for XML defined a standard for accessing and documenting XML documents. It presents a XML document as a tree-structure. In other words, 
the XML DOM is a standard for how to get, change, add, or delete XML elements. Also the DOM interface can parse an entire XML document and builds 
an in-memory(XML) Document representation.

XML Schema:
An XML Schema describes the structure of an XML document. One XML file basically consists of markup and the text.The XML Schema language is also 
referred to as XML Schema Definition (XSD). 

Task5:
CreateJsonObjAndArray is to create the Json file storing data showed in Sporty Cars table and show in the Console.
ReadRemoteJsonObjWithArray is to read and parse the remote cars.json file using the org.json JSON API Jand calling RESTful web service.
