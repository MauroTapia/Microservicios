package com.digitalhouse.checkout.controller;

import java.util.List;
import java.util.Map;

import jakarta.annotation.security.PermitAll;
import org.springframework.web.bind.annotation.*;

import com.digitalhouse.checkout.model.Checkout;
import com.digitalhouse.checkout.service.ICheckoutService;



@RestController
@PermitAll
@RequestMapping(value="/checkout")
public class CheckoutRestController {
	private ICheckoutService checkoutService;

	public CheckoutRestController(ICheckoutService checkoutService) {
		super();
		this.checkoutService = checkoutService;
	}

	@PermitAll
	@GetMapping("/{id}")
	public Checkout getById(@PathVariable String id){
		return new Checkout(id);
	}

	@GetMapping()
	@PermitAll
	public Checkout getCheckout(@RequestParam List<String> productIds,@RequestHeader(name = "X-Request-from", defaultValue = "") String requestFrom,@RequestHeader() Map<String,String> headers) {
		System.out.println("Enviado desde: "+ requestFrom);
		if(!requestFrom.equals("gateway")) {
			return null;
		}
		return checkoutService.buildCheckout(productIds);

	}

}