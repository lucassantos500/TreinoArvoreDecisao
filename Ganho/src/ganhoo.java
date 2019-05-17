import javax.swing.JOptionPane;

public class ganhoo {
	
	public static double log2(double d) {
	    return Math.log(d)/Math.log(2.0);
	}
	
	public static double div(int a,int b) {
		double c;
		c = (double) a/b;
		return c;
	}
	
	public static double entropia(int a, int b, int c) {
		double div1 = div(a,c);
		double div2 = div(b,c);
		
		double entropy = (-1 * div1) * log2(div1) - (div2 * log2(div2));
		return entropy;
	}
	
	public static double ganho(double entropy,int a, int b, int c) {
		double gain;
		gain = (-1 * div(a,b) * entropia(a, b, c));
		return gain;
	}
	
	public static void main(String[] args) {
		
		int op = 0;
		op = Integer.parseInt(JOptionPane.showInputDialog("N° classes"));
		int totalP = Integer.parseInt(JOptionPane.showInputDialog("N° total positivo"));
		int totalN = Integer.parseInt(JOptionPane.showInputDialog("N° total negativo"));
		int totalT = totalP + totalN;
		double entropiaTotal = entropia(totalP, totalN, (totalP + totalN));
		System.out.println("Total Positivo: "+totalP);
		System.out.println("Total Negativo: "+totalN);
		System.out.println("Total Total: "+(totalP + totalN));
		System.out.println("Entropia total: "+entropiaTotal);
		double acumulo = 0;
		for(int i = 0; i < op; i++) {
			String Nome = JOptionPane.showInputDialog("Nome da classe");
			int qtdP = Integer.parseInt(JOptionPane.showInputDialog("N° positivos"));
			int qtdN = Integer.parseInt(JOptionPane.showInputDialog("N° negativos"));
			int soma = qtdN + qtdP;
			double divisão = div(soma,totalT);
			acumulo = acumulo - divisão * entropia(qtdP, qtdN, (qtdP + qtdN));
			System.out.println("----------------------------------------------------------------");
			System.out.println("total positivo : "+qtdP);
			System.out.println("total negativo : "+qtdN);
			System.out.println("Soma : "+soma);
			System.out.println("Div : "+divisão);
			System.out.println("Classe: "+Nome+" - Entropia: "+entropia(qtdP, qtdN, qtdP + qtdN));
			System.out.println("Acumulo: "+acumulo);
			
		}
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("Ganho do atributo: "+(entropiaTotal + acumulo));
		
		
		
		/*
		int a = 9;
		int b = 5;
		int c = 14;
		double f = entropia(a, b, c);
		System.out.println(f);
		
		double t = entropia(9, 5, 14)-(div(7,14) * entropia(3, 4, 7) ) - (div(7,14) * entropia(6,1,7)); 
		System.out.println(t);
		*/
		
	}

}
