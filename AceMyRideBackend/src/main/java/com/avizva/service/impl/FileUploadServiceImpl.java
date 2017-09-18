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

	private final String fileDir = "/var/AceMyRide/productImages/";

	private boolean saveFile(Path path, byte[] file) {
		try {
			Files.write(path, file);
		} catch (IOException e) {
			LOGGER.error(e);
			return false;
		}
		return true;
	}

	@Override
	public String uploadProductImage(Product product, MultipartFile file) {
		if (file.isEmpty()){
			LOGGER.info("Empty image file");
			return "";
		}
		Path path = FileSystems.getDefault()
				.getPath(fileDir + "product" + product.getProductId() + file.getOriginalFilename());
		try {
			if (saveFile(path, file.getBytes())) {
				LOGGER.info("FIle saved successfully");
				return path.toString();
			}
		} catch (IOException e) {
			LOGGER.error(e);
		}
		return "";
	}

}
