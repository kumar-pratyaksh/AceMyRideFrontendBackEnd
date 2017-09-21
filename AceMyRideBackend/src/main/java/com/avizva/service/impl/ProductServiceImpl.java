package com.avizva.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.avizva.dao.ProductDao;
import com.avizva.model.CartItem;
import com.avizva.model.Product;
import com.avizva.service.FileUploadService;
import com.avizva.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	public Product saveProduct(Product product,MultipartFile file) {
		product.setDescription(product.getDescription().trim());
		product.setEnabled(true);
		String imagePath=fileUploadService.uploadProductImage(product,file);//check
		product.setImagePath(imagePath);
		Product savedProduct=productDao.save(product);
		return savedProduct;
	}
	
	public List<Product> getAllProducts()
	{
		List<Product> completeList=productDao.viewAll();
		return completeList.stream().filter(product -> product.isEnabled()).collect(Collectors.toList());
	}
	
	public Product updateProduct(Product product, MultipartFile file) {
		if (file == null || file.isEmpty()) {
			Product savedProduct=productDao.view(product.getId());
			product.setImagePath(savedProduct.getImagePath());
		}else{
			product.setImagePath(fileUploadService.uploadProductImage(product, file));
		}
		product.setEnabled(true);
		Product updatedProduct=productDao.update(product);
		return updatedProduct;
	}

	public boolean deleteProduct(int id) {
		Product deletedProduct = productDao.delete(id);
		if (deletedProduct == null)
			return false;
		return true;
	}

	public Product getProduct(int id) {
		return productDao.view(id);
	}

	public Product getProduct(String productId) {
		return productDao.view(productId);
	}

	public List<Product> getProductUsingCategory(String categoryName) {
		List<Product> completeList = productDao.getCategorizedProduct(categoryName);
		return completeList.stream().filter(product -> product.isEnabled()).collect(Collectors.toList());
	}

	@Override
	public void removeProductFromStock(List<CartItem> cartItems) {
		cartItems.stream().forEach(cartItem -> {
			Product product = cartItem.getProduct();
			product.setInStock(product.getInStock() - cartItem.getQuantity());
			productDao.update(product);
		});

	}
	

}
