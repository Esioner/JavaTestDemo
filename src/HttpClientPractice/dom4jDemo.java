package HttpClientPractice;

import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class dom4jDemo {

	public static void main(String[] args) {

	}
	public static void modifyXML() {

	}
	public static void creatXML() {
		// ʹ�� DocumentHelper �ഴ��һ�� document ʵ��
		Document document = DocumentHelper.createDocument();
		// ʹ�� addElement() ����������Ԫ�� catalog,�˷��������� xml �ĵ������Ӹ�Ԫ��
		Element catalogElement = document.addElement("catalog");
		// �� catalog Ԫ����ʹ��addComment()��������ע��
		catalogElement.addComment("An XML catalog");
		// �� catalog Ԫ����ʹ�� addProcessingInstruction() ��������һ������ָ��
		catalogElement.addProcessingInstruction("target", "text");
		// �� catalog Ԫ����ʹ�� addElement() �������� journal Ԫ��
		Element journalElement = catalogElement.addElement("journal");
		// ʹ�� addAttribute() ������ journalԪ����� title �� publisher ����
		journalElement.addAttribute("title", "XML Zone");
		journalElement.addAttribute("publisher", "IBM developerWorks");
		// �� article Ԫ������� journal Ԫ��
		Element articleElement = journalElement.addElement("article");
		// Ϊ article Ԫ������ level �� data ����
		articleElement.addAttribute("level", "Intermediate");
		articleElement.addAttribute("data", "Decemner-2001");
		// �� article ��� title Ԫ��
		Element titleElement = articleElement.addElement("title");
		// ʹ�� setText() �������� article Ԫ�ص��ı�
		titleElement.setText("Java configuration with XML Schema");
		// �� article ����� author Ԫ��
		Element authorElement = articleElement.addElement("author");
		// �� author Ԫ�������� firstname Ԫ�ز����ø�Ԫ�ص��ı�
		Element firsNameElement = authorElement.addElement("firstname");
		firsNameElement.setText("Marcello");
		// �� author Ԫ�������� lastname Ԫ�ز����ø�Ԫ�ص��ı�
		Element lastnameElement = authorElement.addElement("lastname");
		lastnameElement.setText("Vitaletti");
		// ʹ�� addDocType() ����������ĵ�˵��
		document.addDocType("catalog", null, "file://c:/Dtds/catalog.dtd");
		try {
			//���� XML 
			XMLWriter output = new XMLWriter(new FileWriter(new File("e:/a.xml")));
			output.write(document);
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
