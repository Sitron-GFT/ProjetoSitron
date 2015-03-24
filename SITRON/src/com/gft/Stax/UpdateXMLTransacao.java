package com.gft.Stax;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.gft.config.*;
import com.gft.sitron.Transacao;

public class UpdateXMLTransacao {
	ConfiguracoesPath configpath = new ConfiguracoesPath();


	public List<Transacao> updateTransacao(String ID, String NomeTransacao, String DescTransacao, String CodSituacaoTransacao, String requestTransacao, String responseTransacao) {
		File xml = new File(configpath.xmlSourceTransacao);
		File xmlrequest = new File(configpath.xmlSourceRequest+"\\"+ ID +"_req.xml");
		File xmlresponse = new File(configpath.xmlSourceResponse+"\\"+ ID +"_resp.xml");
		
		
		List<Transacao> listupdate = new ArrayList<Transacao>();

		try {
			
		//Atualizacao do Transacao.xml
			Document doc = (Document) new SAXBuilder().build(xml);
			Element rootNode = doc.getRootElement();

			List<Element> list = rootNode.getChildren("Transacao");
			
			//Iteracao, atualizando de acordo com a igualdade ded ID
			for (int i = 0; i < list.size(); i++) {
				Element node = (Element) list.get(i);
				if (node.getAttributeValue("ID").equals(ID)) {
					node.getChild("Nome").setText(NomeTransacao);
					node.getChild("Descricao").setText(DescTransacao);
					node.getChild("Situacao").setText(CodSituacaoTransacao);
				}
			}
			
			XMLOutputter xmlOut = new XMLOutputter();
			xmlOut.setFormat(Format.getPrettyFormat());
			//System.out.println(configpath.xmlSourceTransacao);
			xmlOut.output(doc,new FileWriter(configpath.xmlSourceTransacao));
			
			
		//Atualizacao do _req.xml e _resp.xml

			Document docrequest = (Document) new SAXBuilder().build(xmlrequest);
			Element rootNoderequest = docrequest.getRootElement();
			
				if (rootNoderequest.getAttributeValue("ID").equals(ID)) {	
					CDATA cdatarequest= new CDATA(requestTransacao);
					rootNoderequest.setContent(cdatarequest);
				}
			
			Document docresponse = (Document) new SAXBuilder().build(xmlresponse);
			Element rootNoderesponse = docresponse.getRootElement();
			
				if (rootNoderesponse.getAttributeValue("ID").equals(ID)) {
					CDATA cdataresponse= new CDATA(requestTransacao);
					rootNoderesponse.setContent(cdataresponse);
				}		
				

			XMLOutputter xmlOutRequest = new XMLOutputter();
			xmlOutRequest.setFormat(Format.getPrettyFormat());
			xmlOutRequest.output(docrequest,new FileWriter(configpath.xmlSourceRequest+"\\"+ ID +"_req.xml"));
			
			XMLOutputter xmlOutResponse = new XMLOutputter();
			xmlOutResponse.setFormat(Format.getPrettyFormat());
			System.out.println(configpath.xmlSourceRequest+"\\"+ ID +"_resp.xml");
			xmlOutResponse.output(docresponse,new FileWriter(configpath.xmlSourceResponse+"\\"+ ID +"_resp.xml"));
			
			
			} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}

		return listupdate;
	}

}
