package com.gft.sitron;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gft.Stax.*;

/**
 * Servlet implementation class test
 */
@WebServlet("/Cadastrar")
public class CadastrarTransacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarTransacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();

		// pegando os parâmetros
		String nomeTransacao = request.getParameter("nomeTransacao");
		String descTransacao = request.getParameter("descTransacao");
		String codSituacaoTransacao = request
				.getParameter("codSituacaoTransacao");
		String requestTransacao = request.getParameter("requestTransacao");
		String responseTransacao = request.getParameter("responseTransacao");

		// montandos os objeto transação
		Transacao transacao = new Transacao();
		transacao.setNomeTransacao(nomeTransacao);
		transacao.setDescTransacao(descTransacao);
		transacao.setCodSituacaoTransacao(codSituacaoTransacao);
		transacao.setRequestTransacao(requestTransacao);
		transacao.setResponseTransacao(responseTransacao);

		// salvando as transações
		TransacaoDao dao = new TransacaoDao();
		dao.adiciona(transacao);

		// enviando os dados para gerar o Indíce de Transações XML
		CreateXMLTransacao.criarXMLTransacao(
				request.getParameter("nomeTransacao"),
				request.getParameter("nomeTransacao"),
				request.getParameter("descTransacao"),
				request.getParameter("codSituacaoTransacao"),
				request.getParameter("requestTransacao"),
				request.getParameter("responseTransacao"));

		// enviando os dados para gerar o Request XML
		CreateXMLRequest.criarXMLRequest(request.getParameter("nomeTransacao"),
				request.getParameter("requestTransacao"));
		
		
		// enviando os dados para gerar o Response XML
		CreateXMLResponse.criarXMLResponse(request.getParameter("nomeTransacao"),
				request.getParameter("responseTransacao"));
		

		// retornando - transacao cadastrada
		
		
		out.println("<html>");
		out.println("<head><meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\"><link rel=\"stylesheet\"href=\"jquery-ui.css\"><script src=\"jquery-2.1.3.min.js\"></script><script src=\"jquery-ui.js\"></script></head>");
		out.println("<body>");
		out.println("<script>"
				+ " $(function() {$( '#dialog' ).dialog({title: 'Status', resizable: false,height:\"auto\",modal: true,buttons: {'Ok': function() {window.location.href='incluir_editar_consultar.jsp'},}});});"
				+ "</script>");
		out.println("<div id=\"dialog\">Transa&ccedil;&atilde;o " + transacao.getNomeTransacao()
				+ " adicionada com sucesso</div>");
		out.println("</body>");
		out.println("</html>");

	}

}
