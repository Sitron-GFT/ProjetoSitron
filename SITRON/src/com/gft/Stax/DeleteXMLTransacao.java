package com.gft.Stax;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.gft.config.*;

public class DeleteXMLTransacao {
	ConfiguracoesPath configpath = new ConfiguracoesPath();
	File xml = new File(configpath.xmlSourceTransacao);	
	
	public List<Element> deleteTransacao(String ID) {
	
	       List<Element> list = new ArrayList<Element>(); 
      
			try {
				 		
				Document doc = (Document) new SAXBuilder().build(xml);
				Element rootNode = doc.getRootElement();
				list = rootNode.getChildren("Transacao");
				
				for (int i = 0; i < list.size(); i++) {
					Element node = (Element) list.get(i);
					if (node.getAttributeValue("ID").equals(ID)){
						rootNode.removeContent(node);
					}
					
					XMLOutputter xmlOut = new XMLOutputter();
					xmlOut.setFormat(Format.getPrettyFormat());
					xmlOut.output(doc, new FileWriter(configpath.xmlSourceTransacao));
				

				}
			} catch (IOException io) {
				System.out.println(io.getMessage());
			} catch (JDOMException jdomex) {
				System.out.println(jdomex.getMessage());
			}
			
			return list;
		}

	public void deleteXMLRequestResponse(String ID) {
		try {
			File fileRequest = new File(configpath.xmlSourceRequest +"\\"+ ID + "_req.xml");
			File fileResponse = new File(configpath.xmlSourceResponse +"\\"+ ID + "_resp.xml");

			if (fileRequest.delete() && fileResponse.delete()) {
				System.out.println("Arquivo deletado com sucesso!");
			} else {
				System.out.println("Arquivo não foi deletado !!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	}




