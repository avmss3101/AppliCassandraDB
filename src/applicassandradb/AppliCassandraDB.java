package applicassandradb;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

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
        Cluster cluster;
        Session session;
        cluster = Cluster.builder().addContactPoint("localhost").build();
        session = cluster.connect("trabalho_bd");
        //session.execute("insert");
        String titulo, titulo_original;
        int id, ano, qtd_visualizacao, duracao_min, censura;
        float nota;
        ResultSet results = session.execute("select * from products");
        for (Row row : results) {
            titulo = row.getString("titulo");
            titulo_original = row.getString("titulo_original");
            id = row.getInt("id");
            ano = row.getInt("ano");
            qtd_visualizacao = row.getInt("qtd_visualizacao");
            duracao_min = row.getInt("duracao_min");
            censura = row.getInt("censura");
            nota = row.getFloat("nota");
            
            
        }
        cluster.close();
  }
}