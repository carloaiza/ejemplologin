/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplologin.utilidades;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import ejemplologin.modelo.Materia;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cloaiza
 */
public class EjemploTablaItextPdf {

    public static final String DESTINO = "./pdfs/prog1/ejemplo_tabla.pdf";

    public static void main(String... args) {
        try {
            File archivo = new File(DESTINO);
            archivo.getParentFile().mkdirs();
            EjemploTablaItextPdf ejemplo = new EjemploTablaItextPdf();
            ejemplo.crearDocumentoPdf(DESTINO);
            //ejemplo.abrirEjemplotabla();            
            ejemplo.abrirEjemplotabla2();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void crearDocumentoPdf(String destino) throws Exception {

        PdfDocument documento = new PdfDocument(new PdfWriter(destino));
        Document doc = new Document(documento);
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

        Table tabla = new Table(8);
        for (int i = 0; i < 6; i++) {
            Cell cell = new Cell().add(new Paragraph("Hola campeones")
                    .setFont(font)
                    .setFontColor(ColorConstants.WHITE));
            cell.setBackgroundColor(ColorConstants.BLUE);
            cell.setBorder(Border.NO_BORDER);
            cell.setTextAlignment(TextAlignment.CENTER);
            tabla.addCell(cell);
            //Crea celda con string
            //tabla.addCell("Prog 1");
        }
        doc.add(tabla);
        doc.close();

    }

    public void abrirEjemplotabla() {
        try {
            File archivo = new File(DESTINO);
            Desktop.getDesktop().open(archivo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
    
    public void abrirDocumento(String ruta) {
        try {
            File archivo = new File(ruta);
            Desktop.getDesktop().open(archivo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
    

    public void abrirEjemplotabla2() {
        try {
            File archivo = new File(DESTINO);
            Runtime.getRuntime().exec("cmd /c start " + archivo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    private Cell obtenerCeldaEncabezado(String texto) throws IOException 
    {
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        Cell celda = new Cell().add(new Paragraph(texto)
                .setFont(font)
                .setFontColor(ColorConstants.WHITE));
        celda.setBackgroundColor(ColorConstants.BLUE);
        celda.setBorder(Border.NO_BORDER);
        celda.setTextAlignment(TextAlignment.CENTER);
        return celda;
    }

    public void crearDocumentoPdfMaterias(String destino, List<Materia> listado) throws Exception {
        File archivo = new File(destino);
        archivo.getParentFile().mkdirs();
        PdfDocument documento = new PdfDocument(new PdfWriter(destino));
        Document doc = new Document(documento);      

        Table tabla = new Table(3);        
        tabla.addCell(obtenerCeldaEncabezado("Código"));        
        tabla.addCell(obtenerCeldaEncabezado("Nombre"));
        tabla.addCell(obtenerCeldaEncabezado("Capacidad"));
        
        for(Materia mat: listado)
        {
            tabla.startNewRow();
            tabla.addCell(mat.getCodigo());
            tabla.addCell(mat.getNombre());
            tabla.addCell(String.valueOf(mat.getCapacidadAlumnos()));
        }
               /*

        for (int i = 0; i < 6; i++) {
            Cell cell = new Cell().add(new Paragraph("Hola campeones")
                    .setFont(font)
                    .setFontColor(ColorConstants.WHITE));
            cell.setBackgroundColor(ColorConstants.BLUE);
            cell.setBorder(Border.NO_BORDER);
            cell.setTextAlignment(TextAlignment.CENTER);
            tabla.addCell(cell);
            //tabla.startNewRow();
            //Crea celda con string
            //tabla.addCell("Prog 1");
        }
*/
        doc.add(tabla);
        doc.close();

    }

}
