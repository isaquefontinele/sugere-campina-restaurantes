/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JanelaNovoPerfil.java
 *
 * Created on 28/05/2011, 20:58:04
 */

package Projeto;

import java.io.IOException;
import java.util.Arrays;
import javax.swing.table.TableColumn;

/**
 * 
 * @author laerton
 */
public class JanelaNovoPerfil extends javax.swing.JFrame {
    private SugerePopulares popular;
    private SugerePorPerfil sugerePorPefil;

	/** Creates new form JanelaNovoPerfil */
    @SuppressWarnings("static-access")
	public JanelaNovoPerfil(String nomeUsuario,Sugere sugere,JanelaArquivo janelaArquivo) {
		this.nomeUsuario = nomeUsuario;
                this.janelaArquivo = janelaArquivo;
                this.sugere = sugere;
		initComponents();
		jPEditaVoto.setVisible(false);
		jLabUsuario.setText(nomeUsuario);

//                ranking = new AcoesBarraFerramentas(sugere);
//                porPopularidade = new AcoesBarraFerramentas(sugere);
//                porPerfil = new AcoesBarraFerramentas(sugere);
//                acoes = new AcoesEmJanelas(sugere);
                criaSugere(sugere.getUsuarios(), sugere.getEstabelecimentos());
                itensTabela = acoes.povoaTabelaVotos(nomeUsuario);
                atualizaTabelaVotos();
                //povoaTabelaVotos();

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
        porPopularidade = new AcoesBarraFerramentas(popular);
        porPerfil = new AcoesBarraFerramentas(sugerePorPefil);
        ranking = new AcoesBarraFerramentas(popular);
        acoes = new AcoesEmJanelas(sugere);

    }
    	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jBTAltera = new javax.swing.JButton();
        jBTRanking = new javax.swing.JButton();
        jBTPorPopularidade = new javax.swing.JButton();
        jBTPorPerfil = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabVotos = new javax.swing.JTable();
        jPEditaVoto = new javax.swing.JPanel();
        jLabEstabelecimento = new javax.swing.JLabel();
        jCobVotos = new javax.swing.JComboBox();
        jBTProximo = new javax.swing.JButton();
        jBTOK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabUsuario = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jBTAddPerfil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo perfil de usuário");
        setResizable(false);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N
        jToolBar1.setOpaque(false);

