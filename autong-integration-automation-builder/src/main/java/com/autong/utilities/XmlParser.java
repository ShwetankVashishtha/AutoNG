package com.autong.utilities;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2023
 */
public class XmlParser {

    /**
     * This method will take XML file path and XML tag name as input
     * and return XML tag / node value as output
     *
     * @param filePath accepts XML file
     * @param tagName  accepts XML tag name
     * @return XML tag / node name value
     * @author Shwetank Vashishtha
     */
    public static String getXmlTagValue(File filePath, String tagName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);

            NodeList elementsByTagName = document.getElementsByTagName(tagName);
            return elementsByTagName.item(0).getTextContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tagName;
    }

    /**
     * This method will take XML file path and XML tag name as input
     * and return XML tag / node name as output
     *
     * @param filePath accepts XML file
     * @param tagName  accepts XML tag name
     * @return XML tag / node value
     * @author Shwetank Vashishtha
     */
    public static String getXmlTagName(File filePath, String tagName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);

            NodeList elementsByTagName = document.getElementsByTagName(tagName);
            return elementsByTagName.item(0).getNodeName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method will take XML file path, XML tag name and XML attribute name as input
     * and return XML attribute as key-value pair
     *
     * @param filePath      accepts XML file
     * @param tagName       accepts XML tag name
     * @param attributeName accepts XML attribute name
     * @return XML attribute key value pair
     * @author Shwetank Vashishtha
     */
    public static Node getNamedItem(File filePath, String tagName, String attributeName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);

            NodeList elementsByTagName = document.getElementsByTagName(tagName);
            return elementsByTagName.item(0).getAttributes().getNamedItem(attributeName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}