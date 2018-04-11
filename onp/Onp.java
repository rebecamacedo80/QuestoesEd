

import java.util.Scanner;

 class Onp {
    static class No{
        private char content;
        private No prox;
        
        public No(){
            setProx(null);
        }

        public char getContent() {
            return content;
        }

        public void setContent(char content) {
            this.content = content;
        }

        public No getProx() {
            return prox;
        }
        
        public void setProx(No prox) {
            this.prox = prox;
        }
    }    
    No topo;
    int nElementos;
    
    public Onp(){
        topo = null;
        nElementos = 0;
    }
    
    public boolean vazia(){
        if(nElementos == 0)
            return true;
        else
            return false;
    }
    
    public void push(char l){
        No newNo = new No();
        
        newNo.setContent(l);
        newNo.setProx(topo);
        
        topo = newNo;
        nElementos++;             
                        
    }
    
    public char pop(){
        No q = topo;
        
        char operacao = q.getContent();
        
        topo= q.getProx();
        nElementos--;
        
        q = null;
              
        return operacao;
    }
    
    public static void main(String[] args) {
        int k = 0, quant;
        char r;
        
        Scanner s = new Scanner(System.in);
        
        Onp ope = new Onp();
        Onp let = new Onp();
        Onp aux = new Onp();
        
        quant = s.nextInt();
        String expressao[] = new String[quant];
        
        for(int a = 0; a < quant && quant <= 100; a++){
        
        expressao[a] = s.next();
        }
        
        for(int a = 0; a < quant && quant <= 100; a++){
        
       
        for(int i = 0; i < expressao[a].length() && expressao[a].length() <= 400; i++){
            
            if(expressao[a].charAt(i) != ')' ){
                      
                if( (expressao[a].charAt(i)== '+')  || (expressao[a].charAt(i) == '-')
                || (expressao[a].charAt(i) == '*') || (expressao[a].charAt(i) == '/') 
                    || (expressao[a].charAt(i) == '^') ){
                
                    ope.push(expressao[a].charAt(i));
                                                                
                }
                
                if(expressao[a].charAt(i) >= 97 && expressao[a].charAt(i) <= 122){
                    
                    let.push(expressao[a].charAt(i));
                
                }
            }
            else{
                                        
                while(!let.vazia()){
                    aux.push(let.pop());                    
                   
                }
                while(!aux.vazia()){
                    System.out.print(aux.pop());
                    
                }

                System.out.print(ope.pop());

            }
        
        }    
            System.out.println("");     
        }
        
        
    }
                      
}
