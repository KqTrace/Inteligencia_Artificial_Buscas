package buscas;

import java.util.LinkedList;
import java.util.Queue;

import nos.No;

public class BuscaEmLargura extends Busca {
	
	// Fila de dados FiFo
	private Queue<No> filaNos;
	
	private String textoResposta;
		
	public BuscaEmLargura(int valorBusca) {
		this.filaNos = new LinkedList<No>();
		this.setValorBusca(valorBusca);
	}
	
	public boolean buscarResultado(No no) {
		if (isResultadoBusca(no)) {
			// Se for o objetivo
			obterResultadoPaternal(no);
			return true;
		} else {
			// Se n�o for o objetivo
			
			// Adicionar os n�s na fila
			if (no.getNoEsquerda() != null) {
				this.filaNos.add(no.getNoEsquerda());
			}
			
			if (no.getNoDireita() != null) {
				this.filaNos.add(no.getNoDireita());
			}
			
			No noPonta = this.filaNos.poll();
			if (noPonta != null && buscarResultado(noPonta)) {
				return true;
			}
		}
		return false;
	}
	
}
