package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class EnufPartsValidator implements ConstraintValidator<ValidEnufParts, Product> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidEnufParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        if (context == null) return true;
        if (context != null) myContext = context;

        ProductService productService = myContext.getBean(ProductServiceImpl.class);

        if (product.getId() != 0) {
            Product existingProduct = productService.findById((int) product.getId());

            for (Part part : existingProduct.getParts()) {
                // Check if any part's inventory would fall below minimum if the product is made
                if (part.getInv() - 1 < part.getMinimumInventory()) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean validatePartsInventory(Product product){
        int totalPartInventory = 0;

        ProductService productService = myContext.getBean(ProductServiceImpl.class);

        if (product.getId() != 0) {
            Product currentProduct = productService.findById((int) product.getId());
            if(currentProduct.getParts().isEmpty()){
                return true;
            }
            for (Part part : currentProduct.getParts()) {
                totalPartInventory += part.getInv();
            }
            return product.getInv() <= totalPartInventory;
        }

        return true;
    }

}