        jBTAltera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/32/tool.png"))); // NOI18N
        jBTAltera.setToolTipText("Alterar voto");
        jBTAltera.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jBTAltera.setFocusable(false);
        jBTAltera.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBTAltera.setName("jBTAltera"); // NOI18N
        jBTAltera.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBTAltera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTAlteraActionPerformed(evt);
            }
        });
        jToolBar1.add(jBTAltera);

        jBTRanking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/32/charts03.png"))); // NOI18N
        jBTRanking.setToolTipText("Ranking");
        jBTRanking.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jBTRanking.setFocusable(false);
        jBTRanking.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBTRanking.setName("jBTRanking"); // NOI18N
        jBTRanking.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBTRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTRankingActionPerformed(evt);
            }
        });
        jToolBar1.add(jBTRanking);

        jBTPorPopularidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/32/star.png"))); // NOI18N
        jBTPorPopularidade.setToolTipText("Recomendações por popularidade");
        jBTPorPopularidade.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jBTPorPopularidade.setFocusable(false);
        jBTPorPopularidade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBTPorPopularidade.setName("jBTPorPopularidade"); // NOI18N
        jBTPorPopularidade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBTPorPopularidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTPorPopularidadeActionPerformed(evt);
            }
        });
        jToolBar1.add(jBTPorPopularidade);

        jBTPorPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/32/group.png"))); // NOI18N
        jBTPorPerfil.setToolTipText("Recomendações por perfil");
        jBTPorPerfil.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jBTPorPerfil.setFocusable(false);
        jBTPorPerfil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBTPorPerfil.setName("jBTPorPerfil"); // NOI18N
        jBTPorPerfil.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBTPorPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTPorPerfilActionPerformed(evt);
            }
        });
        jToolBar1.add(jBTPorPerfil);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/32/door.png"))); // NOI18N
        jButton1.setToolTipText("Sair");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTabVotos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Estabelecimento", "Voto"
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
        jTabVotos.setName("jTabVotos"); // NOI18N
        jScrollPane1.setViewportView(jTabVotos);

        jPEditaVoto.setName("jPEditaVoto"); // NOI18N

        jLabEstabelecimento.setText("Estabelecimento");
        jLabEstabelecimento.setName("jLabEstabelecimento"); // NOI18N

        jCobVotos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5: Incrível. sensacional. impressionante", "4: Muito bom", "3: Bastante bom", "2: É bonzinho", "1: Não é ruim", "0: Não conheço", "-1: Acho um pouco ruim", "-2: Acho ruim", "-3: Acho basntante ruim", "-4: Acho muito ruim", "-5: Detesto" }));
        jCobVotos.setName("jCobVotos"); // NOI18N

        jBTProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/Forward - Next.png"))); // NOI18N
        jBTProximo.setToolTipText("Exibe o proximo da lista e grava o atual");
        jBTProximo.setName("jBTProximo"); // NOI18N
        jBTProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTProximoActionPerformed(evt);
            }
        });

        jBTOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/Spell.png"))); // NOI18N
        jBTOK.setToolTipText("Grava a alteração do registro atual");
        jBTOK.setName("jBTOK"); // NOI18N
        jBTOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPEditaVotoLayout = new javax.swing.GroupLayout(jPEditaVoto);
        jPEditaVoto.setLayout(jPEditaVotoLayout);
        jPEditaVotoLayout.setHorizontalGroup(
            jPEditaVotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEditaVotoLayout.createSequentialGroup()
                .addComponent(jLabEstabelecimento, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addComponent(jCobVotos, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBTOK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBTProximo)
                .addContainerGap())
        );
        jPEditaVotoLayout.setVerticalGroup(
            jPEditaVotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEditaVotoLayout.createSequentialGroup()
                .addGroup(jPEditaVotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEditaVotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabEstabelecimento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCobVotos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBTProximo)
                    .addComponent(jBTOK))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Nome do usuário:");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabUsuario.setText("usuário");
        jLabUsuario.setName("jLabUsuario"); // NOI18N

        jToolBar2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.setName("jToolBar2"); // NOI18N
        jToolBar2.setOpaque(false);

        jBTAddPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/32/add_user.png"))); // NOI18N
        jBTAddPerfil.setToolTipText("Gravar novo perfil em arquivo");
        jBTAddPerfil.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 4, 9, 4));
        jBTAddPerfil.setFocusable(false);
        jBTAddPerfil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBTAddPerfil.setName("jBTAddPerfil"); // NOI18N
        jBTAddPerfil.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBTAddPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTAddPerfilActionPerformed(evt);
            }
        });
        jToolBar2.add(jBTAddPerfil);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPEditaVoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabUsuario)
                            .addComponent(jLabel2)))
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPEditaVoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void jBTPorPopularidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTPorPopularidadeActionPerformed
            porPopularidade.abrirJanelaPorPopularidade();
        }//GEN-LAST:event_jBTPorPopularidadeActionPerformed

        private void jBTOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTOKActionPerformed
           jBTAltera.setEnabled(true);
	   alteraLinhaTabVotos(jTabVotos.getSelectedRow(), jCobVotos.getSelectedItem().toString());
           jBTAddPerfil.setEnabled(true);
           jPEditaVoto.setVisible(false);
           jTabVotos.setEnabled(true);
        }//GEN-LAST:event_jBTOKActionPerformed

        private void jBTProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTProximoActionPerformed
            int linha = jTabVotos.getSelectedRow()+1;
            
            if(linha < jTabVotos.getRowCount()){
               jTabVotos.setEnabled(true);
               alteraLinhaTabVotos(jTabVotos.getSelectedRow(), jCobVotos.getSelectedItem().toString());
               jTabVotos.setRowSelectionInterval(linha , linha);
               ativaAlteraLinha(linha);
            }else{
               Mensagem.exibirMensagem("Não há mais estabelecimentos a avançar.");
               jBTOKActionPerformed(evt);
            }
        }//GEN-LAST:event_jBTProximoActionPerformed

        private void jBTAddPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTAddPerfilActionPerformed
        try {
            janelaArquivo.getPesuisa().appendLinha(montarLinhaGravacao());
            janelaArquivo.jBtConectarActionPerformed(evt);
            dispose();
        } catch (IOException ex) {
            Mensagem.exibirMensagem("Perfil não gravado \n" + ex.getMessage());
        }

        }//GEN-LAST:event_jBTAddPerfilActionPerformed

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            dispose();
        }//GEN-LAST:event_jButton1ActionPerformed
        
	private void jBTRankingActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		ranking.abrirJanelaRanking();
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jBTPorPerfilActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
        	porPerfil.abrirJanelaPorPerfilActionPerformed(recolheNotas());
	}// GEN-LAST:event_jButton4ActionPerformed

	private void jBTAlteraActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
            ativaAlteraLinha(jTabVotos.getSelectedRow());
       }// GEN-LAST:event_jButton2ActionPerformed
        
        public  void atualizaTabelaVotos(){
		jTabVotos.setModel(new javax.swing.table.DefaultTableModel(
				itensTabela,new String [] {"Estabelecimento", "Voto"}) {
	            Class[] types = new Class [] {
	                java.lang.String.class, java.lang.String.class
	            };
	            boolean[] canEdit = new boolean [] {
	                false, false
	            };

            @Override
	            public Class getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }

            @Override
	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });

		TableColumn col = jTabVotos.getColumnModel().getColumn(0);
		int width = 400;
		col.setPreferredWidth(width);
		col = jTabVotos.getColumnModel().getColumn(1);
		width = 235;
		col.setPreferredWidth(width);
	}

	private void alteraLinhaTabVotos(int linha, String novoValor){
		itensTabela[linha][1] = novoValor;
		atualizaTabelaVotos();
		jTabVotos.setEnabled(true);
	}

	private Integer[] recolheNotas (){
		Integer[] notas = new Integer[itensTabela.length];
		for (int i = 0; i < notas.length; i++) {
			notas[i] = Integer.valueOf(itensTabela[i][1].split(":")[0]);
		}
		return notas;
	}
    
        private String montarLinhaGravacao(){
            String[] votos = new String[itensTabela.length];
            String dataHora = DataHora.getDateHora();

            for (int i = 0; i < votos.length; i++) {
                votos[i] = itensTabela[i][1];
            }

        return ("\n" + dataHora + ";" + nomeUsuario + ";" + Arrays.toString(votos).replace(",", ";").replace("[", "").replace("]", ""));
        }

        private void ativaAlteraLinha(int linha){
           if (linha == -1){
                Mensagem.exibirMensagem("Você deve solucionar uma linha na tabela primeiro.");
            }else{
                jLabEstabelecimento.setText((String) jTabVotos.getValueAt(linha, 0));
                jCobVotos.setSelectedItem((String) jTabVotos.getValueAt(linha , 1));
                jBTAltera.setEnabled(false);
                jBTAddPerfil.setEnabled(false);
                jPEditaVoto.setVisible(true);
                jTabVotos.setEnabled(false);
            }
         }
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
			public void run() {
				new JanelaNovoPerfil(nomeUsuario,sugere, janelaArquivo).setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTAddPerfil;
    private javax.swing.JButton jBTAltera;
    private javax.swing.JButton jBTOK;
    private javax.swing.JButton jBTPorPerfil;
    private javax.swing.JButton jBTPorPopularidade;
    private javax.swing.JButton jBTProximo;
    private javax.swing.JButton jBTRanking;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jCobVotos;
    private javax.swing.JLabel jLabEstabelecimento;
    private javax.swing.JLabel jLabUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPEditaVoto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabVotos;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
    private AcoesBarraFerramentas ranking;
    private AcoesBarraFerramentas porPerfil;
    private AcoesBarraFerramentas porPopularidade;
    private static Sugere sugere;
    private static String nomeUsuario;
    private String[][] itensTabela;
    private static JanelaArquivo janelaArquivo;
    private AcoesEmJanelas acoes;
}
