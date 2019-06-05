package applicassandradb;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author andre
 */
public class AppliCassandraDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String campo1 = "";
        JLabel label1 = new JLabel("Consultar ou Inserir");
        JTextField campo = new JTextField();

        Cluster cluster;
        Session session;
        cluster = Cluster.builder().addContactPoint("localhost").build();
        session = cluster.connect("trabalho_bd");
        //session.execute("insert");

        String titulo, titulo_original;
        int id, ano, qtd_visualizacao, duracao_min, censura;
        float nota;

        while (!campo1.equals("sair")) {

            JOptionPane.showConfirmDialog(null, new Object[]{label1, campo}, 
                                            "Consultar ou Inserir", 
                                            JOptionPane.OK_CANCEL_OPTION, 
                                            JOptionPane.PLAIN_MESSAGE);
            campo1 = campo.getText();
            
            if (campo1.equals("consultar")) {
                
                ResultSet results = session.execute("select * from filmes");
                Object[][] linhas;
                linhas = new Object[10][8];
                Object[] colunas = {"ID", "Titulo", "Titulo Original", "Ano", 
                                    "Visualizacoes", "Duracao", "Censura", 
                                    "Nota"};
                int l = 0, c = 0;
                JTable tabela;
                JFrame frame;
                for (Row row : results) {
                    id = row.getInt("id");
                    linhas[l][c] = id;
                    c++;
                    titulo = row.getString("titulo");
                    linhas[l][c] = titulo;
                    c++;
                    titulo_original = row.getString("titulo_original");
                    linhas[l][c] = titulo_original;
                    c++;
                    ano = row.getInt("ano");
                    linhas[l][c] = ano;
                    c++;
                    qtd_visualizacao = row.getInt("qtd_visualizacao");
                    linhas[l][c] = qtd_visualizacao;
                    c++;
                    duracao_min = row.getInt("duracao_min");
                    linhas[l][c] = duracao_min;
                    c++;
                    censura = row.getInt("censura");
                    linhas[l][c] = censura;
                    c++;
                    nota = row.getFloat("nota");
                    linhas[l][c] = nota;
                    l++;
                    c = 0;
                }
                tabela = new JTable(linhas, colunas);
                frame = new JFrame();
                frame.add(new JScrollPane(tabela));
                JOptionPane.showMessageDialog(null, new JScrollPane(tabela), 
                                                "Lista de Filmes", 1);
            }
            if(campo1.equals("inserir")) {
                
                String campo1_1 = "", campo1_2 = "", campo1_3 = "", 
                        campo1_4 = "", campo1_5 = "", campo1_6 = "",
                        campo1_7 = "", campo1_8 = "";
                JLabel label_1 = new JLabel("ID");
                JTextField campo2_1 = new JTextField();
                JLabel label_2 = new JLabel("Titulo");
                JTextField campo2_2 = new JTextField();
                JLabel label_3 = new JLabel("Titulo Original");
                JTextField campo2_3 = new JTextField();
                JLabel label_4 = new JLabel("Ano");
                JTextField campo2_4 = new JTextField();
                JLabel label_5 = new JLabel("Quantidade de V.");
                JTextField campo2_5 = new JTextField();
                JLabel label_6 = new JLabel("Duracao");
                JTextField campo2_6 = new JTextField();
                JLabel label_7 = new JLabel("Censura");
                JTextField campo2_7 = new JTextField();
                JLabel label_8 = new JLabel("Nota");
                JTextField campo2_8 = new JTextField();
                
                JOptionPane.showConfirmDialog(null, new Object[]{label_1, 
                                            campo2_1, label_2, campo2_2, 
                                            label_3, campo2_3, label_4,
                                            campo2_4, label_5, campo2_5, 
                                            label_6, campo2_6, label_7,
                                            campo2_7, label_8, campo2_8}, 
                                            "Inserir", 
                                            JOptionPane.OK_CANCEL_OPTION, 
                                            JOptionPane.PLAIN_MESSAGE);
                campo1_1 = campo2_1.getText();
                campo1_2 = campo2_2.getText();
                campo1_3 = campo2_3.getText();
                campo1_4 = campo2_4.getText();
                campo1_5 = campo2_5.getText();
                campo1_6 = campo2_6.getText();
                campo1_7 = campo2_7.getText();
                campo1_8 = campo2_8.getText();
                
                session.execute("insert into filmes (id, "
                        + "titulo, titulo_original, ano, qtd_visualizacao, "
                        + "duracao_min, censura, nota) values "
                        + "(" + Integer.parseInt(campo1_1) + ", '" + campo1_2 + 
                        "','" + campo1_3 + "'," + Integer.parseInt(campo1_4) + "," 
                        + Integer.parseInt(campo1_5) + "," + 
                        Integer.parseInt(campo1_6) + "," + 
                        Integer.parseInt(campo1_7) + "," + 
                        Float.parseFloat(campo1_8) + ")");
            }
        }
        cluster.close();
    }
}
