package mx.ipn.escom.enfermeria.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import mx.ipn.escom.enfermeria.entity.Medicamento;
import mx.ipn.escom.enfermeria.entity.Material;
import mx.ipn.escom.enfermeria.repository.MedicamentoRepository;
import mx.ipn.escom.enfermeria.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReporteService {

    private final MedicamentoRepository medicamentoRepository;
    private final MaterialRepository materialRepository;

    public ReporteService(MedicamentoRepository medicamentoRepository,
                          MaterialRepository materialRepository) {
        this.medicamentoRepository = medicamentoRepository;
        this.materialRepository = materialRepository;
    }

    public byte[] generarReporteInventario() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, baos);

            document.open();

            // Título
            Font tituloFont = new Font(Font.HELVETICA, 16, Font.BOLD);
            Paragraph titulo = new Paragraph("Reporte de Inventario de Enfermería", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Este reporte muestra un resumen de medicamentos y materiales registrados en el sistema."));
            document.add(new Paragraph(" "));

            // ===================== MEDICAMENTOS =====================
            List<Medicamento> medicamentos = medicamentoRepository.findAll();

            Font subtituloFont = new Font(Font.HELVETICA, 14, Font.BOLD);
            Paragraph subtituloMeds = new Paragraph("Medicamentos", subtituloFont);
            document.add(subtituloMeds);
            document.add(new Paragraph(" "));

            PdfPTable tablaMeds = new PdfPTable(4); // nombre, stock, estado, caducidad
            tablaMeds.setWidthPercentage(100);

            agregarHeader(tablaMeds, "Nombre");
            agregarHeader(tablaMeds, "Stock");
            agregarHeader(tablaMeds, "Estado");
            agregarHeader(tablaMeds, "Fecha caducidad");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            for (Medicamento m : medicamentos) {
                tablaMeds.addCell(celda(m.getNomMedi()));
                tablaMeds.addCell(celda(m.getStockMedi()));
                tablaMeds.addCell(celda(m.getEstadoMedi()));
                String cad = (m.getFechaCadMedi() != null) ? m.getFechaCadMedi().format(formatter) : "-";
                tablaMeds.addCell(celda(cad));
            }

            document.add(tablaMeds);
            document.add(new Paragraph(" "));

            // ===================== MATERIALES =====================
            List<Material> materiales = materialRepository.findAll();

            Paragraph subtituloMat = new Paragraph("Materiales", subtituloFont);
            document.add(subtituloMat);
            document.add(new Paragraph(" "));

            PdfPTable tablaMat = new PdfPTable(4); // nombre, stock, estado, fecha compra
            tablaMat.setWidthPercentage(100);

            agregarHeader(tablaMat, "Nombre");
            agregarHeader(tablaMat, "Stock");
            agregarHeader(tablaMat, "Estado");
            agregarHeader(tablaMat, "Fecha compra");

            for (Material mat : materiales) {
                tablaMat.addCell(celda(mat.getNomMaterial()));
                tablaMat.addCell(celda(mat.getStockMaterial()));
                tablaMat.addCell(celda(mat.getEstadoMaterial()));
                tablaMat.addCell(celda(mat.getFechaCompraMaterial()));
            }

            document.add(tablaMat);

            document.close();
            return baos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar el PDF", e);
        }
    }

    private void agregarHeader(PdfPTable table, String texto) {
        Font headerFont = new Font(Font.HELVETICA, 12, Font.BOLD);
        PdfPCell header = new PdfPCell(new Phrase(texto, headerFont));
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(header);
    }

    private PdfPCell celda(String texto) {
        PdfPCell cell = new PdfPCell(new Phrase(texto != null ? texto : "-"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        return cell;
    }
}
