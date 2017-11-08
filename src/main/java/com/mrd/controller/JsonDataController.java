package com.mrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.mrd.entity.Product;
import com.mrd.service.ProductService;
import java.util.Set;
@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductService productDAO;
	

	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsList() {		
		return productDAO.listProducts();
				
	}	
	

	@RequestMapping("/show/user/{user_id}/products")
	@ResponseBody
	public Set<Product> getProductsByRestaurant(@PathVariable Integer user_id) {
		
		return productDAO.listProduct(user_id);
				
	}
}
