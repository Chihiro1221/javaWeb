import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jTest {
    @Test
    public void test1() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("src/books.xml");
        System.out.println(read);
    }

    /**
     * 解析xml标签并且转换为java对象
     *
     * @throws DocumentException
     */
    @Test
    public void test2() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        Element rootElement = document.getRootElement();
        List<Element> books = rootElement.elements("book");
        for (Element book : books) {
            String name = book.elementText("name");
            String author = book.elementText("author");
            String price = book.elementText("price");
            String sn = book.attributeValue("sn");
            Book b = new Book(name, sn, author, Double.parseDouble(price));
            System.out.println(b);
        }
    }
}
