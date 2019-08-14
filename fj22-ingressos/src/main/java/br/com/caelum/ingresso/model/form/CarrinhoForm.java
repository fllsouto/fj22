package br.com.caelum.ingresso.model.form;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.caelum.ingresso.dao.LugarDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;

public class CarrinhoForm {

	private List<Ingresso> ingressos = new ArrayList();

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}
	
	public List<Ingresso> toIngressos(SessaoDao sessaoDao, LugarDao lugarDao) {
		return this.ingressos.stream().map(ingresso -> {
			System.out.println("Ingresso: " + ingresso);
			Sessao sessao = ingresso.getSessao();
			System.out.println("Sessao antes: " + sessao);
			sessao = sessaoDao.findOne(sessao.getId());
			System.out.println("Sessao depois: " + sessao);
			Lugar lugar = ingresso.getLugar();
			System.out.println("Lugar antes: " + lugar);
			lugar = lugarDao.findOne(lugar.getId());			
			System.out.println("Lugar depois: " + lugar);
			TipoDeIngresso tipoDeIngresso = ingresso.getTipoDeIngresso();
			System.out.println("------------------------");
			return new Ingresso(sessao, tipoDeIngresso, lugar);
		}).collect(Collectors.toList());
	}
}
