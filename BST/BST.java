
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import static java.lang.System.in;

/**
 *
 * @author rebeca
 */
public class BST {
    class No{
        private long conteudo;
        private No esq;
        private No dir;

        public long getConteudo() {
            return conteudo;
        }

        public void setConteudo(long conteudo) {
            this.conteudo = conteudo;
        }

        public No getEsq() {
            return esq;
        }

        public void setEsq(No esq) {
            this.esq = esq;
        }

        public No getDir() {
            return dir;
        }

        public void setDir(No dir) {
            this.dir = dir;
        }
                
    }
    
    private int c;
    private No raiz;
    
    public BST(long conteudo){
        No novoNo = new No();
        novoNo.setConteudo(conteudo);
        
        raiz = novoNo;
        c = 0;
    }
    public int cont(){
        return c;
    }
    
    public void inserir (long conteudo){
        inserir(conteudo, raiz);
    }
    
    public void inserir (long conteudo, No no){
        c++;
        if(conteudo < no.conteudo){
            if(no.getEsq() == null){
                No novoNo = new No();
                novoNo.setConteudo(conteudo);
                
                no.setEsq(novoNo);
                
            }else{
                inserir(conteudo, no.getEsq());
            }
        }else{
            if(no.getDir() == null){
                No novoNo = new No();
                novoNo.setConteudo(conteudo);
                
                no.setDir(novoNo);
            }else{
                inserir(conteudo, no.getDir());
                
            }
        }
    } 
}
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(input.readLine());
        long aux = Long.parseLong(input.readLine());
        
        BST bst = new BST(aux);
        System.out.println(bst.cont());
        
        for(int i = 1; i < n; i++){
           aux = Long.parseLong(input.readLine());
           bst.inserir(aux);
           
           System.out.println(bst.cont());
        }
        
        
    }
}

