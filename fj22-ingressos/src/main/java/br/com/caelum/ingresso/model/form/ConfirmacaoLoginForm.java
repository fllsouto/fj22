package br.com.caelum.ingresso.model.form;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.caelum.ingresso.dao.UsuarioDao;
import br.com.caelum.ingresso.model.Permissao;
import br.com.caelum.ingresso.model.Token;
import br.com.caelum.ingresso.model.Usuario;

public class ConfirmacaoLoginForm {

	private Token token;
	private String password;
	private String confirmPassword;

	public ConfirmacaoLoginForm() {
	}

	public ConfirmacaoLoginForm(Token token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isValid() {
		return this.password.equals(this.confirmPassword);
	}

	public Usuario toUsuario(UsuarioDao dao, PasswordEncoder encoder) {
		String encryptedPassword = encoder.encode(this.password);

		String email = token.getEmail();

		Usuario usuario = dao.findByEmail(email).orElse(novoUsuario(email, encryptedPassword));

		usuario.setPassword(encryptedPassword);

		return usuario;
	}

	private Usuario novoUsuario(String email, String encryptedPassword) {
		Set<Permissao> permissoes = new HashSet();
		permissoes.add(Permissao.COMPRADOR);

		return new Usuario(email, encryptedPassword, permissoes);
	}
}
