package Projeto;
public enum Classificacao {
	DETESTO(-5,"Detesto"),
	ACHO_MUITO_RUIM(-4,"Acho muito ruim"),
	ACHO_BASTANTE_RUIM(-3, "Acho bastante ruim"),
	ACHO_RUIM(-2,"Acho ruim"),
	ACHO_UM_POUCO_RUIM(-1,"Acho um pouco ruim"),
	NAO_CONHECO(0, "Não conheço"),
	NAO_EH_RUIM(1, "Não é ruim"),
	EH_BONZINHO(2, "É bonzinho"),
	BASTANTE_BOM(3,	"Bastante bom"),
	MUITO_BOM(4,"Muito bom"),
	INCRIVEL_SENSACIONAL_IMPRESSIONANTE(5,"Incrível. sensacional. impressionante");
	
	private int nota;
	private String rotulo;

	private Classificacao(int nota, String rotulo) {
		this.nota = nota;
		this.rotulo = rotulo;
	}

	public int getNota() {
		return nota;
	}

	public String getRotulo() {
		return rotulo;
	}
}
