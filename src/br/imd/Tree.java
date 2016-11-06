package br.imd;

import java.awt.Graphics;

public class Tree {
	
	private No root;
	private Tree leftTree;
	private Tree rightTree;
	public boolean isRoot;
	/**
	 * Classe construtora de uma arvore
	 */
	public Tree(){
		root = null;
		leftTree = null;
		rightTree = null;
	}
	/**
	 * Metodo para retorno de uma raiz
	 * @return raiz
	 */
	public No getRoot() {
		return root;
	}
	/**
	 * Metodo para setar valor da raiz
	 * @param root raiz do no
	 */
	public void setRoot(No root) {
		this.root = root;
	}
	/**
	 * Metodo para retornar a arvore a esquerda
	 * @return arvore a esquerda
	 */
	public Tree getLeftTree() {
		return leftTree;
	}
	/**
	 * Metodo para setar arvore a esquerda
	 * @param leftTree 
	 */
	public void setLeftTree(Tree leftTree) {
		this.leftTree = leftTree;
	}
	/**
	 * Metodo para retornar arvore a direita
	 * @return arvore a direita
	 */
	public Tree getRightTree() {
		return rightTree;
	}
	/**
	 * Metodo para setar arvore a esquerda
	 * @param rightTree 
	 */
	public void setRightTree(Tree rightTree) {
		this.rightTree = rightTree;
	}
	/**
	 * Metodo para inserir aluno no node
	 * @param matricula valor inteiro com a matricula do aluno
	 * @param nome valor String com o nome do aluno
	 */
	public void insereAluno(int matricula, String nome) {
        Aluno aluno = new Aluno(matricula, nome);
        No no = new No(aluno);
        inserir(no);
    }
	/**
	 * Metodo privado para inserir no
	 * @param no
	 */
	private void inserir(No no) {
		if(this.root == null){
		   this.root = no;
		   isRoot = true;
		}
		else {
			if (no.getAluno().getMatricula() > root.getAluno().getMatricula()){
				if (rightTree == null){
					rightTree = new Tree();
					
					// System.out.println("No " + no.getAluno().getNome() + " inserido a direita de " + root.getAluno().getNome());
				}
				this.rightTree.inserir(no);
			}
			else if (no.getAluno().getMatricula() < root.getAluno().getMatricula()){
				if (leftTree == null){
					leftTree = new Tree();
					
					// System.out.println("No " + no.getAluno().getNome() + " inserido a esquerda de " + root.getAluno().getNome());
				}
				this.leftTree.inserir(no);
			}
		}
		
	}
	/**
	 * 
	 * @param no
	 */
	private void visita(No no) {
		System.out.print(no.getAluno().getMatricula() + " ");
	}
	/**
	 * Metodo de busca
	 * @param matricula parametro de busca
	 * @return valor da raiz
	 */
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
	/**
	 * Metodo para percorrer a arvore no percurso In-Ordem
	 */
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
	/**
	 * Metodo para percorrer a arvore em percurso Pre-Ordem
	 */
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
	/**
	 * Metodo para percorrer a arvore em percursso Por-Ordem
	 */
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
	/**
	 * Metodo para desenhar no
	 * @param g
	 * @param screenWidth
	 * @param screenHeight
	 */
	public void desenharNo(Graphics g, int screenWidth, int screenHeight) {
		g.fillOval(screenWidth / 2 - 50 / 2, screenHeight + 10, 50, 50);
	}
}
