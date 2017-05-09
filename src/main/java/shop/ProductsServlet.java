package shop;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.service.ProductService;
import shop.zasoby.Products;
import shop.zasoby.ProductsList;

	@WebServlet(
	        name = "ProductsServlet",
	        urlPatterns = {"/products"}
	)
	public class ProductsServlet  extends HttpServlet {

		ProductService productsService = new ProductService();

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String action = req.getParameter("searchAction");
	        if (action!=null){
	            switch (action) {           
	            case "searchById":
	                searchProductsById(req, resp);
	                break;           
	            case "searchByName":
	                searchProductsByName(req, resp);
	                break;
	            }
	        }else{
	            List<Products> result = productsService.getAllEmployees();
	            forwardListProducts(req, resp, result);
	        }
	    }

	    private void searchProductsById(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        long idProducts = Integer.valueOf(req.getParameter("idProducts"));
	        Products products = null;
	        try {
	            products = productsService.getProducts(idProducts);
	        } catch (Exception ex) {
	            Logger.getLogger(ProductsServlet.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        req.setAttribute("proucts", products);
	        req.setAttribute("action", "edit");
	        String nextJSP = "/jsp/new-products.jsp";
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
	        dispatcher.forward(req, resp);
	    }
	    
	    private void searchProductsByName(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        String productsName = req.getParameter("productsName");
	        List<Products> result = productsService.searchProductsByName(productsName);        
	        forwardListProducts(req, resp, result);
	    }

	    private void forwardListProducts(HttpServletRequest req, HttpServletResponse resp, List productsList)
	            throws ServletException, IOException {
	        String nextJSP = "/jsp/list-products.jsp";
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
	        req.setAttribute("productsList", productsList);
	        dispatcher.forward(req, resp);
	    }   
	    

	}



