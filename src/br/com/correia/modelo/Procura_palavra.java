/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.correia.modelo;

/**
 *
 * @author fe_li
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Procura_palavra {

    private int tamanho = 10; //quantidade de letras da palavra
    private char[] letra = {'b','o'}; //letras já descobertas
    private int[] possicao = {2,10}; //posição das letras já descobertas da palavra (primeira letra é a posição 1)

    private void procura_palavra() {
        List<String> listaPalavras = new ArrayList();

        try {
            //carrega a lista de palavras
            File file = new File("D:\\OneDrive\\NetBeansProjects\\ProcuraPalavra\\src\\br\\com\\correia\\apoio\\palavras.txt");
            FileReader reader = new FileReader(file);
            BufferedReader input = new BufferedReader(reader);
            String linha;
            
            while ((linha = input.readLine()) != null) {
                int ttamanho = linha.length();
                if (linha.length() == tamanho) {                   
                    if (getValida(linha)) {
                        listaPalavras.add(linha);
                        System.out.println(linha);                        
                    }
                }
            }
            System.out.println(listaPalavras.size() + " Palavras encontradas!");
            input.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Procura_palavra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Procura_palavra.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public boolean getValida(String palavra){
        boolean teste = false;
        int val =0;
        
        for(int g=0; g<letra.length;g++){ 
            //verifica se a letra descoberta corresponde com a letra da palavra verificada na posição correta.
            if(letra[g]==palavra.charAt(possicao[g]-1)){
               val ++;
            }
            //se todas as letras escolhidas corresponderem a palavra testada em suas devidas posições, muda a variável para true
            if(val==letra.length){
                teste = true;
            }
            
        }
        return teste;
    }

    public static void main(String[] arg) {
        Procura_palavra k = new Procura_palavra();
        k.procura_palavra();
    }

}