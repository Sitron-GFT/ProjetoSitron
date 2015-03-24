package com.gft.Stax;

import com.gft.config.*;


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

import com.gft.sitron.Transacao;


public class ListXMLTransacao {
	
	ConfiguracoesPath configpath = new ConfiguracoesPath();
	public List<Transacao> listTransacao() {

		
		SAXBuilder jdomBuilder = new SAXBuilder();
		Document jdomDocument;

		List<Transacao> listatransacoes = new ArrayList<Transacao>();
		try {
			jdomDocument = jdomBuilder.build(configpath.xmlSourceTransacao);			
			
			XPathFactory xFactory = XPathFactory.instance();

			XPathExpression<Element> exprnome = xFactory.compile(
					"//Transacao/Nome", Filters.element());
			XPathExpression<Element> exprdesc = xFactory.compile(
					"//Transacao/Descricao", Filters.element());
			XPathExpression<Element> exprsit = xFactory.compile(
					"//Transacao/Situacao", Filters.element());
			XPathExpression<Element> exprrequest = xFactory.compile(
					"//Transacao/Path_Request", Filters.element());
			XPathExpression<Element> exprresponse = xFactory.compile(
					"//Transacao/Path_Response", Filters.element());

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

				listatransacoes.add(t);
			}
		} catch (JDOMException | IOException e) {

			e.printStackTrace();
		}
		return listatransacoes;

	}

}





