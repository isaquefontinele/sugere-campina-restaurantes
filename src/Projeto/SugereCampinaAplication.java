/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SugereCampinaAplication.java
 *
 * Created on 25/05/2011, 00:24:41
 */

package Projeto;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableColumn;
import org.jdesktop.application.Action;

/**
 * Contrutor do objeto SugereCampina Aplication - Este cria a janela principal da aplicação
 * @author Laerton, Isaque, ...
 */
@SuppressWarnings("serial")
public class SugereCampinaAplication extends javax.swing.JFrame {

    /** Creates new form SugereCampinaAplication */
    public SugereCampinaAplication() {
        initComponents();
        Ferramentas.setVisible(false);
        jPaienelDados.setVisible(false);
        
        
    }

    public void mostraPainelDados(){
    	Ferramentas.setVisible(true);
    	jPaienelDados.setVisible(true);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPaienelDados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboPerfil = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaOpinioes = new javax.swing.JTable();
        Ferramentas = new javax.swing.JToolBar();
        jBtNovoPerfil = new javax.swing.JButton();
        jBtRanking = new javax.swing.JButton();
        jBTPopular = new javax.swing.JButton();
        jBTPorPerfil = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sugere Campina");

        jPaienelDados.setName("jPaienelDados"); // NOI18N

        jLabel1.setText("Opiniöes de todos os usuários ");
        jLabel1.setName("jLabel1"); // NOI18N

        jComboPerfil.setName("jComboPerfil"); // NOI18N
        jComboPerfil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboPerfilItemStateChanged(evt);
            }
        });

        jLabel2.setText("Selecione um perfil:");
        jLabel2.setName("jLabel2"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTabelaOpinioes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", ""},
                {"", ""}
            },
            new String [] {
                "Estabelecimentos", "Votacao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaOpinioes.setToolTipText("Lista de votação do perfil selecionado"); // NOI18N
        jTabelaOpinioes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTabelaOpinioes.setName("jTabelaOpinioes"); // NOI18N
        jScrollPane1.setViewportView(jTabelaOpinioes);

        javax.swing.GroupLayout jPaienelDadosLayout = new javax.swing.GroupLayout(jPaienelDados);
        jPaienelDados.setLayout(jPaienelDadosLayout);
        jPaienelDadosLayout.setHorizontalGroup(
            jPaienelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaienelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaienelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPaienelDadosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(jComboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPaienelDadosLayout.setVerticalGroup(
            jPaienelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaienelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPaienelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Ferramentas.setFloatable(false);
        Ferramentas.setName("Ferramentas"); // NOI18N

        jBtNovoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/32/user.png"))); // NOI18N
        jBtNovoPerfil.setToolTipText("Cadastrar novo usuario");
        jBtNovoPerfil.setFocusable(false);
        jBtNovoPerfil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoPerfil.setName("jBtNovoPerfil"); // NOI18N
        jBtNovoPerfil.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoPerfilActionPerformed(evt);
            }
        });
        Ferramentas.add(jBtNovoPerfil);

        jBtRanking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/32/charts03.png"))); // NOI18N
        jBtRanking.setToolTipText("Mostrar a classificação dos restaurantes");
        jBtRanking.setName("jBtRanking"); // NOI18N
        jBtRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRankingActionPerformed(evt);
            }
        });
        Ferramentas.add(jBtRanking);

        jBTPopular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/32/star.png"))); // NOI18N
        jBTPopular.setToolTipText("Recomendações por popularidade");
        jBTPopular.setName("jBTPopular"); // NOI18N
        jBTPopular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTPopularActionPerformed(evt);
            }
        });
        Ferramentas.add(jBTPopular);

        jBTPorPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/32/group.png"))); // NOI18N
        jBTPorPerfil.setToolTipText("Recomendações por perfil");
        jBTPorPerfil.setFocusable(false);
        jBTPorPerfil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBTPorPerfil.setName("jBTPorPerfil"); // NOI18N
        jBTPorPerfil.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBTPorPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTPorPerfilActionPerformed(evt);
            }
        });
        Ferramentas.add(jBTPorPerfil);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/32/Cycle.png"))); // NOI18N
        jButton1.setToolTipText("Mostra a percentagem de acerto dos metodos de sugestões");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setName("jBCompara"); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Ferramentas.add(jButton1);

        fileMenu.setText("Arquivo");

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(SugereCampinaAplication.class, this);
        openMenuItem.setAction(actionMap.get("abrirJanelaArquivo")); // NOI18N
        fileMenu.add(openMenuItem);

        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/sair.png"))); // NOI18N
        exitMenuItem.setText("Sair do sistema");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Sobre");

        aboutMenuItem.setText("Creditos");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Ferramentas, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
            .addComponent(jPaienelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Ferramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPaienelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jComboPerfilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboPerfilItemStateChanged
        try {
            if ((jComboPerfil.getSelectedItem() != null)){
                 if (!(jComboPerfil.getSelectedItem().toString().equals(""))){
                    montaTabela(jComboPerfil.getSelectedItem().toString());
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(SugereCampinaAplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboPerfilItemStateChanged

    private void jBtRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRankingActionPerformed
        ranking.abrirJanelaRanking();
    }//GEN-LAST:event_jBtRankingActionPerformed

	private void jBTPopularActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBTPopularActionPerformed
		porPopularidade.abrirJanelaPorPopularidade();
	}

    private void jBTPorPerfilActionPerformed(java.awt.event.ActionEvent evt) {                                             
    	porPerfil.abrirJanelaPorPerfilActionPerformed(jComboPerfil.getSelectedItem().toString());
    }

    private void jBtNovoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoPerfilActionPerformed
        acoes.acionaNovoPerfil(sugere, janela1);
    }//GEN-LAST:event_jBtNovoPerfilActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        porPerfil.abriComparacoes();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void montaTabela (String usuario ) throws Exception{

        String[][] celulas =  acoes.povoaTabelaVotos(usuario);

    	String[] rotulos = {"Estabelecimento", "Voto"};
    	
    	jTabelaOpinioes.setModel(new javax.swing.table.DefaultTableModel(
    			celulas,rotulos) {
                @SuppressWarnings("rawtypes")
				Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false
                };

            @SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

            @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
    	

        TableColumn col = jTabelaOpinioes.getColumnModel().getColumn(0);
    int width = 580;
    col.setPreferredWidth(width);
    col = jTabelaOpinioes.getColumnModel().getColumn(1);
    width = 235;
    col.setPreferredWidth(width);
        
    }

    public void criaSugere(Usuarios usuarios, Estabelecimentos estabilizamento){
        
        try {
            popular = new SugerePopulares(usuarios, estabilizamento);
        } catch (IOException ex) {
            Mensagem.exibirMensagem(ex.getMessage());
        }
        try {
            sugerePorPefil = new SugerePorPerfil(usuarios, estabilizamento);
        } catch (IOException ex) {
            Mensagem.exibirMensagem(ex.getMessage());
        }
        try {
            sugere = new SugereCampina(usuarios, estabilizamento);
        } catch (IOException ex) {
            Mensagem.exibirMensagem(ex.getMessage());
        }

        porPopularidade = new AcoesBarraFerramentas(popular);
        porPerfil = new AcoesBarraFerramentas(sugerePorPefil);
        ranking = new AcoesBarraFerramentas(popular);
        acoes = new AcoesEmJanelas(sugere);

    }
    public void montaComboPerfis(){
    	acoes.montaComboPerfis(jComboPerfil);
    }
  
    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	janelaPrincipal = new SugereCampinaAplication();
                janela1 = new JanelaArquivo(janelaPrincipal);
                
                janelaPrincipal.setVisible(true);
                //janelaPrincipal.setExtendedState(MAXIMIZED_BOTH);
                CentralizaJanela.centralizaJanela(janelaPrincipal);
            }
        });
    }

    @Action
    public void abrirJanelaArquivo() {
    	CentralizaJanela.centralizaJanela(janela1);
        janela1.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar Ferramentas;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jBTPopular;
    private javax.swing.JButton jBTPorPerfil;
    private javax.swing.JButton jBtNovoPerfil;
    private javax.swing.JButton jBtRanking;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPaienelDados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaOpinioes;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    // End of variables declaration//GEN-END:variables
    private static JanelaArquivo janela1;
    private static SugereCampinaAplication janelaPrincipal;
    private AcoesBarraFerramentas porPopularidade;
    private AcoesBarraFerramentas porPerfil;
    private AcoesBarraFerramentas ranking;
    private SugereCampina sugere;
    private SugerePopulares popular;
    private SugerePorPerfil sugerePorPefil;
    //private JanelaNovoPerfil janelaNovoPerfil;
    private AcoesEmJanelas acoes;
    
}
