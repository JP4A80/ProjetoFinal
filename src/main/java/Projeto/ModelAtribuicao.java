/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jpexi
 */
public class ModelAtribuicao extends AbstractTableModel{
    
    ArrayList<Atribuicao> atribuicao = new ArrayList();
    String[] colunas = {"Disciplina", "ID Disciplina","Professor", "ID Professor"};
    
    
   public void cadastrarDisciplina(Atribuicao f){
        atribuicao.add(f);
        this.fireTableDataChanged();
    }
    
   public void ler(){
    String path = "C:\\Users\\jpexi\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoFinal\\Atribuicao.txt";
		List<Atribuicao> list = new ArrayList<Atribuicao>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				
				String[] vect = line.split(",");
				String nome = vect[0];
                                String salario = vect[1];
                                String area = vect[2];
				String cpf = vect[3];
                                Atribuicao e = new Atribuicao( nome, salario, area,cpf);
                               cadastrarDisciplina(e);
				line = br.readLine();
			}	
			
			System.out.println("PRODUCTS:");
			for (Atribuicao e : list) {
				System.out.println(e);
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
    }
   
   
   public void gravard(int somaLinhas){
         
        try{
            FileWriter arq = new FileWriter("C:\\Users\\jpexi\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoFinal\\Atribuicao.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            System.out.print("Entrou\n");
            gravarArq.print("Disciplina, ID Disciplina, Professor,ID Professor\n");
            for (int i=0; i < somaLinhas; i++){
                Atribuicao f = returnAtribuicao(i);
                String conteudo = f.getDisiplina()+ ","+f.getIddisplina()+","+f.getProfessor()+","+f.getIdprofessor()+"\n";
                System.out.print(conteudo);
                gravarArq.print(conteudo);
                
            }
            gravarArq.close();
        }catch (java.io.IOException er){
            System.out.println("OOOOps");
        }
    }
   
   
   public Atribuicao returnAtribuicao(int index){
        return atribuicao.get(index);
    }
   
   public void removerAtribuicao(int index){
        atribuicao.remove(index);
        this.fireTableDataChanged();
    }
   
    @Override
    public int getRowCount() {
        return atribuicao.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
           return atribuicao.get(rowIndex).getDisiplina();
        }else if (columnIndex == 1){
            return atribuicao.get(rowIndex).getIddisplina();
        }else if (columnIndex == 2){
            return atribuicao.get(rowIndex).getProfessor();
        } else {
            return atribuicao.get(rowIndex).getIdprofessor();
        }
    }
    
}
