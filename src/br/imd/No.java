package br.imd;

public class No {
	
	private Aluno aluno;
	/**
	 * Classe que insere aluno
	 * @param aluno
	 */
    public No(Aluno aluno) {
        this.aluno = aluno;
    }
    /**
     * Metodo para retornar aluno
     * @return aluno
     */
    public Aluno getAluno() {
        return aluno;
    }
    /**
     * Metodo para setar aluno
     * @param aluno
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    /**
     * Metodo para printar o nome do aluno e sua matricula
     */
    public void print() {
    	System.out.println("Nome: " + aluno.getNome() + " | Matrícula: " + aluno.getMatricula());
    }
}
