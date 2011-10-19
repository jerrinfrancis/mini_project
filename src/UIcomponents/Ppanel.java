/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Ppanel.java
 *
 * Created on Oct 9, 2011, 7:11:52 AM
 */
package UIcomponents;
import dbconnect.*;
import java.util.Vector;
import java.sql.*;
/**
 *
 * @author user
 */
public class Ppanel extends javax.swing.JPanel {
    private static Vector<Vector<String>> data_hr;
    private static Vector<Vector<String>> data_phy;
    private static Vector<String> header_hr;
    private static Vector<String> header_phy;
    /** Creates new form Ppanel */
    public Ppanel() {
        data_hr = new Vector<Vector<String>>();
        data_phy = new Vector<Vector<String>>();
        try{
            DBquery d = new DBquery();
            ResultSet rs1 = d.generalQuery("SELECT DISTINCT res_name FROM phy_resource");
            while(rs1.next()){
                Vector<String> row1 = new Vector<String>();
                row1.add(rs1.getString(1));
                row1.add("0");
                data_phy.add(row1);
            
            }
            ResultSet rs2 = d.generalQuery("SELECT DISTINCT spec_name FROM specialisation");
            while(rs2.next()){
                Vector<String> row2 = new Vector<String>();
                row2.add(rs2.getString(1));
                row2.add("0");
                data_hr.add(row2);
            }
            header_phy = new Vector<String>();
            header_phy.add("Resource Types");
            header_phy.add("No. of instances reqd");
            header_hr = new Vector<String>();
            header_hr.add("Specialisations");
            header_hr.add("Number required");
        }catch(Exception e){
            System.out.println("exception caught in ppanel");
            e.printStackTrace();
        }
        
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        submitbutton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        phytable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex,int vColIndex){
                if(vColIndex == 1)
                return true;
                else
                return false;
            }
        };
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        hrtable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex,int vColIndex){
                if(vColIndex == 1){
                    return true;
                }
                else
                return false;
            }
        };
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Cooper Black", 0, 24));
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Project   Details");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14));
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("Name");

        jTextField2.setForeground(new java.awt.Color(0, 51, 153));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14));
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText("Expected Revenue");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14));
        jLabel5.setForeground(new java.awt.Color(0, 51, 153));
        jLabel5.setText("Delivery Date");

        jTextField4.setForeground(new java.awt.Color(0, 51, 153));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14));
        jLabel6.setForeground(new java.awt.Color(0, 51, 153));
        jLabel6.setText("Expected duration(in days)");

        jTextField5.setForeground(new java.awt.Color(0, 51, 153));

        submitbutton.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        submitbutton.setForeground(new java.awt.Color(0, 51, 153));
        submitbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIcomponents/submitIcon.gif"))); // NOI18N
        submitbutton.setText("Submit");
        submitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbuttonActionPerformed(evt);
            }
        });

        jScrollPane1.setToolTipText("Enter the no. of instances of each physical resource required.");

        phytable.setModel(new javax.swing.table.DefaultTableModel(data_phy,header_phy));
        jScrollPane1.setViewportView(phytable);

        jLabel2.setText("Physical Resource requirement :");

        jScrollPane2.setToolTipText("Enter the no.of employees required in each specialisation");

        hrtable.setModel(new javax.swing.table.DefaultTableModel(data_hr,header_hr));
        jScrollPane2.setViewportView(hrtable);

        jLabel7.setText("Human Resource Requirement :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField5)
                                    .addComponent(jTextField4)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(submitbutton)))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, 0, 403, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField1, jTextField2, jTextField4, jTextField5});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, jLabel6});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, 0, 147, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(submitbutton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

private void submitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitbuttonActionPerformed
try{
    int num_rows_hr,num_rows_phy;
    num_rows_hr=hrtable.getModel().getRowCount();
    num_rows_phy=phytable.getModel().getRowCount();
    int i=0,flag_hr=0,flag_phy=0;
    String phyres_name,temp,temp1;
    Object phyres_n,hrres_n;
    String hrres_name;
    int phyres_qty,hrres_qty;
    DBquery hr_phy =new DBquery();
    int phy_id;
    String query,query1;
    while(i<num_rows_phy)
    {
   phyres_n=phytable.getValueAt(i, 0);
   phyres_name= (String) phyres_n;
   phyres_n=phytable.getValueAt(i, 1);
   temp = (String) phyres_n;
   query="SELECT res_id FROM phy_resource WHERE res_name ="+"'"+phyres_name + "'";
   phyres_qty= Integer.parseInt(temp);
   ResultSet phy_result = hr_phy.generalQuery("SELECT * FROM available_phy "); 
   ResultSet phyid =hr_phy.generalQuery(query);
   phyid.next();
   phy_id = phyid.getInt(1);
   while(phy_result.next())
   {
       if(phy_result.getInt(1)==phy_id)
       {
           if(phy_result.getInt(2)<phyres_qty)
           {
               flag_phy=1;
           }
       }
   }
       
    
  }
    i=0;
    int spec_id;
while(i<num_rows_hr)
{
 hrres_n=hrtable.getValueAt(i, 0);
 hrres_name =(String) hrres_n;
 hrres_n=hrtable.getValueAt(i, 1);
 temp1= (String) hrres_n;
 hrres_qty=Integer.parseInt(temp1);
 query1="SELECT spec_id FROM specialisation WHERE spec_name=" + "'" + hrres_name +"'";
 ResultSet hr_result = hr_phy.generalQuery("SELECT specid,avail_qty FROM hr_total_avail");
 ResultSet specid =hr_phy.generalQuery(query1);
 specid.next();
 spec_id=specid.getInt(1);
 while(hr_result.next())
 {
     if(hr_result.getInt(1)==spec_id)
     {
         if(hr_result.getInt(2)<hrres_qty)
         {
          flag_hr=1;   
         }
     }
 }
}

}
catch(Exception ex)
{
    System.out.println("Exception at Ppanel sql :");
   
}
}//GEN-LAST:event_submitbuttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable hrtable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable phytable;
    private javax.swing.JButton submitbutton;
    // End of variables declaration//GEN-END:variables
}


class test4{
    public static void main(String args[]){
        javax.swing.JFrame f = new javax.swing.JFrame();
        Ppanel p = new Ppanel();
        p.setVisible(true);
        f.add(p);
        f.pack();
        f.show();
        
    }
}