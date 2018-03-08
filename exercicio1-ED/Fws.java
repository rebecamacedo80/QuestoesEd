
import java.util.Scanner;

public class Fws {
    
    public static void main(String[] args){
        int ar[], ar1[];
        int tamAr;
        
        Scanner n = new Scanner(System.in);
        
        ar = new int[n.nextInt()];
        
        for(int i = 0; i < ar.length; i++){
            ar[i] = n.nextInt();
        }
        
        ar1 = new int[n.nextInt()];
        
        for(int j = 0; j < ar1.length; j++){
            ar1[j] = n.nextInt();
        }
        
        for(int k = 0; k < ar.length; k++){
            int aux =  0;
            
            for(int l = 0; l < ar1.length; l++){
                if(ar[k] == ar1[l]){
                    aux++;
                }                
            }
            if(aux == 0) System.out.print(ar[k]+" ");
        }                
    }    
}
