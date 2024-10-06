import java.util.Scanner;
public class NotasMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("informe a nota 1: ");
        int nota1 = sc.nextInt();
        System.out.println("informe a nota 2: ");
        int nota2 = sc.nextInt();
        System.out.println("informe a nota 3: ");
        int nota3 = sc.nextInt();

        int CalcularMedia = (nota1 + nota2 + nota3) / 3;

        if(CalcularMedia >= 70){
            System.out.println("Aprovado");
        }
        else if(CalcularMedia >40){
            System.out.println("Final");
        }
        else{
            System.out.println("Reprovado");
        }
    }
}
