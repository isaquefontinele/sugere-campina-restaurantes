/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JanelaArquivo.java
 *
 * Created on 25/05/2011, 00:24:58
 */

package Projeto;

//import com.sun.xml.internal.ws.api.message.Message;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author laerton, Isaque, ....
 */
public class JanelaArquivo extends javax.swing.JFrame {

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JanelaArquivo(janelaPrincipal).setVisible(true);
            }
        });

         
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtArquivo1;
    private javax.swing.JButton jBtArquivo2;
    private javax.swing.JButton jBtConectar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTxtOpinioes;
    private javax.swing.JTextField jtxtEstabelecimentos;
    // End of variables declaration//GEN-END:variables
    private String urlEstabeleciemnto;
    private String urlOpinioes;

    private JFileChooser janelaDeArquivos1;
    private final static ExtensionFileFilter filter = new ExtensionFileFilter();
    private ManipulaPesquisa pesquisa;
    private ManipulaRestaurante restaurante;
    private static SugereCampinaAplication janelaPrincipal;
    /** Creates new form JanelaArquivo */
    @SuppressWarnings("static-access")
    public JanelaArquivo(SugereCampinaAplication janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    	initComponents();
        filter.addExtension("data");
        filter.addExtension("csv");
        filter.setDescription("Arquivos de dados");
    }
    public String getEnderecoOpinioes (){
        return jTxtOpinioes.getText();
    }
    //Cria um obj do tipo JFileChooser para uma janela de  dialogo de abertura de arquivo
    //Retorna o emdereço completo do arquivo
    private String abrirJanela(){
        janelaDeArquivos1 = new JFileChooser();
        janelaDeArquivos1.setFileFilter(filter);
        int resultado = janelaDeArquivos1.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) { // Usuario escolheu um arquivo
            String endereco = null;
            try {
                endereco = janelaDeArquivos1.getSelectedFile().toURL().toString().replace("file:", "");
            } catch (Exception e) {
                Mensagem.exibirMensagem("Nao foi localizado arquivo.");
            }
        if (endereco != null){
            return endereco;
        }

    }
        return "";
    }
    //Cria os objetos dos arquivos e seta SugereCampina na janela principal
    private void conectaArquivos() throws IOException {
        	pesquisa = new ManipulaPesquisa(jTxtOpinioes.getText());
			restaurante = new ManipulaRestaurante(jtxtEstabelecimentos.getText());
			janelaPrincipal.criaSugereCampina(new SugereCampina(pesquisa, restaurante));
		
    }
    public ManipulaPesquisa getPesuisa (){
        return pesquisa;
    }
    public ManipulaRestaurante getRestaurante (){
        return restaurante;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtEstabelecimentos = new javax.swing.JTextField();
        jTxtOpinioes = new javax.swing.JTextField();
        jBtArquivo1 = new javax.swing.JButton();
        jBtArquivo2 = new javax.swing.JButton();
        jBtConectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecao de arquivos");
        setIconImages(null);

        jLabel1.setText("Digite ou selecione a origem dos dados abaixo.");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText("Arquivo de origem dos dados dos estabelecimentos:");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText("Arquivo de origem dos dados da pesquisa:");
        jLabel3.setName("jLabel3"); // NOI18N

        jtxtEstabelecimentos.setName("jtxtEstabelecimentos"); // NOI18N

        jTxtOpinioes.setName("jTxtOpinioes"); // NOI18N

        jBtArquivo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/abrir.png"))); // NOI18N
        jBtArquivo1.setText("Arquivo");
        jBtArquivo1.setName("jBtArquivo1"); // NOI18N
        jBtArquivo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtArquivo1ActionPerformed(evt);
            }
        });

        jBtArquivo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/abrir.png"))); // NOI18N
        jBtArquivo2.setText("Arquivo");
        jBtArquivo2.setName("jBtArquivo2"); // NOI18N
        jBtArquivo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtArquivo2ActionPerformed(evt);
            }
        });

        jBtConectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Icones/Spell.png"))); // NOI18N
        jBtConectar.setText("Conectar");
        jBtConectar.setName("jBtConectar"); // NOI18N
        jBtConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtOpinioes, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                                    .addComponent(jtxtEstabelecimentos, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtArquivo1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(jBtArquivo2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtEstabelecimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtArquivo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtOpinioes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtArquivo2))
                .addGap(26, 26, 26)
                .addComponent(jBtConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jBtArquivo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtArquivo1ActionPerformed
        jtxtEstabelecimentos.setText(abrirJanela());
    }//GEN-LAST:event_jBtArquivo1ActionPerformed
    private void jBtArquivo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtArquivo2ActionPerformed
            jTxtOpinioes.setText(abrirJanela());
    }//GEN-LAST:event_jBtArquivo2ActionPerformed
    public void jBtConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConectarActionPerformed
        
    	if (!(jTxtOpinioes.getText().equals("") || jtxtEstabelecimentos.getText().equals(""))){
            try {
				conectaArquivos();
                                //Linhas qua atualiza os dados na janela principal
				janelaPrincipal.mostraPainelDados();
				janelaPrincipal.povoaComboPerfis();
				setVisible(false);
			} catch (IOException e) {
				Mensagem.exibirMensagem(e.getMessage());
			}
			
        }else{
        	Mensagem.exibirMensagem("Voce deve selecionar primeiro um arquivo.");
        }
        
    }//GEN-LAST:event_jBtConectarActionPerformed
}
