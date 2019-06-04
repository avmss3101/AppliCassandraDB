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
        session = cluster.connect("teste");
        //session.execute("insert");
        String catid = null, pdtid = null, pdtname = null, sa = null;
        float price = 0;
        ResultSet results = session.execute("select * from products");
        for (Row row : results) {
            pdtid = Integer.toString(row.getInt("pdt_id"));
            catid = Integer.toString(row.getInt("cat_id"));
            pdtname = row.getString("pdt_name");
            price = row.getFloat("price");
            sa = row.getString("shippingaddress");
            
            System.out.println("PDTid: " + pdtid);
            System.out.println("Name" + pdtname);
            System.out.println("CatID" + catid);
            System.out.println("Preco: " + price);
            System.out.println("SA: " + sa);
        }
        cluster.close();
  }
}