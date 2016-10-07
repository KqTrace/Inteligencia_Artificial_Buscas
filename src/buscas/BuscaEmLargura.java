package buscas;

import java.util.LinkedList;
import java.util.Queue;

import nos.No;

public class BuscaEmLargura {
	
	// Fila de dados FiFo
	private Queue<No> filaNos;
	
	private String textResposta;
	
	private int valorBusca;
	
	public BuscaEmLargura(int valorBusca) {
		this.filaNos = new LinkedList<No>();
		this.valorBusca = valorBusca;
	}
	
	public boolean buscarResultado(No no) {
		
		if (isResultadoBusca(no)) {
			// Se for o objetivo
		} else {
			// Se n�o for o objetivo
			
			// Adicionar os n�s na fila
			this.filaNos.add(no.getNoEsquerda());
			this.filaNos.add(no.getNoDireita());	
			
			// Chama a fun��o de busca novamente
			buscarResultado(this.filaNos.poll());
		}
		
		return false;
	}
	
	public boolean isResultadoBusca(No no) {
		return no.getValor() == valorBusca;
	}
	
}
