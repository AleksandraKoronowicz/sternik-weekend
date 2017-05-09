<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
       <link rel="stylesheet" href="../css/bootstrap.min.css"/>         
       <script src="../js/bootstrap.min.js"></script>       
    </head>

    <body>          
        <div class="container">
            <h2>Products</h2>
            <!--Search Form -->
            <form action="/products" method="get" id="seachProductsForm" role="form">
                <input type="hidden" id="searchAction" name="searchAction" value="searchByName">
                <div class="form-group col-xs-5">
                    <input type="text" name="productsName" id="productsName" class="form-control" required="true" placeholder="Type the Name or category Name of the products"/>                    
                </div>
                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span> Search
                </button>
                <br></br>
                <br></br>
            </form>
            
            <!--Employees List-->
            <form action="/products" method="post" id="productsForm" role="form" >              
               
                <c:choose>
                    <c:when test="${not empty productsList}">
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>Name</td>
                                    <td>category name</td>
                                    <td>cost</td>
                                    <td>quantity</td>
                                                                
                                </tr>
                            </thead>
                            <c:forEach var="employee" items="${productsList}">
                                <c:set var="classSucess" value=""/>
                                <c:if test ="${idProducts == products.id}">                        	
                                    <c:set var="classSucess" value="info"/>
                                </c:if>
                                <tr class="${classSucess}">
                                    <td>${products.id}</td>
                                    <td>${products.name}</td>
                                    <td>${products.category}</td>
                                    <td>${products.cost}</td>
                                    <td>${products.quantity}</td>
   
                                   
                                </tr>
                            </c:forEach>               
                        </table>  
                    </c:when>                    
                    <c:otherwise>
                        <br>           
                        <div class="alert alert-info">
                            No products found matching your search criteria
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
           
        </div>
    </body>
</html>