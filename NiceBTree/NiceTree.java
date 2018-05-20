
import java.util.Scanner;

class NiceTree {
    
    class No {
        private char letra;
        private No esq;
        private No dir;

        public char getLetra() {
            return letra;
        }

        public void setLetra(char letra) {
            this.letra = letra;
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
    
    private int ind;
    private No raiz;
    private String percurso;
        
    public NiceTree(String p){
        percurso = p;
        ind = 0;
        
        No novoNo = new No();
        raiz = novoNo;
        
        
        raiz.setLetra(percurso.charAt(ind));
        if(raiz.getLetra() == 'l' ){
            raiz.setEsq(null);
            raiz.setDir(null);
            
        }
        if(raiz.getLetra() == 'n'){
            raiz.setEsq(adiciona(raiz, percurso.charAt(ind++)));
            raiz.setDir(adiciona(raiz, percurso.charAt(ind++)));
            
        }
    
    } 
    public No adiciona(No pai, char letra){
        No novoNo = new No();
        novoNo.setLetra(letra);
            
        if(letra == 'l'){
            novoNo.setEsq(null);
            novoNo.setDir(null);
            
        }else {
            novoNo.setEsq(adiciona(novoNo, percurso.charAt(ind++)));
            novoNo.setDir(adiciona(novoNo, percurso.charAt(ind++)));
        }    
        return novoNo;
    }
    
    public int profundidade() {
        return profundidade(raiz) - 1;
    }
        
    public int profundidade(No no){
        if(no == null) return 0;
        
        int prof_esq = profundidade(no.getEsq());
        int prof_dir = profundidade(no.getDir());
        
        if(prof_esq > prof_dir) return ++prof_esq;
        else return ++prof_dir;     
        
    }
}
class NiceBTree{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        int t = input.nextInt();
        input.nextLine();
        
        String per;
        for(int i = 0; i < t; i++){
            per = input.nextLine();
            
            NiceTree nt = new NiceTree(per);
            
            System.out.println(nt.profundidade());
        }
        
    }   
}
