package com.gft.sitron;

public class Transacao {
	
	private String nomeTransacao;
	private String descTransacao;
	private String codSituacaoTransacao;
	private String requestTransacao;
	private String responseTransacao;
	
	
	
	public String getNomeTransacao() {
		return nomeTransacao;
	}
	public void setNomeTransacao(String nomeTransacao) {
		this.nomeTransacao = nomeTransacao;
	}
		
	public String getDescTransacao() {
		return descTransacao;
	}
	public void setDescTransacao(String descTransacao) {
		this.descTransacao = descTransacao;
	}
		
	public String getCodSituacaoTransacao() {
		return codSituacaoTransacao;
	}
	public void setCodSituacaoTransacao(String codSituacaoTransacao) {
		this.codSituacaoTransacao = codSituacaoTransacao;
	}
		
	public String getRequestTransacao() {
		return requestTransacao;
	}
	public void setRequestTransacao(String requestTransacao) {
		this.requestTransacao = requestTransacao;
	}
		
	public String getResponseTransacao() {
		return responseTransacao;
	}
	public void setResponseTransacao(String responseTransacao) {
		this.responseTransacao = responseTransacao;
	}
	
}
