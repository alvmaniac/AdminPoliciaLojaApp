package com.adminPoliciaLoja.app.dao.jpa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.adminPoliciaLoja.app.common.VariablesStatic;
import com.adminPoliciaLoja.app.dao.inter.EmailInter;


@Stateless
public class EmailImpl implements EmailInter{
	
	@Resource(name="java:/jboss/mail/gmail")
	private Session session; 
	@Override
	public void envioEmail(String deploy, String template, Map<String, String> param) {
		MimeMessage message = new MimeMessage(this.session);
        try {
           //Set email data 
           message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(param.get("TO")));
           if(param.get("BCC")!=null)
        	   message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(param.get("BCC")));
           message.setSubject(param.get("SUBJECT"), "UTF-8");
           MimeMultipart multipart = new MimeMultipart();
           BodyPart messageBodyPart = new MimeBodyPart();
           
           //HTML mail content
           String htmlText = readEmailFromHtml(htmlPath(deploy,template),param);
           messageBodyPart.setContent(htmlText, "text/html; charset=UTF-8");
           multipart.addBodyPart(messageBodyPart);
           
           messageBodyPart = new MimeBodyPart();
           DataSource fds = new FileDataSource(imagePath(deploy,VariablesStatic.EMAIL_IMAGE_HEADER));
           messageBodyPart.setDataHandler(new DataHandler(fds));
           messageBodyPart.setHeader("Content-ID", "<logo>");
           
           
           multipart.addBodyPart(messageBodyPart); 
           message.setContent(multipart);

           //Conect to smtp server and send Email
           Transport.send(message);
       }catch (MessagingException ex) {
    	   ex.printStackTrace();
       }catch (Exception ae) {
    	   ae.printStackTrace();
       }    
	}
	
	
	//Method to replace the values for keys
	protected String readEmailFromHtml(String filePath, Map<String, String> input){
	    String msg = readContentFromFile(filePath);
	    try{
		    Set<Entry<String, String>> entries = input.entrySet();
		    for(Map.Entry<String, String> entry : entries) {
		    	if (entry.getKey().startsWith("{")) 
		    		msg = msg.replace(entry.getKey().trim(), entry.getValue().trim());
		    }
	    }catch(Exception exception){
	        exception.printStackTrace();
	    }
	    return msg;
	}
	
	//Method to read HTML file as a String 
	private String readContentFromFile(String fileName){
	    StringBuffer contents = new StringBuffer();
	    try {
	      //use buffering, reading one line at a time
	      BufferedReader reader =  new BufferedReader(new FileReader(fileName));
	      try {
	        String line = null; 
	        while (( line = reader.readLine()) != null){
	          contents.append(line);
	          contents.append(System.getProperty("line.separator"));
	        }
	      }finally {
	          reader.close();
	      }
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    }
	    return contents.toString();
	}

	private String imagePath(String deploy,String archivo) {
		StringBuffer template = new StringBuffer();
		template.append(deploy);
		template.append(System.getProperty("file.separator"));
		template.append("resources");
		template.append(System.getProperty("file.separator"));
		template.append("imagenes");
		template.append(System.getProperty("file.separator"));
		template.append(archivo);
		return template.toString();
	}
	
	private String htmlPath(String deploy,String archivo) {
		StringBuffer template = new StringBuffer();
		template.append(deploy);
		template.append(System.getProperty("file.separator"));
		template.append("resources");
		template.append(System.getProperty("file.separator"));
		template.append("email");
		template.append(System.getProperty("file.separator"));
		template.append(archivo);
		return template.toString();
	}
	
}
