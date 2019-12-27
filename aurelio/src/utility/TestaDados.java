package utility;

//CLASSE RESPONS�VEL POR TESTES B�SICOS NO VETOR DE RESPOSTAS DO ADM
public class TestaDados {
	
	private static float soma;
	
	private TestaDados() {	
	}
	
	// M�TODO RESPONS�VEL POR SOMAR TODOS OS DADOS DO VETOR.
	public static void testeSoma(Float[] dados) {
		int i = 0;
		while(i <= dados.length - 1) {
			soma = soma + dados[i];
			i++;
		}
		System.out.println("A soma das respostas no teste foi: " + soma);
	}
	
	// M�TODO RESPONS�VEL POR INFORMAR A EXIST�NCIA DE DADOS NO VETOR.
	public static void statusDados(Float[] dados) {
		if(dados[0] == null){
			System.out.println("STATUS: Vetor Vazio");
		}
		else {
			System.out.println("STATUS: H� dados no vetor");
			for(int i=0; i<=dados.length - 1; i++) { // MOSTRA TODOS OS DADOS NO VETOR.
				System.out.println(dados[i]+"\n");
			}
		}
	}
	
}
