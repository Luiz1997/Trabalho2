import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Trabalho2 {
	
public static void main(String args[]) {
	
		String arquivo = "file.txt";
		
		try {
			System.setIn(new FileInputStream(new File(arquivo)));
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encrontrado");
		}
	
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));
		
		int N, i, vettipo[];
		String vetnome[],  vettel[];
		double vetvalor[], vetmin[];
		
		System.err.println("Quantos clientes possui a campanha telefonica: ");
		N = sc.nextInt();
		
		vetnome = new String[N];
		vettel = new String[N];
		vettipo = new int[N];
		vetmin = new double[N];
		vetvalor = new double[N];
		
		for(i=0;i<N;i++) {
			System.out.println("Nome da "+(i+1)+"° pessoa: ");
			sc.nextLine();
			vetnome[i] = sc.next();
		}
		sc.nextLine();
		
		for(i=0;i<N;i++) {
			System.out.println("Telefone "+(i+1)+"° pessoa: ");
			vettel[i] = sc.next();
		}
		
		for(i=0;i<N;i++) {
			System.out.println("Tipo "+(i+1)+"° pessoa: ");
			vettipo[i] = sc.nextInt();
		}
		
		for(i=0;i<N;i++) {
			System.out.println("Minutos "+(i+1)+"° pessoa: ");
			vetmin[i] = sc.nextDouble();
		}
		
		double mat[][] ;
		int l ,c;
		
		mat = new double[3][2];
		
		for(l = 0 ; l < 3 ; l++){
            for(c = 0; c < 2 ; c++) {
            	if (c == 1) {
                System.out.println("Digite o preço adicional do tipo "+(l+1)+": ");
                mat[l][c] = sc.nextDouble();
            	}
            	else {
            		System.out.println("Digite o preço do tipo "+(l+1)+": ");
                    mat[l][c] = sc.nextDouble();	
            	}
            }
        }
		
		for(i=0; i<N; i++){
			if (vetmin[i] > 90){
				vetvalor[i] = mat[vettipo[i]][0]+(vetmin[i]-90.0) * mat[vettipo[i]][1];
			}
			else {
				vetvalor[i] = mat[vettipo[i]][0];
			}
		}
		
		System.out.println("");
		System.err.println("NOME  TELEFONE  TIPO  MINUTOS  TOTAL");
		for (i=0; i<N; i++) {
			System.out.print(vetnome[i]+": ");
			System.out.print(vettel[i]+"  ");
			System.out.print(vettipo[i]+"  ");
			System.out.print(vetmin[i]+"  ");
			System.out.printf("%.2f",vetvalor[i]);
			System.out.println("");
		}
		System.out.println("");
		
		//1) A receita total da empresa telefônica (soma de todas as contas).
		double rectotal=0;
		for(i=0; i<N; i++) {
			rectotal = rectotal + vetvalor[i];
		}
		System.out.printf("A receita total igual a: %.2f\n",rectotal);
		System.out.println();
		
		//2) Nome e telefone do cliente do qual a conta foi mais barata (supor não haver empates).
		int menor = 0;
		double comparar = 0;
		comparar = vetvalor[0];
		for(i=0; i<N; i++) {
			if(comparar > vetvalor[i]){
				comparar = vetvalor[i];
				menor = i;
			}
			
		}
		System.out.println("A conta mais barata - "+vetnome[menor]+": "+vettel[menor]);
		rectotal=0;
		double j=0;
		for(i=0; i<N; i++) {
			if(vettipo[i] == 1) {
				rectotal = rectotal + vetmin[i];
				j++;
			}
		}
		System.out.println("");
		//3) Média de minutos consumidos por clientes de conta tipo 1.
		System.out.printf("Media dos minutos dos clientes 1 é: %.1f\n",rectotal/j);
		System.out.println("");
		
		//4) Nomes e telefones dos clientes que não consumiram minutos excedentes.
		System.out.println("Clientes que não consumiram minutos excedentes: ");
		for(i=0; i<N; i++) {
			if(vetmin[i] <= 90){
				System.out.println(vetnome[i]+": " + vettel[i]);
			}
		}
		
		//5) A quantidade de clientes que consumiu acima de 120 minutos.
		double per;
		j=0;
		for(i=0; i<N; i++) {
			if(vetmin[i] > 120){
				j++;
			}
		}
		System.out.println("");
		System.out.println("Cliente(s) consumiu(ram) mais que 120 minutos: "+j);
		j=0;
		for(i=0; i<N; i++) {
			if(vettipo[i] == 2){
				j++;
			}
		}
		//6) A porcentagem de clientes que possuem conta tipo 2, em relação ao total de clientes.
		per = (double) j / N * 100;
		System.out.println("");
		System.out.printf("%.1f%% dos clientes possuem contas do tipo 2",per);

		sc.close();
	}

}