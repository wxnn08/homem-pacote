package jogo;

public class Labirinto {

	char[][] labirinto;
	private int dimensao; //Todos os labirintos serão matrizes quadradas, de acordo com essa linha. Pode mudar, obviamente
	
	public Labirinto(int dimensao) {
	
		this.setDimensao(dimensao);
		labirinto = new char[this.getDimensao()][this.getDimensao()];

		//TO DO: Montar o labirinto a partir de um arquivo
		
		for(int i = 0; i<this.getDimensao(); i++) {
			for (int j = 0; j<this.getDimensao(); j++) {
				labirinto[i][j] = '#';
			}
		}		
	}
	
	public void setDimensao(int n) {
		this.dimensao = n;
	}
	
	public int getDimensao() {
		return this.dimensao;
	}
	
	public void mostrarLabirinto() {
		
		for(int i = 0; i<this.getDimensao(); i++) {
			for (int j = 0; j<this.getDimensao(); j++) {
				System.out.print(this.labirinto[i][j]);
			}
			
			System.out.println();
		}
	}
	
}