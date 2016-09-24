package buscas;

import java.util.Stack;

import nos.No;

public class BuscaEmProfundidade {

	private Stack<No> pilhaNos;
	
	private String textoResposta;
	
	private int valorBusca;
	
	public BuscaEmProfundidade(int valorBusca) {
		this.pilhaNos = new Stack<>();
		
		this.valorBusca = valorBusca;
	}
	
	
	public boolean isResultadoBusca(No no) {
		return no.getValor() == valorBusca;
	}


	public boolean buscarResultado(No no) {
		this.pilhaNos.add(no);
		if (isResultadoBusca(no)) {
			// Exibir o caminho
			exibirResultadoPaternal(no);
			return true;
		} else {
			// Expandir os pr�ximos n�s (esquerda -> direita)
			if (no.getNoEsquerda() != null && this.buscarResultado(no.getNoEsquerda())) { 
				return true;
			}
			
			if (no.getNoDireita() != null && this.buscarResultado(no.getNoDireita())) {
				return true;
			}
		}
		this.pilhaNos.pop();
		return false;
	}
	
	public void exibirResultadoPaternal(No no) {
		String retorno = "";
		
		No noValor = no;
		
		retorno += noValor.getValor();
		
		while (noValor.getNoPai() != null) {
			noValor = noValor.getNoPai();
			retorno = noValor.getValor() + " " + retorno;
		}
		this.textoResposta = retorno;
	}
	
	
	public void exibirTextoResultado() {
		if (this.textoResposta != null) {
			System.out.println("O caminho percorrido ser�: " + this.textoResposta);
		} else {
			System.out.println("O valor " + this.valorBusca + " n�o foi encontrado.");
		}
	}
	
	
}
