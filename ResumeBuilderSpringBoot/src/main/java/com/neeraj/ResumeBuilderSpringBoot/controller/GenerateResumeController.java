package com.neeraj.ResumeBuilderSpringBoot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.neeraj.ResumeBuilderSpringBoot.service.GenerateResumeDAO;

@RestController
@CrossOrigin(origins="*")
public class GenerateResumeController 
{
	
	@Autowired
	GenerateResumeDAO generateResumeDAO;

	@GetMapping("/generate/{id}")
	public ResponseEntity generateResume(@PathVariable("id") int id) throws IOException
	{
		String message=generateResumeDAO.getResume(id);
      // String message=generateResumeDAO.postResume(id);
		
		System.out.println("This is inside Generate Resume Controller");
		
		String fileName="N:\\Core Java\\"+message+".pdf";
		
		File file=new File(fileName);
		
		InputStreamResource resource=new InputStreamResource(new FileInputStream(file));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition",
				String.format("attachment; filename=\"%s\"", file.getName())); // inline; filename  <== file will show on the browser
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/pdf")).body(resource);

		return responseEntity;   
	}
	 
	
/*	@GetMapping("/download/{id}")
	public ResponseEntity generate(@PathVariable("id") int id) throws FileNotFoundException
	{
		String message=generateResumeDAO.postResume(id);
		
		String fileName="N:\\Core Java\\"+message+".pdf";
		
		File file=new File(fileName);
		
		InputStreamResource resource=new InputStreamResource(new FileInputStream(file));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition",
				String.format("inline; filename=\"%s\"", file.getName())); // attachment; filename  <== it will download directly
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/pdf")).body(resource);

		return responseEntity;
	
	}
	*/
}
