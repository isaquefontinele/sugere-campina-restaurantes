/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Projeto;

/**
 *
 * @author laerton
 */
 import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;

 class ExtensionFileFilter extends FileFilter{

     private String description = "";

     private ArrayList<String> extensions = new ArrayList<String>();

     public boolean accept( File f ){

         if ( f.isDirectory() )
             return true;

         String name = f.getName().toLowerCase();

         for( String extension : extensions )
             if( name.endsWith(extension))
                 return true;

         return false;
     }

     public void addExtension( String extension ){
         if( !extension.startsWith("."))
             extension = "." + extension;

         extensions.add( extension.toLowerCase() );
     }

     public String getDescription(){
         return description;
     }
     public void setDescription( String aDescription ){
         description = aDescription;
     }

 }

 public class FileChooseTeste {
     public static void main(String[] args) {

         ImageViewerFrame frame = new ImageViewerFrame();
         frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
         frame.setVisible( true );

     }
     private ManipulaRestaurante restaurante;

     private ManipulaPesquisa pesuisa;

 }

 class FileIconView extends FileView{

     private FileFilter filter;

     private Icon icon;

     public FileIconView( FileFilter aFilter, Icon anIcon ){
         filter = aFilter;
         icon = anIcon;
     }
     public Icon getIcon( File f ){
         if( !f.isDirectory() && filter.accept(f) )
             return icon;
         else
             return null;
     }

 }

 class ImagePreviewer extends JLabel {

     public ImagePreviewer( JFileChooser chooser ){

         setPreferredSize( new Dimension( 100, 100 ) );
         setBorder( BorderFactory.createEtchedBorder() );

         chooser.addPropertyChangeListener( new PropertyChangeListener(){
             public void propertyChange( PropertyChangeEvent event ){

                 if( event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY )
                 {
                     File f = ( File ) event.getNewValue();

                     if ( f == null )
                     {
                         setIcon( null );
                         return;
                     }

                     ImageIcon icon = new ImageIcon(f.getPath());

                     if( icon.getIconWidth() > getWidth() )
                         icon = new ImageIcon( icon.getImage().getScaledInstance( getWidth(), -1, Image.SCALE_DEFAULT ) );

                     setIcon(icon);
                 }
             }
         });
     }
 }

 class ImageViewerFrame extends JFrame{

     private class FileOpenListener implements ActionListener{

         public void actionPerformed( ActionEvent event ){

             chooser.setCurrentDirectory( new File("."));

             int result = chooser.showOpenDialog( ImageViewerFrame.this );

             if( result == JFileChooser.APPROVE_OPTION )
             {
                 String name = chooser.getSelectedFile().getPath();
                 //label.setIcon( new ImageIcon( name ));
                 
             }
         }

     }

     private JLabel label;

     private JFileChooser chooser;
     public static final int DEFAULT_WIDTH = 300;

     public static final int DEFAULT_HEIGHT = 400;
     public ImageViewerFrame(){

         setTitle("ImageViewerTeste");
         setSize( DEFAULT_WIDTH, DEFAULT_HEIGHT );

         JMenuBar menuBar = new JMenuBar();
         setJMenuBar( menuBar );

         JMenu menu = new JMenu("Abrir");
         menuBar.add( menu );

         JMenuItem openItem = new JMenuItem("Abrir");
         menu.add( openItem );
         openItem.addActionListener( new FileOpenListener() );

         JMenuItem exitItem = new JMenuItem("Sair");
         menu.add( exitItem );
         exitItem.addActionListener( new ActionListener(){
             public void actionPerformed( ActionEvent event ){
                 System.exit(0);
             }
         });

//         label = new JLabel();
//         add( label );

         chooser = new JFileChooser();

         // definir extenções de imagens visiveis

         final ExtensionFileFilter filter = new ExtensionFileFilter();
         filter.addExtension("data");
         filter.addExtension("cvs");
         filter.setDescription("Arquivos de dados");

         chooser.setFileFilter( filter );
         chooser.setAccessory( new ImagePreviewer(chooser));
         chooser.setFileView( new FileIconView( filter, new ImageIcon("palette.gif")));

     }
 }
