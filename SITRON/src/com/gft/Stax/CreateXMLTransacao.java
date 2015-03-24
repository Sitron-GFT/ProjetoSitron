package com.gft.Stax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.gft.config.*;


public class CreateXMLTransacao {
	
	public static void criarXMLTransacao(String ID, String Nome,
			String Descricao, String Situacao, String Request, String Response) {
		
		ConfiguracoesPath configpath = new ConfiguracoesPath();	
		File f = new File(configpath.xmlSourceTransacao);
		
		if(f.exists()){
			
			try {
				
				String filepath = configpath.xmlSourceTransacao;
				
				DocumentBuilderFactory docFactory2 = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder2 = docFactory2.newDocumentBuilder();
				Document doc2 = docBuilder2.parse(filepath);
					
							
				// Get the root element
				Node transacoes = doc2.getFirstChild();

				// append a new node to Transacoes
				Element novatransacao = doc2.createElement("Transacao");
						
				//novatransacao.appendChild(doc.createTextNode(""));
				transacoes.appendChild(novatransacao);
		 
				//Cria o atributo identificador da Transação
				Attr attr = doc2.createAttribute("ID");
				attr.setValue(ID);
				novatransacao.setAttributeNode(attr);
							
				//Cria os elementos(filhos) da Transaçao
				Element nome = doc2.createElement("Nome");
				nome.appendChild(doc2.createTextNode(Nome));
				novatransacao.appendChild(nome);
						
				Element descricao = doc2.createElement("Descricao");
				descricao.appendChild(doc2.createTextNode(Descricao));
				novatransacao.appendChild(descricao);
		 
				Element situacao = doc2.createElement("Situacao");
				situacao.appendChild(doc2.createTextNode(Situacao));
				novatransacao.appendChild(situacao);
				
				System.out.println(configpath.xmlSourceRequest+"\\"+ID+"_req.xml");
				
				Element path_request = doc2.createElement("Path_Request");
				path_request.appendChild(doc2.createTextNode(configpath.xmlSourceRequest+"\\"+ID+"_req.xml"));
				novatransacao.appendChild(path_request);
		 
				Element path_response = doc2.createElement("Path_Response");
				path_response.appendChild(doc2.createTextNode(configpath.xmlSourceResponse+"\\"+ID+"_resp.xml"));			
				novatransacao.appendChild(path_response);
			
		 
				// Escreve o conteúdo da Transação dentro do arquivo XML 
				TransformerFactory transformerFactory2 = TransformerFactory.newInstance();
				Transformer transformer2 = transformerFactory2.newTransformer();
				DOMSource source2 = new DOMSource(doc2);
				StreamResult result2 = new StreamResult(new File(filepath));
				transformer2.transform(source2, result2);
		 
				System.out.println("Transação adicionada");
				
					 
			   } catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			   } catch (TransformerException tfe) {
				tfe.printStackTrace();
			   } catch (IOException ioe) {
				ioe.printStackTrace();
			   } catch (SAXException sae) {
				sae.printStackTrace();
			   }
			
						
		} else {
			
			try {
				 
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

											
				// root elements
				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("Transacoes");
				doc.appendChild(rootElement);
		 
				// staff elements
				Element staff = doc.createElement("Transacao");
				rootElement.appendChild(staff);
		 
				//Cria o atributo identificador da Transação
				Attr attr = doc.createAttribute("ID");
				attr.setValue(ID);
				staff.setAttributeNode(attr);
		 			 
				//Cria os elementos(filhos) da Transaçao
				Element nome = doc.createElement("Nome");
				nome.appendChild(doc.createTextNode(Nome));
				staff.appendChild(nome);
		 
				Element descricao = doc.createElement("Descricao");
				descricao.appendChild(doc.createTextNode(Descricao));
				staff.appendChild(descricao);
		 
				Element situacao = doc.createElement("Situacao");
				situacao.appendChild(doc.createTextNode(Situacao));
				staff.appendChild(situacao);
		 
				Element path_request = doc.createElement("Path_Request");
				path_request.appendChild(doc.createTextNode(configpath.xmlSourceRequest+"\\"+ID+"_req.xml"));
				staff.appendChild(path_request);
		 
				Element path_response = doc.createElement("Path_Response");
				path_response.appendChild(doc.createTextNode(configpath.xmlSourceResponse+"\\"+ID+"_resp.xml"));
				staff.appendChild(path_response);
				
				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(configpath.xmlSourceTransacao));
		 
				transformer.transform(source, result);
		 
				System.out.println("Transação Criada");
		 
			  } catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			  } catch (TransformerException tfe) {
				tfe.printStackTrace();
			  }
			
						
			}
		}		
}
				

