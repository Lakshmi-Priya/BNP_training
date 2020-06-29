package com.app.bo;
import java.util.*;
import java.io.*;

import com.app.exception.BusinessException;
import com.app.model.*;

public interface FileBO {
	/*
	 * The following interface contains the abstract methods to be implemented
	 * ascOrder() to print files/directories in ascending order
	 * addFile(String s,String dir) to add file in the mentioned directory
	 * deleteFile(String s,String dir) to delete file in the mentioned directory
	 * search(String s) to search for file/directory in root
	 * 
	 * */
	public List<Filename> ascOrder();
	public String addFile(String s,String dir) throws BusinessException, IOException;
	public String deleteFile(String s,String dir)throws  BusinessException, IOException;
	public String search(String s);
	

}
