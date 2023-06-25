package com.restApitoDb.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.restApitoDb.controller.fileUploadController;

@Component
public class fileuploadhelper {

//	public final static String UPLOAD_DIR = "C:\\Users\\ompra\\Documents\\workspace-spring-tool-suite-4-4.16.1.RELEASE\\RESTAPI_Handling_jdbc\\src\\main\\resources\\static\\img";
	public final String UPLOAD_DIR = new ClassPathResource("static/img/").getFile().getAbsolutePath();

	public fileuploadhelper() throws IOException {

	}

	public  boolean uploadFile(MultipartFile file) {
//		fileuploadhelpe helper = new fileuploadhelper();

		boolean f = false;
		try {

		InputStream is =	file.getInputStream();
		byte data[] = new byte[is.available()];
		
		is.read(data);
		
		//write
		FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.pathSeparator+file.getOriginalFilename());
		
		fos.write(data);
		fos.close();
		fos.flush();
//			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.pathSeparator + file.getOriginalFilename()),
//					StandardCopyOption.REPLACE_EXISTING);
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
