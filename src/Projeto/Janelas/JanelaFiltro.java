/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JanelaFiltro.java
 *
 * Created on 11/06/2011, 17:36:24
 */

package Projeto.Janelas;

import Projeto.enuns.TipoDePrato;
import Projeto.enuns.TiposDeFiltros;
import Projeto.acoes.Mensagem;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 
 * @author Laerton
 */
public class JanelaFiltro extends javax.swing.JFrame {
	static LinkedHashSet<String> listaFiltros = new LinkedHashSet<String>();
        LinkedHashSet<String> listaProvisoria = new LinkedHashSet<String>();
	/** Creates new form JanelaFiltro */
	public JanelaFiltro() {
		initComponents();
		montaComboTiposFiltros();
		montaComboTiposDeRefeicoes();
		atualizaLista();
                listaProvisoria = (LinkedHashSet<String>) listaFiltros.clone();
		jCTipoRestaurante.setVisible(false);
		jLComboTipo.setVisible(false);
		JTxtTermo.setVisible(true);
		jLTxtTermo.setVisible(true);
	}

	private void montaComboTiposFiltros() {
		TiposDeFiltros[] lista = TiposDeFiltros.values();
		jCFiltros.setModel(new javax.swing.DefaultComboBoxModel(lista));
	}

	private void montaComboTiposDeRefeicoes() {
		TipoDePrato[] lista = TipoDePrato.values();
		jCTipoRestaurante.setModel(new javax.swing.DefaultComboBoxModel(lista));
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCFiltros = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLTxtTermo = new javax.swing.JLabel();
        JTxtTermo = new javax.swing.JTextField();
        jCTipoRestaurante = new javax.swing.JComboBox();
        jLComboTipo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLFiltros = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jBOk = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jBAdd = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jLInforma = new javax.swing.JLabel();
        jBRemoveAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filtros");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jCFiltros.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item1", "Item2", "Item3" }));
        jCFiltros.setName("jCFiltros"); // NOI18N
        jCFiltros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                exibeInformacao(evt);
            }
        });

        jLabel1.setText("Tipo de filtros:");
        jLabel1.setName("jLabel1"); // NOI18N

        jLTxtTermo.setText("Termo para busca:");
        jLTxtTermo.setName("jLTxtTermo"); // NOI18N

        JTxtTermo.setName("JTxtTermo"); // NOI18N

        jCTipoRestaurante.setName("jCTipoRestaurante"); // NOI18N

        jLComboTipo.setText("Tipo de restaurante:");
        jLComboTipo.setName("jLComboTipo"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jLFiltros.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "um", "dois", "tres" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jLFiltros.setName("jLFiltros"); // NOI18N
        jScrollPane1.setViewportView(jLFiltros);

        jLabel4.setText("Lista de filtros adicionados:");
        jLabel4.setName("jLabel4"); // NOI18N

        jBOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/Spell.png"))); // NOI18N
        jBOk.setToolTipText("Ok");
        jBOk.setName("jBOk"); // NOI18N
        jBOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOkActionPerformed(evt);
            }
        });

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/menos.png"))); // NOI18N
        jBRemove.setToolTipText("Remove o filtro selecionado");
        jBRemove.setName("jBRemove"); // NOI18N
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/add.png"))); // NOI18N
        jBAdd.setToolTipText("Adiciona um filtro na lista de filtros");
        jBAdd.setName("jBAdd"); // NOI18N
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/fechar.png"))); // NOI18N
        jBCancelar.setToolTipText("Cancelar");
        jBCancelar.setName("jBCancelar"); // NOI18N
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jLInforma.setFont(new java.awt.Font("Dialog", 0, 10));
        jLInforma.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLInforma.setName("jLInforma"); // NOI18N

        jBRemoveAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/Delete.png"))); // NOI18N
        jBRemoveAll.setToolTipText("Remove todos os filtros");
        jBRemoveAll.setName("jBRemoveAll"); // NOI18N
        jBRemoveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLInforma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLComboTipo)
                            .addComponent(jLTxtTermo)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JTxtTermo, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(jCTipoRestaurante, javax.swing.GroupLayout.Alignment.LEADING, 0, 230, Short.MAX_VALUE)
                            .addComponent(jCFiltros, 0, 230, Short.MAX_VALUE)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRemoveAll, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBOk, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTxtTermo)
                    .addComponent(JTxtTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLComboTipo)
                    .addComponent(jCTipoRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLInforma, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBOk))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jBRemoveAll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBRemove, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBAdd, javax.swing.GroupLayout.Alignment.LEADING))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
            listaFiltros = (LinkedHashSet<String>) listaProvisoria.clone();
            atualizaLista();
            dispose();

        }//GEN-LAST:event_jBCancelarActionPerformed

        private void jBOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBOkActionPerformed
            listaProvisoria = (LinkedHashSet<String>) listaFiltros.clone();
            atualizaLista();
            dispose();
        }//GEN-LAST:event_jBOkActionPerformed

        private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
           
        }//GEN-LAST:event_formFocusGained

        private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
           
        }//GEN-LAST:event_formWindowActivated

        private void jBRemoveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveAllActionPerformed
            listaFiltros.clear();
            atualizaLista();
        }//GEN-LAST:event_jBRemoveAllActionPerformed

	private void exibeInformacao(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_exibeInformacao
		TiposDeFiltros tipo = (TiposDeFiltros) jCFiltros.getSelectedItem();
		jLInforma.setText(tipo.getTipo());
		switch (tipo) {
		case PALAVRA_CHAVE:
			jCTipoRestaurante.setVisible(false);
			jLComboTipo.setVisible(false);
			JTxtTermo.setVisible(true);
			jLTxtTermo.setVisible(true);
			break;
		case ENDEREÇO:
			jCTipoRestaurante.setVisible(false);
			jLComboTipo.setVisible(false);
			JTxtTermo.setVisible(true);
			jLTxtTermo.setVisible(true);
			break;
		case TIPO_DE_REFEIÇÃO:
			jCTipoRestaurante.setVisible(true);
			jLComboTipo.setVisible(true);
			JTxtTermo.setVisible(false);
			jLTxtTermo.setVisible(false);
			break;
		}
	}// GEN-LAST:event_exibeInformacao

	private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBAddActionPerformed
		TiposDeFiltros tipo = (TiposDeFiltros) jCFiltros.getSelectedItem();
		String informativo = null;
		switch (tipo) {
		case PALAVRA_CHAVE:
			informativo = JTxtTermo.getText();
			JTxtTermo.setText("");
			break;
		case ENDEREÇO:
			informativo = JTxtTermo.getText();
			JTxtTermo.setText("");
			break;
		case TIPO_DE_REFEIÇÃO:
			TipoDePrato tipoDeFiltro = (TipoDePrato) jCTipoRestaurante
					.getSelectedItem();
			informativo = tipoDeFiltro.getTipo();
			break;

		}
		if (informativo != null) {
			if (!(informativo.equals(""))) {
				if (!(listaFiltros.toString().contains(TiposDeFiltros.TIPO_DE_REFEIÇÃO.getRotulo()))) {
                                            
                                            listaFiltros.add(tipo.getRotulo() + ":" + informativo);
                                            atualizaLista();
				} else {
					Mensagem.exibirMensagem("Não pode ser adicionado mais de um filtro do tipo de prato");
				}
			} else {
				Mensagem.exibirMensagem("Não pode ser informado um termo nulo.");
			}
		} else {
			Mensagem.exibirMensagem("Não pode ser informado um termo em branco");
		}

	}// GEN-LAST:event_jBAddActionPerformed
	public static  String[] getListaDeFiltros(){
		String[] itens = new String[listaFiltros.size()];
		Iterator<String> it = (Iterator<String>) listaFiltros.iterator();
		int contador = 0;
		while (it.hasNext()) {
			itens[contador] = it.next();
			contador += 1;
		}
		return itens;
	}
	
	private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBRemoveActionPerformed
		if (listaFiltros.size() > 0) {
			if (jLFiltros.getSelectedValue() != null) {
				listaFiltros.remove(jLFiltros.getSelectedValue());
				atualizaLista();

			} else {
				Mensagem.exibirMensagem("Deve selecionar um item antes.");
			}
		}else{
			Mensagem.exibirMensagem("A lista de filtros esta vazia.");
		}
	}// GEN-LAST:event_jBRemoveActionPerformed

	private void atualizaLista() {
		final String[] itens = getListaDeFiltros();
		jLFiltros.setModel(new javax.swing.AbstractListModel() {
			String[] strings = itens;

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new JanelaFiltro().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTxtTermo;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBOk;
    private javax.swing.JButton jBRemove;
    private javax.swing.JButton jBRemoveAll;
    private javax.swing.JComboBox jCFiltros;
    private javax.swing.JComboBox jCTipoRestaurante;
    private javax.swing.JLabel jLComboTipo;
    private javax.swing.JList jLFiltros;
    private javax.swing.JLabel jLInforma;
    private javax.swing.JLabel jLTxtTermo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
