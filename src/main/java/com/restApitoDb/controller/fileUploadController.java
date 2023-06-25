package com.restApitoDb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restApitoDb.helper.fileuploadhelper;

@RestController
public class fileUploadController {
	@Autowired
	private fileuploadhelper helper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile file) {

//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());
//		System.out.println(file.isEmpty());
		try {
			// validation
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request must contain file");
			}
			if (!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("only JPEG allowed");
			}

			// upload file.

			boolean f = true;
			try {
				helper.uploadFile(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (f) {
//				return ResponseEntity.ok("file is sucessfully uploaded");
				
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("img/").path(file.getOriginalFilename()).toUriString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong, try again");
	}

}
