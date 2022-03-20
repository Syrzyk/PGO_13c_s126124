package g13c.cw1.zad7;
import java.util.Scanner;

public class PrintN {

    public static void main(String[] args) {


        boolean flag=false;
        do {
            int n;
            System.out.print("Wprowadź proszę liczbę nieparzystą, większą bądź równą 5: ");
            Scanner scan = new Scanner(System.in);
            n = scan.nextInt();

            if (n % 2 == 0 || n < 5) {
                System.out.println("Liczba niespełnia wymagań, wprowadź ponownie.");
            }
            else
            {
                flag=true;
                System.out.println("Twoja liczba spełnia wymagania, gratulacje!");
                       for (int i=0;i<n;i++){
                           for (int j=0;j<n;j++){
                                if (i==j || i==0 || j==0 || i==n-1 || j==n-1   )
                                {
                                    System.out.print("* ");
                                }
                                else System.out.print("  ");
                           }
                           System.out.println();
                       }
            }

        } while (flag=false);

    }
}
