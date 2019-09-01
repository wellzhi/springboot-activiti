package com.dapeng.flow.test.xmlparser;

import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;

public class test {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        FileReader fileReader = new FileReader("D:\\COMPANY\\dapeng-project\\flow\\src\\main\\java\\com\\dapeng\\flow\\test\\User.xml");
//        XMLStreamReader xtr = xmlInputFactory.createXMLStreamReader(fileReader);
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(fileReader);
        while (reader.hasNext()){
            XMLEvent en = reader.nextEvent();
            if (en.isStartElement()){
                StartElement se = en.asStartElement();
                if (se.getName().getLocalPart().equals("user")){
                    String id = se.getAttributeByName(new QName("id")).getValue();
                    System.out.println("id:"+id);
                }
                if(se.getName().getLocalPart().equals("name")){
                    Characters chs = reader.nextEvent().asCharacters();//读取<name>事件的下一个事件即是标记中的文本内容如“Jack”
                    System.out.println("name:"+chs);
                }
                if(se.getName().getLocalPart().equals("age")){
                    Characters chs = reader.nextEvent().asCharacters();//读取<name>事件的下一个事件即是标记中的文本内容如“Jack”
                    System.out.println("age:"+chs);
                }
            }
            if(en.isEndElement()){
                if( en.asEndElement().getName().getLocalPart().equals("user") ){
                    System.out.println("----------------------");
                }
            }

        }
//        while (xtr.hasNext()) {
//
//            int event = xtr.next();
//            if (event == XMLStreamConstants.START_ELEMENT) {
//                String localName = xtr.getLocalName();
//                System.out.println("开始节点：" + xtr.getLocalName());
//                if (localName.toString().equals("user")) {
//                    int attributeCount = xtr.getAttributeCount();
//                    for (int i = 0; i < attributeCount; i++) {
//                        System.out.println(xtr.getAttributeName(i) + ":" + xtr.getAttributeValue(i));
//                    }
//                }
//            } else if (event == XMLStreamConstants.END_ELEMENT) {
//                System.out.println("结束节点：" + xtr.getLocalName());
//            } else {
//
//            }
//        }
    }
}
