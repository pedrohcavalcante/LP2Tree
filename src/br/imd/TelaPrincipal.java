package br.imd;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	private Tree arvore = new Tree();
	int noAltura = 40;
	int noLargura = 80;
	
	private MyCanvas canvas = new MyCanvas();
	
	JMenuBar setJMenu = new JMenuBar();
	JMenu options = new JMenu("Opções");
	JMenu ordenar = new JMenu("Imprimir Árvore na linha de comando");
	JMenuItem addElement = new JMenuItem("Adicionar elemento");
	JMenuItem searchElement = new JMenuItem("Buscar elemento");
	JMenuItem generateTree = new JMenuItem("Gerar arvore automatica");	
	JMenuItem preOrder = new JMenuItem("Pre-Ordem");
	JMenuItem porOrder = new JMenuItem("Pós-Ordem");
	JMenuItem inOrder = new JMenuItem("In-Ordem");
	/**
	 * Tela principal onde sao instanciados os botoes e onde e feito o desenho da arvore
	 */
	public TelaPrincipal() {		
		
		setJMenu.add(options);
		options.add(addElement);
		options.add(searchElement);
		options.add(generateTree);
		setJMenu.add(ordenar);
		ordenar.add(preOrder);
		ordenar.add(porOrder);
		ordenar.add(inOrder);
		
		add(setJMenu);
		
		setJMenuBar(setJMenu);
		setTitle("Janela 2");
		setSize(screenSize.width, screenSize.height);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setLayout(new BorderLayout());
		add("Center", canvas);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		/**
		 * Método onde e implementada a acao dos botoes
		 */
		
		addElement.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nome = JOptionPane.showInputDialog(null, "Insira nome");
				
				// TODO: tratar erro de quando o input for textual e nao numerico
				int matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira matricula"));
								
				arvore.insereAluno(matricula, nome);
				
				Graphics g = canvas.getGraphics();				
				desenharArvore(arvore, 0, screenSize.width, 0, g);
			}
		});
		
		searchElement.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String matricula = JOptionPane.showInputDialog(null, "Insira matricula a ser buscada");
				
				No resultado = arvore.busca(Integer.parseInt(matricula));
				
				// Nao achou
				if (resultado == null) {
					JOptionPane.showMessageDialog(null, "Matricula nao encontrada");
				}
				else {
					JOptionPane.showMessageDialog(null, "Matricula encontrada.\nAluno: " + resultado.getAluno().getNome());
				}	
			}
		});
		
		generateTree.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Nivel 1
				arvore.insereAluno(200, "Tristram"); 
				// Nivel 2
				arvore.insereAluno(100, "Blanche"); 
				arvore.insereAluno(300, "Poe");
				// Nivel 3
				arvore.insereAluno(50, "Wilson");
				arvore.insereAluno(150, "Jannet");
				arvore.insereAluno(250, "Brad");
				arvore.insereAluno(350, "Smith");
				// Nivel 4
				arvore.insereAluno(45, "Howard");
				arvore.insereAluno(55, "Peter");
				arvore.insereAluno(145, "Holly");
				arvore.insereAluno(155, "Blue");
				arvore.insereAluno(245, "Misty");
				arvore.insereAluno(255, "Roocker");
				arvore.insereAluno(345, "Lyra");
				arvore.insereAluno(355, "Pantalaimon");
				
				Graphics g = canvas.getGraphics();				
				desenharArvore(arvore, 0, screenSize.width, 0, g);
			}
		});
		
		preOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("Pre ordem: ");
				arvore.percorrerPreOrdem();
				System.out.println("");
			}
		});
		
		porOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("Pos ordem: ");
				arvore.percorrerPosOrdem();
				System.out.println("");
			}
		});
		
		inOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("In ordem: ");
				arvore.percorrerInOrdem();
				System.out.println("");
			}
		});
		
	}	
	
	/**
	 * Metodo para desenhar a arvore recursivamente
	 * @param arvore tipo Tree
	 * @param screenBegin comeco da tela
	 * @param screenEnd final da tela
	 * @param height altura do elemento em relacao ao topo da tela
	 * @param g grafico para desenho
	 */
	public void desenharArvore(Tree arvore, int screenBegin, int screenEnd, int height, Graphics g) {

		int location = screenBegin + (screenEnd - screenBegin)/ 2;
		
		g.setColor(Color.black);
		g.fillRect(location, height + 10, noLargura, noAltura);
		
		g.setColor(Color.white);
		g.drawString(Integer.toString(arvore.getRoot().getAluno().getMatricula()), location + 5, height + 27);
		g.drawString(arvore.getRoot().getAluno().getNome(), location + 5, height + 42);

		
		if (arvore.getLeftTree() != null) {
			desenharArvore(arvore.getLeftTree(), screenBegin, location, height + noAltura + 10, g);
		}
		if (arvore.getRightTree() != null) {
			desenharArvore(arvore.getRightTree(), location, screenEnd, height + noAltura + 10, g);
		}
	}
	
	public class MyCanvas extends Canvas {
			
		@Override
		/**
		 * Metodo paint()
		 */
		public void paint(Graphics g) {

		}
	}
}
