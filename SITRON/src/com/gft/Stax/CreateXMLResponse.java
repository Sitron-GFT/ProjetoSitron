package com.gft.Stax;

import com.gft.config.*;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXMLResponse {
	
	
	public static void criarXMLResponse(String ID, String Response) {
		ConfiguracoesPath configpath = new ConfiguracoesPath();
		
		//O código comentado abaixo adiciona outra Request dentro do mesmo arquivo, porém neste caso não é aplicado.
		
		/*try {
			
			String filepath = "C:/Users/ceda/workspace/ProjetoTest/WebContent/BD/Response/Responses.xml";
			DocumentBuilderFactory docFactory2 = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder2 = docFactory2.newDocumentBuilder();
			Document doc2 = docBuilder2.parse(filepath);
				
						
			// Get the root element
			Node rootElement = doc2.getFirstChild();

			// append a new node to Transacoes
			Element novorequest = doc2.createElement("Response");
			
			//novatransacao.appendChild(doc.createTextNode(""));
			rootElement.appendChild(novorequest);
	 			
			//Cria o atributo identificador da Transação
			Attr attr = doc2.createAttribute("ID");
			attr.setValue(ID);
			novorequest.setAttributeNode(attr);
			
			//Cria o conteúdo do Request
			rootElement.appendChild(doc2.createTextNode("Conteúdo do Response2"));
								
				 
			// Escreve o conteúdo da Transação dentro do arquivo XML 
			TransformerFactory transformerFactory2 = TransformerFactory.newInstance();
			Transformer transformer2 = transformerFactory2.newTransformer();
			DOMSource source2 = new DOMSource(doc2);
			StreamResult result2 = new StreamResult(new File(filepath));
			transformer2.transform(source2, result2);
	 
			System.out.println("Transação add !");
			
				 
		   } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		   } catch (TransformerException tfe) {
			tfe.printStackTrace();
		   } catch (IOException ioe) {
			ioe.printStackTrace();
		   } catch (SAXException sae) {
			sae.printStackTrace();
		   }
			  */ 
		   		
		try {
			 
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

											
				// root elements
				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("Response");
				doc.appendChild(rootElement);
		 
				//Cria o atributo identificador da Transação
				Attr attr = doc.createAttribute("ID");
				attr.setValue(ID);
				rootElement.setAttributeNode(attr);
				
				//Cria CDATA
				
				CDATASection cdata = doc.createCDATASection(Response);
						
				//Cria o conteúdo do Request
				
				rootElement.appendChild(cdata);
						 			 							
				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(configpath.xmlSourceResponse+"\\"+ID+"_resp.xml"));
		 
				transformer.transform(source, result);
		 
				System.out.println("Response Create");
		 
			  } catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			  } catch (TransformerException tfe) {
				tfe.printStackTrace();
			  }
		
		
			}
	
	
}
