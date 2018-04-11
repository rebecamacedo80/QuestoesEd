
import java.util.Scanner;

class Fila {
    public class No{
        private int conteudo;
        private No prox, ant;
        
         public No(){
            conteudo = 0;
            prox = null;
            ant = null;
            
        }

        public int getConteudo() {
            return conteudo;
        }

        public void setConteudo(int conteudo) {
            this.conteudo = conteudo;
        }

        public No getProx() {
            return prox;
        }

        public void setProx(No prox) {
            this.prox = prox;
        }

        public No getAnt() {
            return ant;
        }

        public void setAnt(No ant) {
            this.ant = ant;
        }
    }
        
        private No inicio;
        private No fim;
        private int nElementos;
        private boolean reverso = false;
        
        
        public boolean Vazia(){
            if(nElementos == 0)
                return true;
            else
                return false;
            
        }
        
         public void reverse(){
            No aux = inicio;
            inicio = fim;
            fim = aux;
            
            reverso = !reverso;
            
        }
        
        public void pushBack(int valor){
            if(reverso){
                reverse();
                pushFront(valor);
                reverse();
            }else{
                No novo = new No();
                novo.setConteudo(valor);                
                novo.setProx(null);
            
               
                if(Vazia()){
                    novo.setAnt(null);
                    inicio = novo;
                    fim = novo;
                }else{
                    novo.setAnt(fim);
                    fim.setProx(novo);                    
                    fim = novo;
                }           
            }
            nElementos++;
        }
        
        public void pushFront(int valor){
            if(reverso){
                reverse();
                pushBack(valor);
                reverse();
                
            }else{
                No novo = new No();
                novo.setConteudo(valor);
                novo.setAnt(null);
                
                if(Vazia()){
                    novo.setProx(null);
                    fim = novo;
                    inicio = novo;
                }else{
                    novo.setProx(inicio);
                    inicio.setAnt(novo);                   
                    inicio = novo;
                }
            }
                nElementos++;
                return;
                
        }
        
        public void back() throws Exception{
             if(Vazia()){
                 throw new Exception("Empty Queue");
             }       
            
            if(reverso){
                reverse();
                front();
                reverse();
            }else{  
                if(inicio != fim){
                    No aux = fim;
                    fim = fim.getAnt();
                    fim.setProx(null);
                    aux = fim;
                }else{
                    inicio = null;
                    fim = null;
                }
            }
            
        }
        public int saidaBack() throws Exception{
            int n = fim.getConteudo();
            back();
            return n;
        }
        
        public void front() throws Exception{
            if(Vazia()){
                 throw new Exception("Empty Queue");
             }       
            
            if(reverso){
                reverse();
                back();
                reverse();
            }else{
                if(inicio != fim){
                    No aux = inicio;    
                    inicio = inicio.getProx();
                    inicio.setAnt(null);
                    aux = null;
                }else{
                    inicio = null;
                    fim = null;
                }            
            }
             nElementos--;  
            
        }
        public int saidaFront() throws Exception{
            int n = inicio.getConteudo();
            front();
            return n;
        }
}
class ADAQUEUE{
        
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        
        Fila f = new Fila();      
        String comando;      
      
        int num;
        num = s.nextInt();
        //s.nextLine();
        
        for(int i = 0; i <= num; i++){
            comando = s.nextLine();
            String[] consulta = comando.split(" ");
            
            try {
            switch(consulta[0]){
                case "toFront":
                    f.pushFront(Integer.parseInt(consulta[1]));
                    break;
                case "push_back":
                    f.pushBack(Integer.parseInt(consulta[1]));
                    break;
                case "front":
                   
                        System.out.println(f.saidaFront());
                   
                    break;
                case "back":
                    
                        System.out.println(f.saidaBack());
                   
                    break;
                case "reverse":
                    f.reverse();
                    break;
                default:
                    break;
                    
            }
            }catch(Exception e){
                    System.out.println("No job for Ada?");
                    }
        }
        
        
        
    }
}

