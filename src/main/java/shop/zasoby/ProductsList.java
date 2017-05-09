package shop.zasoby;

import java.util.ArrayList;
import java.util.List;


public class ProductsList {
    private static final List<Products> productsList = new ArrayList();
    
    private ProductsList(){
    }
    
    static{
    	productsList.add(new Products("name","category","cost","quantity"));
    	productsList.add(new Products("Laura","Adams","02-11-1979","Manager"));
        productsList.add(new Products("Peter","Williams","22-10-1966","Coordinator"));
    }
    
    public static List <Products> getInstance(){
        return productsList;
    }
}
 