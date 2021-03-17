
package classes;

public class Arquivo implements Comparable<Arquivo>{
    
    private String dados = "";
    
    public Arquivo (){
        this.dados = dados;
    }
    public Arquivo (Arquivo objeto){
        this.dados = objeto.dados;
    }
    
    public Arquivo (String strDados)throws Exception{
        String vetor[] = strDados.split("\n");
        if (vetor.length < 1) {
            throw new Exception("Faltam dados");
        }else {            
            this.dados = vetor[0];                      
        }
        
    }
    
    public void setDados(String dados){
        this.dados = dados;
    }
    
    public String getDados(){
        return dados;
    }
    
    @Override
    public String toString(){
        String saida = dados + "\n";                
                return saida;
    }

    @Override
    public int compareTo(Arquivo objeto) {
        return dados.compareToIgnoreCase(objeto.getDados());
    }
    
}
