
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author rebec
 */
public class Tree {
    static class No{
        int conteudo;
        No esq;
        No dir;
       
        public No(int valor){
            conteudo = valor;
            esq = null;
            dir = null;
        }
    }
    
    static class TreeBin{
        protected String posString = "";
        protected static int preIndice = 0;
        
        private No constroi(String in[], String pre[], int comeco, int fim){
            if(comeco > fim)
                return null;
            
            int valor = Integer.parseInt(pre[preIndice++]);
            No novoNo = new No(valor);
            
            if(comeco == fim)
                return novoNo;
            
            int i = busca(in, comeco, fim, novoNo.conteudo);
            
            novoNo.esq = constroi(in, pre, comeco, i-1);
            novoNo.dir = constroi(in, pre, i+1, fim);
            
            return novoNo;
        }
        private int busca(String ar[], int comeco, int fim, int cont){
           int i;
           for(i = comeco; i <= fim; i++){
               int v = Integer.parseInt(ar[i]);
               
               if(v == cont)
                   return i;
            }
            return i;
        }
        private void posTree(No no){
            if(no == null)
                return;
            posTree(no.esq);
            posTree(no.dir);
            
            posString += no.conteudo + " ";
        }
        private String comparaString(){
            return posString;
        }
        
    }
       
    public static void main(String[] args) throws IOException {
        TreeBin tree = new TreeBin();
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int tam = Integer.parseInt(input.readLine());
        
        String pre = input.readLine();
        String preOrdem[] = pre.split(" ");
        
        String pos = input.readLine();
        
        String in = input.readLine();
        String inOrdem[] = in.split(" ");
        
        No raiz = tree.constroi(inOrdem, preOrdem, 0, tam-1);
        
        tree.posTree(raiz);
        
        String treePos = tree.comparaString();
        String posString = treePos.substring(0, treePos.length()-1);
        
        if(pos.equals(posString))
            System.out.println("yes");
        
        else System.out.println("no");
    }    
}

