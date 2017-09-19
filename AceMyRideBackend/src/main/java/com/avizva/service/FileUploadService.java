package com.avizva.service;

import org.springframework.web.multipart.MultipartFile;

import com.avizva.model.Product;

public interface FileUploadService {

	public String uploadProductImage(Product product, MultipartFile file);

}
