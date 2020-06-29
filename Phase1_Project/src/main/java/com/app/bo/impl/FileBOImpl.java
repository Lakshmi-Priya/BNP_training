package com.app.bo.impl;

import java.util.*;
import com.app.bo.*;
import com.app.model.Filename;
import com.app.exception.*;

import java.io.File;
import java.io.IOException;

//A comparator class which implements Comparator<String>
class FileComparator implements Comparator<String>{
	 
	@Override
	public int compare(String o1, String o2) {
		return o1.toLowerCase().compareTo(o2.toLowerCase());
	}
}

public class FileBOImpl implements FileBO    {
	
	String message="";
	
	//Implementation to arrange files in ascending order
	@Override
	public List<Filename> ascOrder() {
		  List<Filename> filenames = new ArrayList<Filename>();
		  File files = new File("C:\\");	
	      String[] files_array = files.list();
	      Arrays.sort(files_array, new FileComparator());
	      for (int i=0;i<files_array.length;i++) {
		    	Filename s = new Filename();
		        s.setFilenames(files_array[i]);
		        filenames.add(s);
		}
		return filenames;
	}
	
	//Implementation to add the file in the mentioned directory
	@Override
	public String addFile(String s,String dir) throws BusinessException, IOException {
		
		File file = new File("C:\\"+dir+"\\"+s);  
		boolean success;  
			
				success = file.createNewFile(); 
				if(success){  
					message="File added";}  
				else{  
					throw new BusinessException("File already exists in this location");} 
				return message;
			       
		 }

	//Implementation to delete the file from the mentioned directory
	@Override
	public String deleteFile(String s,String dir) throws BusinessException,IOException{
		
		File d = new File("C:\\"+dir);
		if(d.isDirectory())
		{
			File f= new File("C:\\"+dir+"\\"+s);           
			if(f.delete()){  
				message=(f.getName() + " deleted");}  
			else{  
				throw new BusinessException("File not found");} 
		}
		else
		{
			throw new IOException();
		}
		
		return message;
		}

	//Implementation to search for a file/directory
	@Override
	public String search(String s) {
		  boolean exists = false;
		  List<Filename> filenames = new ArrayList<Filename>();
		  File files = new File("C:\\");	
	      String files_array[] = files.list();
	      Arrays.sort(files_array);
	      for (int i=0;i<files_array.length;i++) {
		    	Filename s1 = new Filename();
		        s1.setFilenames(files_array[i]);
		        filenames.add(s1);}
	     for(int i=0;i<filenames.size();i++){
	    	  if(filenames.get(i).getFilenames().equals(s)){
	    		  exists=true;
	    		  break;}
	      }
	     
	      if(exists){
	    	  message="File/Directory exists";}
	      else{
	    	  message="File/Directory doesn't exists";
	      }return message;}
	
	
	      
}
