# Aula 7 - Anotações

Método isDisponivel funcional vs iterativo:

```
	public boolean isDisponivel(Lugar lugarSelecionado) {
		//return ingressos.stream().map(Ingresso::getLugar).noneMatch(lugar -> lugar.equals(lugarSelecionado));
		
		for (Ingresso ingressoVendido : ingressos) {
			Lugar lugarVendido = ingressoVendido.getLugar();
			if (lugarVendido.equals(lugarSelecionado))
				return false;
		}
		
		return true;
	}
```