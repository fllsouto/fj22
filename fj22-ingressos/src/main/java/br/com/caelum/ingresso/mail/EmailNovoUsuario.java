package br.com.caelum.ingresso.mail;

import br.com.caelum.ingresso.model.Token;

public class EmailNovoUsuario implements Email {

	private Token token;
	
	public EmailNovoUsuario(Token token) {
		super();
		this.token = token;
	}

	@Override
	public String getTo() {
		return token.getEmail();
	}
	
	@Override
	public String getBody() {
		StringBuilder body = new StringBuilder("<html>");
		body.append("<body>");
		body.append("<h2>Bem vindo</h2>");
		body.append(String.format("Acesse o <a href=%s>link</a> para criar seu login"
				+ " no sistema de ingressos", makeURL()));
		body.append("</body>");
		body.append("</html>");
		
		return body.toString();
	}
	
	@Override
	public String getSubject() {
		return "Cadastro Sistema de Ingressos";
	}

	private String makeURL() {
		return String.format("http://localhost:8080/usuario/validate?uuid=%s", token.getUuid());
	}
}
