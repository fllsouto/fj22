package br.com.caelum.ingresso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.helper.TokenHelper;
import br.com.caelum.ingresso.mail.EmailNovoUsuario;
import br.com.caelum.ingresso.mail.Mailer;
import br.com.caelum.ingresso.model.Token;

@Controller
public class UsuarioController {
	
	@Autowired
	private Mailer mailer;
	
	@Autowired
	private TokenHelper tokenHelper;
	
	@GetMapping("/usuario/request")
	public ModelAndView formSolicitacaoAcesso() {
		return new ModelAndView("usuario/form-email");
	}
	
	@PostMapping("/usuario/request")
	public ModelAndView solicitacaoDeAceso(String email) {
		ModelAndView modelAndView = new ModelAndView("usuario/adicionado");
		Token token = tokenHelper.generateFrom(email);
		
		mailer.send(new EmailNovoUsuario(token));
		
		return modelAndView;
	}
}
