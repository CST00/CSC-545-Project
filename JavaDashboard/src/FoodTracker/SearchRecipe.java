package FoodTracker;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import java.util.*;

public class SearchRecipe extends javax.swing.JFrame {

    Connection conn = null;
    OraclePreparedStatement pst = null;
    OracleResultSet rs = null;
    
    ArrayList<String> ingredients = new ArrayList<>();
    ArrayList<String> recipeCats = new ArrayList<>();
    
    public void doOnLoad() {
        conn = ConnectDb.setupConnection();
        try {
            //get arraylist of all ingredients
            String sqlStatement = "SELECT * FROM Ingredient";
            pst = (OraclePreparedStatement) conn.prepareStatement(sqlStatement);
            rs = (OracleResultSet) pst.executeQuery();

            while(rs.next()) {
                String inName = rs.getString("ingredientName");
                if(!ingredients.contains(inName))
                    ingredients.add(inName);
            }

            //get arraylist of all recipe categories
            sqlStatement = "SELECT * FROM Recipe";
            pst = (OraclePreparedStatement) conn.prepareStatement(sqlStatement);
            rs = (OracleResultSet) pst.executeQuery();

            while(rs.next()) {
                String cat = rs.getString("category");
                if(!recipeCats.contains(cat))
                    recipeCats.add(cat);
            }

            //set default
            IngredientRadioButton.setSelected(true);
            SearchRecipe1ComboBox.removeAllItems();
            ingredients.forEach((i) -> {
                SearchRecipe1ComboBox.addItem(i);
            });
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            ConnectDb.close(rs);
            ConnectDb.close(pst);
            ConnectDb.close(conn);
        }
    }
    
