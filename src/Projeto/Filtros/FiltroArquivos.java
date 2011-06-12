/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Projeto.Filtros;

/**
 *
 * @author laerton
 */

import java.io.File;
import java.util.ArrayList;

import javax.swing.filechooser.FileFilter;


 class ExtensionFileFilter extends FileFilter{

     private String description = "";

     private ArrayList<String> extensions = new ArrayList<String>();

    @Override
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

    @Override
     public String getDescription(){
         return description;
     }
     public void setDescription( String aDescription ){
         description = aDescription;
     }

 }
