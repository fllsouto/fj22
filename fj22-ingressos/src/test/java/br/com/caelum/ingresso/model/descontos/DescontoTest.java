package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class DescontoTest {
	
	private Sessao sessao;

	@Before
	public void setup() {
		Sala sala = new Sala("Sala 3D", new BigDecimal("20.0"));
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("10.0"));
		this.sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);

	}

	@Test
	public void naoDeveConcederDescontoParaIngressoNormal() {
		Ingresso ingressoSemDesconto = new Ingresso(this.sessao, new SemDesconto());
		
		BigDecimal precoEsperado = sessao.getPreco();
		
		Assert.assertEquals(precoEsperado, ingressoSemDesconto.getPreco());
	}
	
	@Test
	public void deveConcederDescontoDe30PorcentoParaIngressosDeClientesDeBancos() {
		Ingresso ingressoSemDesconto = new Ingresso(this.sessao, new DescontoParaBancos());
		
		BigDecimal precoEsperado = sessao.getPreco()
				.multiply(new BigDecimal("0.3")).setScale(2, RoundingMode.HALF_UP);
		
		Assert.assertEquals(precoEsperado, ingressoSemDesconto.getPreco());
	}
	
	@Test
	public void deveConcederDescontoDe50PorcentoParaIngressosDeEstudante() {
		Ingresso ingressoSemDesconto = new Ingresso(this.sessao, new DescontoParaEsturantes());
		
		BigDecimal precoEsperado = sessao.getPreco()
				.multiply(new BigDecimal("0.5")).setScale(2, RoundingMode.HALF_UP);
		
		Assert.assertEquals(precoEsperado, ingressoSemDesconto.getPreco());
	}

}
