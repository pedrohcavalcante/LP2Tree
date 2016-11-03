package br.imd;

public class Tree {
	
	private No root;
	private Tree leftTree;
	private Tree rightTree;
	
	public Tree(){
		root = null;
		leftTree = null;
		rightTree = null;
	}
	
	public void insereAluno(int matricula, String nome) {
        Aluno aluno = new Aluno(matricula, nome);
        No no = new No(aluno);
        inserir(no);
    }

	private void inserir(No no) {
		if(this.root == null){
		   this.root = no;
		}
		else {
			if (no.getAluno().getMatricula() > root.getAluno().getMatricula()){
				if (rightTree == null){
					rightTree = new Tree();
					
					System.out.println("No " + no.getAluno().getNome() + " inserido a direita de " + root.getAluno().getNome());
				}
				this.rightTree.inserir(no);
			}
			else if (no.getAluno().getMatricula() < root.getAluno().getMatricula()){
				if (leftTree == null){
					leftTree = new Tree();
					
					System.out.println("No " + no.getAluno().getNome() + " inserido a esquerda de " + root.getAluno().getNome());
				}
				this.leftTree.inserir(no);
			}
		}
		
	}
	
	private void visita(No no) {
		System.out.print(no.getAluno().getMatricula() + " ");
	}
	
	public No busca(int matricula) {
		
		// Chegou ao fim de um caminho e nao achou
		if (matricula != root.getAluno().getMatricula() && leftTree == null && rightTree == null) {
			
			return null;
		}
		// Achou
		else if (matricula == root.getAluno().getMatricula()) {
			
			return root;
		}
		// Nao achou e procura na arvore direita
		else if (matricula > root.getAluno().getMatricula()) {
			
			return rightTree.busca(matricula);
		}
		// Nao achou e procura na arvore esquerda
		else {
			
			return leftTree.busca(matricula);
		}
	}
	
	public void percorrerInOrdem() {
		// Visita arvore esquerda
		if (this.leftTree != null) {
			leftTree.percorrerInOrdem();
		}
		
		// Visita no
		visita(this.root);
		
		// Visita arvore direita
		if (this.rightTree != null) {
			rightTree.percorrerInOrdem();
		}
	}
	
	public void percorrerPreOrdem() {
		// Visita no
		visita(this.root);
		
		// Visita arvore esquerda
		if (this.leftTree != null) {
			leftTree.percorrerPreOrdem();
		}
		
		// Visita arvore direita
		if (this.rightTree != null) {
			rightTree.percorrerPreOrdem();
		}
	}
	
	public void percorrerPosOrdem() {
		// Visita arvore esquerda
		if (this.leftTree != null) {
			leftTree.percorrerPosOrdem();
		}

		// Visita arvore direita
		if (this.rightTree != null) {
			rightTree.percorrerPosOrdem();
		}
		
		// Visita no
		visita(this.root);
	}
}
