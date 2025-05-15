package com.autong.utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2023
 */
public class XmlParser {

    private static final Logger logger = Logger.getLogger(XmlParser.class.getName());

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
            String content;

            NodeList elementsByTagName = document.getElementsByTagName(tagName);
            if (elementsByTagName.getLength() != 0) {
                content = elementsByTagName.item(0).getTextContent();
            } else {
                content = "No tags with " + tagName + " is available in parsed xml";
                logger.info(content);
            }
            return content;
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return tagName;
    }

    /**
     * This method will take XML file path and XML tag name as input
     * and return all XML tags / nodes list as output
     *
     * @param filePath accepts XML file
     * @param tagName  accepts XML tag name
     * @return XML tag / node name value
     * @author Shwetank Vashishtha
     */
    public static List<String> getXmlTagValueList(File filePath, String tagName) {
        List<String> nodeList = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);

            NodeList elementsByTagName = document.getElementsByTagName(tagName);
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                nodeList.add(elementsByTagName.item(i).getTextContent());
            }
            return nodeList;
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return nodeList;
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
            logger.info(e.toString());
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
            logger.info(e.toString());
        }
        return null;
    }
}