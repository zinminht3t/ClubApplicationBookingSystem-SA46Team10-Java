package iss.sa46team12.springclub.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import iss.sa46team12.springclub.models.Bookings;
import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.ReportService;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
public class ReportController {
	
	@Autowired
	ReportService rService;
	
	//@RequestMapping(value = "/reports", method = RequestMethod.GET)
	//public String load() {		
	//	return "reports";
	//}
	
	/*@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public int maleNum() {
		int a = rService.findNumOfMales();
		return a;
	}*/
	
	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public ModelAndView findMaleNumControl() {
		ModelAndView mav = new ModelAndView("reports");
		
		//gender report
		int a = rService.findNumOfMales();
		int b = rService.findNumOfFemales();
		
		//bookings per facility report
		int c = rService.findNumOfBookingsFacil1();
		int d = rService.findNumOfBookingsFacil2();
		int e = rService.findNumOfBookingsFacil3();
		int f = rService.findNumOfBookingsFacil4();
		
		//facilities under active maintenance report
		int g = rService.findNumActMainFacil1();
		int h = rService.findNumActMainFacil2();
		int i = rService.findNumActMainFacil3();
		int j = rService.findNumActMainFacil4();
		
		mav.addObject("maleNum", a);
		mav.addObject("femaleNum", b);
		
		mav.addObject("bookingsFacil1", c);
		mav.addObject("bookingsFacil2", d);
		mav.addObject("bookingsFacil3", e);
		mav.addObject("bookingsFacil4", f);
		
		mav.addObject("actMainFacil1", g);
		mav.addObject("actMainFacil2", h);
		mav.addObject("actMainFacil3", i);
		mav.addObject("actMainFacil4", j);
		
		return mav;
	}
	
	 @RequestMapping(value = "/reports/report1", method = RequestMethod.GET)
	 @ResponseBody
	 public void getRpt1(HttpServletResponse response) throws IOException, JRException, SQLException {
		 	
		 	//created in no small part thanks to:
		 	//https://stackoverflow.com/questions/3746649/jasperreports-how-to-call-the-report-in-jsp-page
		 
		 	//To obtain the file stream thing. The jrxml file has to be compiled to a jasper file (do it in Spring itself)
		    InputStream jasperStream = this.getClass().getResourceAsStream("/jasperReports/report1.jasper");
		    //I don't really know what this does...
		    Map<String,Object> params = new HashMap<>();
		    //This creates a connection object to push sql data to the file stream
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/team12cabproject?user=root&password=password");
		    //This loads the jasper report from the file stream
		    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		    //This connects the connection to the jasper report
		    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);
		    
		    //this starts the process to be able to generate a pdf report straight from the webpage
		    response.setContentType("application/x-pdf");
		    response.setHeader("Content-disposition", "inline; filename=report1.pdf");

		    //the final output is a pdf file created in the temp folder of the comp used
		    OutputStream outStream = response.getOutputStream();
		    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		  }
	 
	 @RequestMapping(value = "/reports/report2", method = RequestMethod.GET)
	 @ResponseBody
	 public void getRpt2(HttpServletResponse response) throws IOException, JRException, SQLException {
		 	
		    InputStream jasperStream = this.getClass().getResourceAsStream("/jasperReports/report1.jasper");
		    Map<String,Object> params = new HashMap<>();
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/team12cabproject?user=root&password=password");
		    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);
		    
		    response.setContentType("application/x-pdf");
		    response.setHeader("Content-disposition", "inline; filename=report1.pdf");

		    OutputStream outStream = response.getOutputStream();
		    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		  }
	 
	 @RequestMapping(value = "/reports/report3", method = RequestMethod.GET)
	 @ResponseBody
	 public void getRpt3(HttpServletResponse response) throws IOException, JRException, SQLException {
		 	
		    InputStream jasperStream = this.getClass().getResourceAsStream("/jasperReports/report1.jasper");
		    //I don't really know what this does...
		    Map<String,Object> params = new HashMap<>();
		    //This creates a connection object to push sql data to the file stream
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/team12cabproject?user=root&password=password");
		    //This loads the jasper report from the file stream
		    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		    //This connects the connection to the jasper report
		    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);
		    
		    //this starts the process to be able to generate a pdf report straight from the webpage
		    response.setContentType("application/x-pdf");
		    response.setHeader("Content-disposition", "inline; filename=report1.pdf");

		    //the final output is a pdf file created in the temp folder of the comp used
		    OutputStream outStream = response.getOutputStream();
		    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		  }
}