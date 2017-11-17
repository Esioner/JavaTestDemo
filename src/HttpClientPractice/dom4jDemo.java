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
		// 使用 DocumentHelper 类创建一个 document 实例
		Document document = DocumentHelper.createDocument();
		// 使用 addElement() 方法创建根元素 catalog,此方法用于向 xml 文档中增加根元素
		Element catalogElement = document.addElement("catalog");
		// 在 catalog 元素中使用addComment()方法增加注释
		catalogElement.addComment("An XML catalog");
		// 在 catalog 元素中使用 addProcessingInstruction() 方法增加一个处理指令
		catalogElement.addProcessingInstruction("target", "text");
		// 在 catalog 元素中使用 addElement() 方法增加 journal 元素
		Element journalElement = catalogElement.addElement("journal");
		// 使用 addAttribute() 方法向 journal元素添加 title 和 publisher 属性
		journalElement.addAttribute("title", "XML Zone");
		journalElement.addAttribute("publisher", "IBM developerWorks");
		// 向 article 元素中添加 journal 元素
		Element articleElement = journalElement.addElement("article");
		// 为 article 元素增加 level 和 data 属性
		articleElement.addAttribute("level", "Intermediate");
		articleElement.addAttribute("data", "Decemner-2001");
		// 向 article 添加 title 元素
		Element titleElement = articleElement.addElement("title");
		// 使用 setText() 方法设置 article 元素的文本
		titleElement.setText("Java configuration with XML Schema");
		// 在 article 中添加 author 元素
		Element authorElement = articleElement.addElement("author");
		// 在 author 元素中增加 firstname 元素并设置该元素的文本
		Element firsNameElement = authorElement.addElement("firstname");
		firsNameElement.setText("Marcello");
		// 在 author 元素中增加 lastname 元素并设置该元素的文本
		Element lastnameElement = authorElement.addElement("lastname");
		lastnameElement.setText("Vitaletti");
		// 使用 addDocType() 方法来添加文档说明
		document.addDocType("catalog", null, "file://c:/Dtds/catalog.dtd");
		try {
			//生成 XML 
			XMLWriter output = new XMLWriter(new FileWriter(new File("e:/a.xml")));
			output.write(document);
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
