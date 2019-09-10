package vys.tax.computation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ObjectFactory {

	private Map<String, String> plugins = new HashMap<String, String>();

	private Map<String, ComputationCommand> commands = new HashMap<String, ComputationCommand>();

	public ObjectFactory(String xml) {
		plugins = loadData(xml);
	}

	private Map<String, String> loadData(String xml) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse("src/main/resource/" + xml);
			doc.getDocumentElement().normalize();
			NodeList parentNode = doc.getElementsByTagName("plugin");

			for (int i = 0; i < parentNode.getLength(); i++) {
				Node node = parentNode.item(i);
				Element element = (Element) node;
				plugins.put(element.getElementsByTagName("archetype").item(0).getTextContent(),
						element.getElementsByTagName("command").item(0).getTextContent());

			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plugins;
	}

	public ComputationCommand get(String archetype, String mode)
			throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
		ComputationCommand temp = null;
		if (commands.containsKey(archetype)) {
			return mode.equals("singleton") ? temp : ComputationCommand.deepClone(temp);
		}

		String className = plugins.get(archetype);
		if (className == null) {
			return null;
		}

		Class c = Class.forName(className);
		if (c == null) {
			return null;
		}
		commands.put(archetype, (ComputationCommand) c.newInstance());
		return commands.get(archetype);
	}
}
