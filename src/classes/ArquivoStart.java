
package classes;

import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;

public class ArquivoStart {
    
    
    public static void main(String[] args) {
        
        try{
            ArquivoPersistente arquivar;
        arquivar = new ArquivoPersistente("Arquivo.txt");        
        Arquivo objeto = new Arquivo();
        
       // objeto.setDados(JOptionPane.showInputDialog("Digite um texto qualque aqui > "));        
       // arquivar.incluir(objeto);
            System.out.print(arquivar.recuperar());
       
            arquivar.excluir(JOptionPane.showInputDialog("Digite o dado que deseja excluir aqui > "));
            System.out.print(arquivar.recuperar());
            
        }catch (Exception erro){
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
        
        
    }
    
}
