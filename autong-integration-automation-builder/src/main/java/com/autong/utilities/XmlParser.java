package com.autong.utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlParser {

    public static void xmlParser(File filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);

            NodeList elementsByTagName = document.getElementsByTagName("address");
            System.out.println(elementsByTagName.getLength());
            System.out.println(elementsByTagName.item(0).getAttributes().getNamedItem("display"));

            Element element = document.getDocumentElement();
            NamedNodeMap attributes = element.getAttributes();
            System.out.println(attributes.getNamedItem("username"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}