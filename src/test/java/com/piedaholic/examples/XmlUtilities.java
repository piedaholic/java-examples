package com.piedaholic.examples;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtilities {

    public static final String sequenceTag = "xsd:sequence";

    public static HashMap<String, String> typeCheck = new HashMap<>();

    public static String fp = "E:\\Harsh\\Workspace\\tmp\\tmp11.txt";

    public static void main(String... args) {
        diffTypesXsd();
    }

    public static void diffTypesXsd() {
        Document obft = readXmlFile("E:\\Harsh\\Workspace\\tmp\\OBTFService.xsd");
        // Document fcubs =
        // readXmlFile("E:\\Harsh\\Workspace\\tmp\\FCUBSLCService.xsd");

        System.out.println("Root Element :" + obft.getDocumentElement().getNodeName());
        // System.out.println(getAllAttributes(obft, "xsd:complexType", "name"));
        try {
            traverseNodes(obft);
        }

        catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static void write(String str) throws IOException {
        Files.write(Paths.get(fp), str.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public static void traverseNodes(Node n) throws IOException {
        StringBuilder sb = new StringBuilder();
        NodeList children = n.getChildNodes();
        System.out.println("Number of children nodes " + children.getLength());
        String dbg = "";
        if (children != null) {
            for (int i = 0; i < children.getLength(); i++) {
                Node childNode = children.item(i);

                // here would be a good place to put your application logic
                // and do something base upon node type
                // System.out.println("node name = " + childNode.getNodeName() + " " +
                // childNode.getNodeType());
                dbg = "node name = " + childNode.getNodeName() + " " + childNode.getNodeType();
                sb.append(dbg + "\n");
                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) childNode;
                    // System.out.println("node name = " + childNode.getNodeName() + " " +
                    // element.getAttribute("name"));
                    dbg = "node name = " + element.getNodeName() + " " + element.getAttribute("name");
                    sb.append(dbg + "\n");
                }

                traverseNodes(childNode);
            }
        }
        write(sb.toString());
    }

    public static void diffWsdl() {
        Document doc1 = readXmlFile("E:\\Harsh\\Workspace\\tmp\\OBTFLCService.wsdl");
        List<String> listOne = getAllAttributes(doc1, "operation", "name");

        System.out.println("listOne contains " + listOne.size() + " elements");

        Document doc2 = readXmlFile("E:\\Harsh\\Workspace\\tmp\\FCUBSLCService.wsdl");
        List<String> listTwo = getAllAttributes(doc2, "operation", "name");

        System.out.println("listTwo contains " + listTwo.size() + " elements");

        System.out.println("Contained in both");
        listTwo.stream().filter(element -> listOne.contains(element)).collect(Collectors.toList())
                .forEach(System.out::println);

        List<String> onlyListOneContains = listOne.stream().filter(element -> !listTwo.contains(element))
                .collect(Collectors.toList());
        System.out.println("\nExclusive to OBTFLCService.wsdl");
        onlyListOneContains.forEach(System.out::println);

        List<String> onlyListTwoContains = listTwo.stream().filter(element -> !listOne.contains(element))
                .collect(Collectors.toList());

        System.out.println("\nExclusive to FCUBSLCService.wsdl");
        onlyListTwoContains.forEach(System.out::println);

    }

    public static Document readXmlFile(String path) {
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(new File(path));
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return doc;
    }

    public static List<String> getAllAttributes(Document doc, String tagName, String attribute) {
        List<String> result = new ArrayList<String>();
        NodeList nl = doc.getElementsByTagName(tagName);
        for (int temp = 0; temp < nl.getLength(); temp++) {

            Node node = nl.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;

                // get staff's attribute
                result.add(element.getAttribute(attribute));
            }

        }

        return result;

    }

    public static List<String> evaluateXPath(Document document, String xpathExpression) throws Exception {
        // Create XPathFactory object
        XPathFactory xpathFactory = XPathFactory.newInstance();

        // Create XPath object
        XPath xpath = xpathFactory.newXPath();

        List<String> values = new ArrayList<>();
        try {
            // Create XPathExpression object
            XPathExpression expr = xpath.compile(xpathExpression);

            // Evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            for (int i = 0; i < nodes.getLength(); i++) {
                values.add(nodes.item(i).getNodeValue());
            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return values;
    }

    public static Document getDocument(String fileName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fileName);
        return doc;
    }
}
