import java.util.Scanner;

public class HashIt {
    
    static int hash(String ch) {
		return h(ch) % 101;
    }
	
    static int h(String ch1) {
	int h = 0;
		
	for(int i = 0 ; i < ch1.length() ; i++)
		h+=ch1.charAt(i)*(i+1);
	
	return 19*h;
    }

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int casos = input.nextInt();
		
		while(casos-- > 0) {
			
			String[] t = new String[101];
			int cont = 0;
			int nOper = input.nextInt();
			
			while(nOper-- > 0) {
				
				String op = input.next();
				String v = op.substring(4);
				int hash = hash(v);
				
				if(op.charAt(0) == 'A') {
					
					boolean duplic = false;
					
					for(int i = 0 ; i < t.length ; i++)
						if(t[i] != null && t[i].equals(v)) {
							duplic = true;
						}
					
					if(duplic)
						continue;
					
					int tent = 0;
					while(tent < 20) {
						int novoHash = (int)(hash + Math.pow(tent, 2) + 23*tent) % 101;
						if(t[novoHash] == null || t[novoHash].equals(v)) {
							
							if(t[novoHash] == null)
								cont++;
							
							t[novoHash] = v;
							break;
						}
						tent++;
					}
					
				}else{
					
					int tent1 = 0;
					while(tent1 < 20) {
						int novoHash = (int)(hash + Math.pow(tent1, 2) + 23*tent1) % 101;
						if(t[novoHash] != null && t[novoHash].equals(v)) {
							cont--;
							t[novoHash] = null;
							break;
						}
						tent1++;
					}
				}
			}
			
			System.out.println(cont);
			
			for(int i = 0 ; i < t.length ; i++)
				if(t[i] != null)
					System.out.println(i+":"+t[i]);
		}
	}
	
	
}
