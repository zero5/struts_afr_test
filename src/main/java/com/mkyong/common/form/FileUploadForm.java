package com.mkyong.common.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class FileUploadForm extends ActionForm{
	
	private FormFile file;
        public String readfile;
        public String comment;
	
	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

        public String getReadfile() {
		return readfile;
	}
        
        public void setReadfile(String readfile) {
		this.readfile = readfile;
	}
        
        public String getComment() {
		return comment;
	}
        
        public void setComment(String comment) {
		this.comment = comment;
	}
                
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		ActionErrors errors = new ActionErrors();
	      
	    return errors;
	}
	
}