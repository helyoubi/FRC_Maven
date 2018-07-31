package com.frc.managedbean;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;


import javax.faces.bean.ManagedBean;


import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;

import com.frc.model.Prelevement_saisons;
import com.frc.services.PrelevementServices;
import com.frc.services.PrelevementServicesImpl;

import org.primefaces.model.chart.ChartSeries;
 
@ManagedBean
public class ChartViewPersonnaliserDE implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BarChartModel barModel;
    
    private LineChartModel lineModel2;
    
    private PrelevementServices prelevServ = new PrelevementServicesImpl();
    
    private Prelevement_saisons prlvSaison = new Prelevement_saisons();
 
    @PostConstruct
    public void init() {
        createBarModels();
      
    }
    
    public LineChartModel getLineModel2() {
        return lineModel2;
    }
    
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     

    public Prelevement_saisons getPrlvSaison() {
		return prlvSaison;
	}

	public void setPrlvSaison(Prelevement_saisons prlvSaison) {
		this.prlvSaison = prlvSaison;
	}
	
	
	private void createLineModels() {
       
         
        lineModel2 = initCategoryModel();
        lineModel2.setTitle("Analyse des prélèvements linéaire");
        lineModel2.setLegendPosition("e");
        lineModel2.setShowPointLabels(true);
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Saison"));
        Axis yAxis = lineModel2.getAxis(AxisType.Y);
        yAxis.setLabel("prélèvements");
        yAxis.setMin(0);
        
        //Retourne le max des attributions pour le mettre dans le max d'échelle
        
        Object valueMax = prelevServ.attributionMaxValue(prlvSaison.getDepartement(), prlvSaison.getEspece());
        
        yAxis.setMax(valueMax);
        
    }
	
	private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        ChartSeries attribution = new ChartSeries();
        attribution.setLabel("Attributions");
        
        List<Object[]> listParcourirAttb = prelevServ.attributionPersonnaliserDE(prlvSaison.getDepartement(), prlvSaison.getEspece());
        
        for(Object[] obj : listParcourirAttb){
        	
        	String att = String.valueOf(obj[1]);
        	
        	Integer attINT = Integer.parseInt(att);
        	
        	attribution.set(String.valueOf(obj[0]), attINT);
        	
        }
        
 
        ChartSeries realisation = new ChartSeries();
        realisation.setLabel("Réalisations");

        List<Object[]> listParcourirRealis = prelevServ.realisationPersonnaliserDE(prlvSaison.getDepartement(), prlvSaison.getEspece());
        
        for(Object[] obj : listParcourirRealis){
        	
        	String real = String.valueOf(obj[1]);
        	
        	Integer realINT = Integer.parseInt(real);
        	
        	realisation.set(String.valueOf(obj[0]), realINT);
        	
        }
 
        model.addSeries(attribution);
        model.addSeries(realisation);
         
        return model;
    }
	

	private BarChartModel initBarModel() {
    	

        BarChartModel model = new BarChartModel();
 
        ChartSeries attribution = new ChartSeries();
        
        attribution.setLabel("Attributions");
        
        List<Object[]> listParcourirAttb = prelevServ.attributionPersonnaliserDE(prlvSaison.getDepartement(), prlvSaison.getEspece());
 
        for(Object[] obj : listParcourirAttb){
        	
        	String att = String.valueOf(obj[1]);
        	
        	Integer attINT = Integer.parseInt(att);
        	
        	attribution.set(String.valueOf(obj[0]), attINT);
        	
        }

        ChartSeries realisation = new ChartSeries();
        
        realisation.setLabel("Réalisations");


        List<Object[]> listParcourirRealis = prelevServ.realisationPersonnaliserDE(prlvSaison.getDepartement(), prlvSaison.getEspece());
        
        for(Object[] obj : listParcourirRealis){
        	
        	String real = String.valueOf(obj[1]);
        	
        	Integer realINT = Integer.parseInt(real);
        	
        	realisation.set(String.valueOf(obj[0]), realINT);
        	
        }
        
 
        model.addSeries(attribution);
        model.addSeries(realisation);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
        createLineModels();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Analyse des prélèvements en barre");
        barModel.setAnimate(true);
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Saison");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Prélèvement");
        yAxis.setMin(0);
        
        //Retourne le max des attributions pour le mettre dans le max d'échelle
        
        Object valueMax = prelevServ.attributionMaxValue(prlvSaison.getDepartement(), prlvSaison.getEspece());
   
        System.out.println("valeur est .. "+valueMax);
        
        yAxis.setMax(valueMax);
        
    }
     
    
    
    
 
}