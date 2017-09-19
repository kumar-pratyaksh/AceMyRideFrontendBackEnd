package com.avizva.service.impl;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.avizva.model.Product;
import com.avizva.service.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	private static final Logger LOGGER = LogManager.getLogger();

	private final String fileDir = "/tmp/AceMyRide/productImages/";

	private boolean saveFile(Path path, byte[] file) {
		try {
			Files.write(path, file);
		} catch (IOException e) {
			LOGGER.error(e);
			return false;
		}
		return true;
	}

	
	public String uploadProductImage(Product product, MultipartFile file) {
		if (file.isEmpty()){
			LOGGER.info("Empty image file");
			return "";
		}
		String fileName = product.getProductId() + (int) (Math.random() * 100000) + file.getOriginalFilename();
		Path path = FileSystems.getDefault()
				.getPath(fileDir + fileName);
		try {
			if (saveFile(path, file.getBytes())) {
				LOGGER.info("File saved successfully");
				return fileName;
			}
		} catch (IOException e) {
			LOGGER.error(e);
		}
		return "";
	}

}
