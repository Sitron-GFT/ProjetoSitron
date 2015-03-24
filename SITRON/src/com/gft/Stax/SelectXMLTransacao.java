package com.gft.Stax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import com.gft.config.ConfiguracoesPath;
import com.gft.sitron.Transacao;
	  

public class SelectXMLTransacao {

	public List<Transacao> selectTransacao(String ID){
		
			ConfiguracoesPath configpath = new ConfiguracoesPath();
	        SAXBuilder jdomBuilder = new SAXBuilder();
	        Document jdomDocument;
	        
	        List<Transacao> links = new ArrayList<Transacao>(); 
	        try{
	        	
			jdomDocument = jdomBuilder.build(configpath.xmlSourceTransacao);
	        XPathFactory xFactory = XPathFactory.instance();
	        
			XPathExpression<Element> exprnome = xFactory.compile(
					"//Transacao[@ID='" + ID + "']/Nome", Filters.element());
			XPathExpression<Element> exprdesc = xFactory.compile(
					"//Transacao[@ID='" + ID + "']/Descricao", Filters.element());
			XPathExpression<Element> exprsit = xFactory.compile(
					"//Transacao[@ID='" + ID + "']/Situacao", Filters.element());
			XPathExpression<Element> exprrequest = xFactory.compile(
					"//Transacao[@ID='" + ID + "']/Path_Request", Filters.element());
			XPathExpression<Element> exprresponse = xFactory.compile(
					"//Transacao[@ID='" + ID + "']/Path_Response", Filters.element());
			
        
			List<Element> listnome = exprnome.evaluate(jdomDocument);
			List<Element> listdesc = exprdesc.evaluate(jdomDocument);
			List<Element> listsit = exprsit.evaluate(jdomDocument);
			List<Element> listrequest = exprrequest.evaluate(jdomDocument);
			List<Element> listresponse = exprresponse.evaluate(jdomDocument);

	        
			for (int i = 0; i < listnome.size(); i++) {
				Transacao t = new Transacao();
				t.setNomeTransacao(listnome.get(i).getValue());
				t.setDescTransacao(listdesc.get(i).getValue());
				t.setCodSituacaoTransacao(listsit.get(i).getValue());
				t.setRequestTransacao(listrequest.get(i).getValue());
				t.setResponseTransacao(listresponse.get(i).getValue());

				links.add(t);
			}

			} catch (JDOMException | IOException e) {
		
				e.printStackTrace();
			}
			return links;
			
/*	        
		        System.out.println(links.get(0).getValue()); //nome
		        System.out.println(links.get(1).getValue()); //descricao
		        System.out.println(links.get(2).getValue()); //situacao
		        System.out.println(links.get(3).getValue()); //path_request
		        System.out.println(links.get(4).getValue()); //path_response
*/
	    }
	
	
	public List<Element> selectRequest(String ID){

		ConfiguracoesPath configpath = new ConfiguracoesPath();
		SAXBuilder jdomBuilder = new SAXBuilder();
		Document jdomDocument;
		List<Element> listrequest = new ArrayList<Element>();
		try{

			jdomDocument = jdomBuilder.build(configpath.xmlSourceRequest+"\\"+ ID +"_req.xml");
			System.out.println(configpath.xmlSourceRequest+"\\"+ID+"_req.xml");
			XPathFactory xFactory = XPathFactory.instance();

			XPathExpression<Element> exprrequest = xFactory.compile(
					"//Request[@ID='"+ID+"']", Filters.element());

		listrequest = exprrequest.evaluate(jdomDocument);
		System.out.println(listrequest.get(0).getValue());

		} catch (JDOMException | IOException e) {

			e.printStackTrace();
		}
		return listrequest;

		/*	        
	        System.out.println(links.get(0).getValue()); //nome
	        System.out.println(links.get(1).getValue()); //descricao
	        System.out.println(links.get(2).getValue()); //situacao
	        System.out.println(links.get(3).getValue()); //path_request
	        System.out.println(links.get(4).getValue()); //path_response
		 */
	}
	
	public List<Element> selectResponse(String ID){

		ConfiguracoesPath configpath = new ConfiguracoesPath();
		SAXBuilder jdomBuilder = new SAXBuilder();
		Document jdomDocument;
		List<Element> listresponse = new ArrayList<Element>();
		try{

			jdomDocument = jdomBuilder.build(configpath.xmlSourceResponse+"\\"+ID+"_resp.xml");
			System.out.println(configpath.xmlSourceResponse+"\\"+ID+"_resp.xml");
			XPathFactory xFactory = XPathFactory.instance();

			XPathExpression<Element> exprrequest = xFactory.compile(
					"//Response[@ID='"+ID+"']", Filters.element());

			listresponse = exprrequest.evaluate(jdomDocument);
		System.out.println(listresponse.get(0).getValue());

		} catch (JDOMException | IOException e) {

			e.printStackTrace();
		}
		return listresponse;

		/*	        
	        System.out.println(links.get(0).getValue()); //nome
	        System.out.println(links.get(1).getValue()); //descricao
	        System.out.println(links.get(2).getValue()); //situacao
	        System.out.println(links.get(3).getValue()); //path_request
	        System.out.println(links.get(4).getValue()); //path_response
		 */
	}


}