    public SearchRecipe() {
        initComponents();
        doOnLoad();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        SearchRecipePanel1 = new javax.swing.JPanel();
        SearchRecipe1BackButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        IngredientRadioButton = new javax.swing.JRadioButton();
        CategoryRadioButton = new javax.swing.JRadioButton();
        SearchRecipe1ComboBox = new javax.swing.JComboBox<>();
        SearchRecipe1SearchButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        SearchRecipePanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        SearchRecipe2BackButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SearchRecipe2TextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        SearchRecipe1BackButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        SearchRecipe1BackButton.setText("Back");
        SearchRecipe1BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchRecipe1BackButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search by ingredient or recipe category");

        buttonGroup1.add(IngredientRadioButton);
        IngredientRadioButton.setSelected(true);
        IngredientRadioButton.setText("Ingredient");
        IngredientRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngredientRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(CategoryRadioButton);
        CategoryRadioButton.setText("Recipe Category");
        CategoryRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryRadioButtonActionPerformed(evt);
            }
        });

        SearchRecipe1ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchRecipe1ComboBoxActionPerformed(evt);
            }
        });

        SearchRecipe1SearchButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        SearchRecipe1SearchButton.setText("Search");
        SearchRecipe1SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchRecipe1SearchButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Select what category you want to search for, then specify what item to search with");

        javax.swing.GroupLayout SearchRecipePanel1Layout = new javax.swing.GroupLayout(SearchRecipePanel1);
        SearchRecipePanel1.setLayout(SearchRecipePanel1Layout);
        SearchRecipePanel1Layout.setHorizontalGroup(
            SearchRecipePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchRecipePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SearchRecipePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchRecipe1SearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(SearchRecipePanel1Layout.createSequentialGroup()
                        .addComponent(SearchRecipe1BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
                    .addGroup(SearchRecipePanel1Layout.createSequentialGroup()
                        .addGroup(SearchRecipePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SearchRecipePanel1Layout.createSequentialGroup()
                                .addGroup(SearchRecipePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CategoryRadioButton)
                                    .addComponent(IngredientRadioButton))
                                .addGap(49, 49, 49)
                                .addComponent(SearchRecipe1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        SearchRecipePanel1Layout.setVerticalGroup(
            SearchRecipePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchRecipePanel1Layout.createSequentialGroup()
                .addGroup(SearchRecipePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchRecipePanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchRecipePanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(SearchRecipe1BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(108, 108, 108)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(SearchRecipePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SearchRecipePanel1Layout.createSequentialGroup()
                        .addComponent(IngredientRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(CategoryRadioButton))
                    .addComponent(SearchRecipe1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(SearchRecipe1SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(SearchRecipePanel1, "card2");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Search Results");

        SearchRecipe2BackButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        SearchRecipe2BackButton.setText("Back");
        SearchRecipe2BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchRecipe2BackButtonActionPerformed(evt);
            }
        });

        SearchRecipe2TextArea.setColumns(20);
        SearchRecipe2TextArea.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        SearchRecipe2TextArea.setRows(5);
        jScrollPane1.setViewportView(SearchRecipe2TextArea);

        javax.swing.GroupLayout SearchRecipePanel2Layout = new javax.swing.GroupLayout(SearchRecipePanel2);
        SearchRecipePanel2.setLayout(SearchRecipePanel2Layout);
        SearchRecipePanel2Layout.setHorizontalGroup(
            SearchRecipePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchRecipePanel2Layout.createSequentialGroup()
                .addGroup(SearchRecipePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(SearchRecipePanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(SearchRecipePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchRecipe2BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE))))
                .addContainerGap())
        );
        SearchRecipePanel2Layout.setVerticalGroup(
            SearchRecipePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchRecipePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchRecipe2BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(SearchRecipePanel2, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchRecipe1BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchRecipe1BackButtonActionPerformed
        this.setVisible(false);
        new LandingPage().setVisible(true);
    }//GEN-LAST:event_SearchRecipe1BackButtonActionPerformed

    Boolean isIngredient = true;
    private void IngredientRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngredientRadioButtonActionPerformed
        isIngredient = true;
        SearchRecipe1ComboBox.removeAllItems();
        ingredients.forEach((i) -> {
            SearchRecipe1ComboBox.addItem(i);
        });
    }//GEN-LAST:event_IngredientRadioButtonActionPerformed

    private void CategoryRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryRadioButtonActionPerformed
        isIngredient = false;
        SearchRecipe1ComboBox.removeAllItems();
        recipeCats.forEach((c) -> {
            SearchRecipe1ComboBox.addItem(c);
        });
    }//GEN-LAST:event_CategoryRadioButtonActionPerformed

    String selectedSearch = "";
    private void SearchRecipe1ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchRecipe1ComboBoxActionPerformed
        if(SearchRecipe1ComboBox.getSelectedItem() != null)
            selectedSearch = SearchRecipe1ComboBox.getSelectedItem().toString();
    }//GEN-LAST:event_SearchRecipe1ComboBoxActionPerformed

    private void SearchRecipe1SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchRecipe1SearchButtonActionPerformed
        SearchRecipePanel1.setVisible(false);
        SearchRecipePanel2.setVisible(true);
        if(isIngredient) { //find all recipes containing this ingredient
            conn = ConnectDb.setupConnection();
            try {
                //get arraylist of all recipes with this ingredient
                String sqlStatement = "select * from Needs where ingredientName=?";
                pst = (OraclePreparedStatement) conn.prepareStatement(sqlStatement);
                pst.setString(1, selectedSearch);
                rs = (OracleResultSet) pst.executeQuery();

                SearchRecipe2TextArea.removeAll();
                while(rs.next())
                    SearchRecipe2TextArea.append(rs.getString("recipeName") + "\n");
            }
            catch (Exception e) {
                System.out.println(e);
            }
            finally {
                ConnectDb.close(rs);
                ConnectDb.close(pst);
                ConnectDb.close(conn);
            }
        }
        else { //find all recipes in this category
            conn = ConnectDb.setupConnection();
            try {
                //get arraylist of all recipes with this category
                String sqlStatement = "select * from Recipe where category=? ";
                pst = (OraclePreparedStatement) conn.prepareStatement(sqlStatement);
                pst.setString(1, selectedSearch);
                rs = (OracleResultSet) pst.executeQuery();

                SearchRecipe2TextArea.removeAll();
                while(rs.next())
                    SearchRecipe2TextArea.append(rs.getString("recipeName") + "\n");
            }
            catch (Exception e) {
                System.out.println(e);
            }
            finally {
                ConnectDb.close(rs);
                ConnectDb.close(pst);
                ConnectDb.close(conn);
            }
        }
    }//GEN-LAST:event_SearchRecipe1SearchButtonActionPerformed

    private void SearchRecipe2BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchRecipe2BackButtonActionPerformed
        this.setVisible(false);
        new LandingPage().setVisible(true);
    }//GEN-LAST:event_SearchRecipe2BackButtonActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchRecipe().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton CategoryRadioButton;
    private javax.swing.JRadioButton IngredientRadioButton;
    private javax.swing.JButton SearchRecipe1BackButton;
    private javax.swing.JComboBox<String> SearchRecipe1ComboBox;
    private javax.swing.JButton SearchRecipe1SearchButton;
    private javax.swing.JButton SearchRecipe2BackButton;
    private javax.swing.JTextArea SearchRecipe2TextArea;
    private javax.swing.JPanel SearchRecipePanel1;
    private javax.swing.JPanel SearchRecipePanel2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
