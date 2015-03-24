package com.gft.sitron;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gft.Stax.UpdateXMLTransacao;

/**
 * Servlet implementation class UpdateTransacao
 */
@WebServlet("/UpdateTransacao")
public class UpdateTransacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTransacao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UpdateXMLTransacao u = new UpdateXMLTransacao(); 
		List <Transacao> listaupdate = new ArrayList<Transacao>();
		
		listaupdate = u.updateTransacao(request.getParameter("nomeTransacao"),
				request.getParameter("nomeTransacao"),
				request.getParameter("descTransacao"),
				request.getParameter("codSituacaoTransacao"),
				request.getParameter("requestTransacao"),
				request.getParameter("responseTransacao"));
		
		
		PrintWriter out = response.getWriter();
		
		// retornando - transacao cadastrada
				out.println("<html>");
				out.println("<head><meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\"><link rel=\"stylesheet\"href=\"jquery-ui.css\"><script src=\"jquery-2.1.3.min.js\"></script><script src=\"jquery-ui.js\"></script></head>");
				out.println("<body>");
				out.println("<script>"
						+ " $(function() {$( '#dialog' ).dialog({title: 'Status', resizable: false,height:\"auto\",modal: true,buttons: {'Ok': function() {window.location.href='" + request.getParameter("redirect") + "'},}});});"
						+ "</script>");
				out.println("<div id=\"dialog\">Transa&ccedil;&atilde;o " + request.getParameter("nomeTransacao")
						+ " atualizada com sucesso");
				out.println("</body>");
				out.println("</html>");
				
										
	}

}
