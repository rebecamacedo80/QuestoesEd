
import java.util.Scanner;

public class LSE {
    
    class No {
        private String palavras;
        private No prox;

        public String getPalavras() {
            return palavras;
        }
        
        public void setPalavras(String palavras) {
            this.palavras = palavras;
        }

        public No getProx() {
            return prox;
        }

        public void setProx(No prox) {
            this.prox = prox;
        }
                    
    }    
        
    private No cabeca;
    private int tam;
    
    public LSE(){
        cabeca = null;
        tam = 0;           
    }
    
    public boolean vazia(){
         if(tam == 0)
         return true;
         
         else return false;
     }
     
    public boolean inserelistavazia(String palavra){
         No novoNo = new No();
         
         novoNo.setPalavras(palavra);
         novoNo.setProx(cabeca);
         cabeca = novoNo;
         tam++;
         
         //System.out.println("inseriu a palavra " + palavra + " na lista vazia");
         
         return true;
     }
    
    public boolean inserelistafim(String palavra){
        No novoNo = new No();
        novoNo.setPalavras(palavra);
        
        No aux = cabeca;
        while(aux.getProx() != null){
            aux = aux.getProx();
        }
        
        novoNo.setProx(null);
        aux.setProx(novoNo);
        tam++;
        
        //System.out.println("inseriu a palavra " + palavra + " na lista fim");
        
        return true;
    }
    
    public String conteudo(int pos){
        No aux = cabeca;
        int cont = 1;
        
        /*if(vazia()){
            return -1;
        }*/
        
        while(cont < pos){
            aux = aux.getProx();
            cont++;
        }
                
        return aux.getPalavras();
    }
                
    public static void main(String[] args) {
        
        LSE todo = new LSE();
                
        Scanner imput = new Scanner(System.in);
        
        int nElementosTodo = imput.nextInt();
        int nElementosPref = imput.nextInt();
        
        for(int i = 0; i < nElementosTodo; i++){            
            if (todo.vazia()){
                todo.inserelistavazia(imput.next());
            }
            else
                todo.inserelistafim(imput.next());
                         
        }
        
        LSE pref = new LSE();        
                
        for(int i = 0; i < nElementosPref; i++){
            if(pref.vazia()){
                pref.inserelistavazia(imput.next());
            }
            else 
                pref.inserelistafim(imput.next());
                        
            
        }
        
        //No t = todo.cabeca;
        //No p = pref.cabeca;
        for(int i = 1; i <= nElementosPref; i++){
            int cont = 0;
            for(int j = 1; j <= nElementosTodo; j++){
                if (todo.conteudo(j).startsWith(pref.conteudo(i)) == true){
                    cont++;
                }                     
            }                   
            System.out.println(cont);
        }       
    }
  }          

