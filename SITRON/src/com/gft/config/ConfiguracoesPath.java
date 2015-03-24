package com.gft.config;

import java.io.File;

public class ConfiguracoesPath {

		//Caminho usado para gravacao e leitura dentro do Tomcat
/*		String relxmlSource = "\\SITRON\\BD";
		File catalinaBase = new File( System.getProperty( "catalina.base" ) ).getAbsoluteFile();
		File propertyFile = new File( catalinaBase, "/wtpwebapps" );

		public String xmlSourceTransacao = (propertyFile + relxmlSource + "\\Index\\Transacoes.xml");
		public String xmlSourceRequest = (propertyFile + relxmlSource + "\\Request");
		public String xmlSourceResponse = (propertyFile + relxmlSource + "\\Response");
		*/
	
		//Caminho usado para leitura e gravacao dentro do Workspace
		String relxmlSource = "\\WebContent\\BD";
		//File systempathBase = new File( System.getProperty( "user.dir" ) ).getAbsoluteFile();
		String systempathBase = "C:\\Users\\ceda\\workspace\\SITRON";
		
		public String xmlSourceTransacao = (systempathBase+relxmlSource + "\\Index\\Transacoes.xml");
		public String xmlSourceRequest = (systempathBase+relxmlSource + "\\Request");
		public String xmlSourceResponse = (systempathBase+relxmlSource + "\\Response");
}

