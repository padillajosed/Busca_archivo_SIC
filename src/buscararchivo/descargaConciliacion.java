package buscararchivo;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author jpadilla
 */
public class descargaConciliacion {
     /**
     * Tipo de contrato
     */    
    String contractType = "910";
    /**
     * Número de contrato
     */
    String contractNum = "00070201525";
    /**
     * Consecutivo de contrato
     */
    String contractCons = "001";
    
         public void descargaConciliacion() throws Exception{
          
          try{
    
    SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
    String fechaInicio = "2019/08/28";
    Date fechaInicio1 = sdf.parse(fechaInicio);
    
    String nombreArchivo = "SIC"
                     + contractType + contractNum + contractCons
                     + "_" + sdf.format(fechaInicio1).replace("/", ""); //+ "*.txt";
    
    System.out.println("\nNombre del Archivo: " +nombreArchivo);
    
     String rutaDirectorio = "C:/Users/Jpadilla/Documents/Jose Padilla/";
     
        File directory = new File(rutaDirectorio);
     
            List<File> archivos = new ArrayList<>();

                   String regex = nombreArchivo.concat("*.TXT").replace(".", "\\.");
                           regex = regex.replace("*", ".*");

                           System.out.println("\nNombre del Archivo con Expresion Regular: " +regex);
                           
             for (File fileAux : directory.listFiles()) {
 
                 if (fileAux.getName().matches(regex)) {
 
                     archivos.add(fileAux);
 
                 }
             }
                          
            System.out.println("\nArchivos: " +archivos);
              
          } catch (ParseException e){
              
              throw e;
          }
}
    
}
