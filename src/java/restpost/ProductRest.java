/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restpost;

import com.google.gson.Gson;
import dto.ProductDao;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Product;

/**
 *
 * @author neete
 */
@Path("product")
public class ProductRest {
     @POST
    @Path("allProducts")
     @Produces(MediaType.APPLICATION_JSON)
     public String getAllData(){
         
     String jsonResponse=null;
     Gson gson= new Gson();
     try{
          ArrayList<Product> allData=ProductDao.getAllData();
          jsonResponse = gson.toJson(allData);
          }
         catch (SQLException se) {
           System.out.println(se);
         }
    return jsonResponse;
    }
    
}
