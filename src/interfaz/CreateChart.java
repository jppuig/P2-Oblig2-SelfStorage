// Juan Pedro Puig - 281088
// Nicolás Valsecchi - 192765

package interfaz;

import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.util.Rotation;
import dominio.Sistema;
import java.util.*;

// https://www.youtube.com/watch?v=E8jPNKxOk50 
 
public class CreateChart extends JFrame implements Observer {
    private Sistema modelo;
    
    public CreateChart(String appTitle, Sistema unModelo){
        modelo = unModelo;
        modelo.addObserver(this);
                
        update(null, null);
    }
    
    public void update(Observable o, Object obj) {
        PieDataset dataSet = createDataset();
        JFreeChart chart = createChart(dataSet, "Depositos Alquilados: " + modelo.getListaContratos().size());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500,300));
        setContentPane(chartPanel);
        chartPanel.setVisible(false);
        chartPanel.setVisible(true);
    }
    
    private PieDataset createDataset(){
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Refrigerados con Estantes: " + modelo.filtrarContratosPorDepositos(true, true).size(), modelo.filtrarContratosPorDepositos(true, true).size());
        result.setValue("Refrigerados sin Estantes: " + modelo.filtrarContratosPorDepositos(false, true).size(), modelo.filtrarContratosPorDepositos(false, true).size());
        result.setValue("No Refrigerados con Estantes: " + modelo.filtrarContratosPorDepositos(true, false).size() , modelo.filtrarContratosPorDepositos(true, false).size());
        result.setValue("No Refrigerados sin Estantes: " + modelo.filtrarContratosPorDepositos(false, false).size() , modelo.filtrarContratosPorDepositos(false, false).size());
        
        return result;
    }
    
    private JFreeChart createChart(PieDataset dataset, String title){
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);
        
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(0);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.9f);
        return chart;
    }
}