package com.example.productsservices.controller;


import com.example.productsservices.model.Product;
import jakarta.annotation.security.PermitAll;
import org.springframework.web.bind.annotation.*;

@RestController
@PermitAll
@RequestMapping(value="/products")
public class ProductRestController {

	@PermitAll
	@GetMapping()
	public Product getProduct(@RequestParam String id, @RequestParam(defaultValue = "false") Boolean throwError) {
		if (throwError){
			throw new RuntimeException();
		}
		return new Product(id,"Notebook",2000.0,"Instance 1");

	}


}