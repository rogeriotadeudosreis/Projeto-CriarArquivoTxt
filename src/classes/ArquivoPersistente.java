package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class ArquivoPersistente {
    
    private String nomeDoArquivoNoProjeto = "";
 
    public ArquivoPersistente (String nomeDoArquivo){
        nomeDoArquivoNoProjeto = nomeDoArquivo;
    }
    
    public void incluir (Arquivo objeto)throws Exception{        
        try {
            FileWriter fw = new FileWriter(nomeDoArquivoNoProjeto, true);
            BufferedWriter bw = new BufferedWriter(fw);            
            bw.write(objeto.toString() + "\n");            
            bw.close();
            JOptionPane.showMessageDialog(null, "Objeto gravado com sucesso!!!");
            
        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage() + "Ocorreu um erro na gravação deste arquivo" );
        }
        
    }
    
    public ArrayList<Arquivo> recuperar ()throws Exception{
        try {
            ArrayList<Arquivo> ListaDeDados = new ArrayList<Arquivo>(); 
            
            FileReader fr = new FileReader(nomeDoArquivoNoProjeto);
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            while ((linha = br.readLine()) != null){
                Arquivo objeto = new Arquivo(linha);
                ListaDeDados.add(objeto);
            }
                br.close();      
           Collections.sort(ListaDeDados);
        return ListaDeDados;
        
        
        } catch (Exception erro) {
           throw new Exception(erro.getMessage());
        }     
    }
    
    public void excluir (String nome)throws Exception{
        try {
            ArrayList<Arquivo> ListaDeDados = recuperar();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoProjeto);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int pos = 0; pos < ListaDeDados.size(); pos++) {            
                
                Arquivo aux = new Arquivo ();
                aux = ListaDeDados.get(pos);
                
                if (!nome.equalsIgnoreCase(aux.getDados())) {
                    bw.write(aux.toString());
                }                
            
            }
            bw.close();           
            
        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro!!!");
        }
        
        
    }
}


