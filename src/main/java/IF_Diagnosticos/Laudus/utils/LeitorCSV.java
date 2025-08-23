package IF_Diagnosticos.Laudus.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorCSV {
    private String caminhoCSV;

    public LeitorCSV(String caminhoCSV) {
        this.caminhoCSV = caminhoCSV;
    }

    public List<String[]> lerLinhas() {
        List<String[]> linhas = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(caminhoCSV))) {
                String linha;
                boolean primeiraLinha = true; // pular cabeçalho
                while ((linha = br.readLine()) != null) {
                    if (primeiraLinha) {
                        primeiraLinha = false;
                        continue;
                    }
                    String[] dados = linha.split(",");
                    linhas.add(dados);
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler CSV: " + e.getMessage());
            }
            return linhas;
        }
    }
