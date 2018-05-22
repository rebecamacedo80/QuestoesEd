import java.util.Scanner;

public class OMWG {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int T = Integer.parseInt(input.nextLine());
        int n, m;
        
        for(int i = 0; i<T; i++){
           String line = input.nextLine();
           String G[] = line.split(" ");
           
           n = Integer.parseInt(G[0]);
           m = Integer.parseInt(G[1]);
           
           int pt = (2*m*n - n-m);
           
            System.out.println(pt);
           
        }
        
    }
    
}
