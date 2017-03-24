package com.mkyong.common.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.mkyong.common.form.FileUploadForm;

public class FileUploadAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
            
            //Unrestricted file upload
            FileUploadForm fileUploadForm = (FileUploadForm)form;
            FormFile file = fileUploadForm.getFile();
		
            //Get the servers upload directory real path name
	    String filePath = getServlet().getServletContext().getRealPath("/") +"upload";
	    
	    //create the upload folder if not exists
	    File folder = new File(filePath);
	    if(!folder.exists()){
	    	folder.mkdir();
	    }
	   
            String fileName = file.getFileName();
            String comment = fileUploadForm.getComment();
	    
	    if(!("").equals(fileName)){  
	    	
	        System.out.println("Server path: " +filePath);
	        File newFile = new File(filePath, fileName);
              
	        if(!newFile.exists()){
	          FileOutputStream fos = new FileOutputStream(newFile);
	          fos.write(file.getFileData());
	          fos.flush();
	          fos.close();
	        }  
	        
	        request.setAttribute("uploadedFilePath",newFile.getAbsoluteFile());
	        request.setAttribute("uploadedFileName",newFile.getName());
                
	    }
            
            //arbitrary file reading
            String output="";
            String readfile = fileUploadForm.getReadfile();
            if(!("").equals(readfile)){
                File f=new File(filePath, readfile);
                FileInputStream fs = new FileInputStream(f);
                InputStreamReader in = new InputStreamReader(fs);
                BufferedReader br = new BufferedReader(in);
        	
                String line;
                while ((line = br.readLine()) != null) {
                    output = output + line + "\n<br>";
                } 
                br.close();
            }
           
            request.setAttribute("readfile",output);
            // XSS
            request.setAttribute("comment",comment);
            return mapping.findForward("success");
	}
	
}