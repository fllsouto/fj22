package br.com.caelum.ingresso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

	@GetMapping("/usuario/request")
	public ModelAndView formSolicitacaoAcesso() {
		return new ModelAndView("usuario/form-email");
	}
	
	@PostMapping("/uruario/request")
	public ModelAndView solicitacaoDeAceso(String email) {
		ModelAndView modelAndView = new ModelAndView("usuario/adicionado");
		
		return modelAndView;
	}
}
