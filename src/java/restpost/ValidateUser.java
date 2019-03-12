/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restpost;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import dto.UserDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.User;
import models.LoginResponse;
import models.RegisterResponse;
//import org.json.simple.JSONArray;


/**
 *
 * @author neete
 */
@Path("loginValidation")
public class ValidateUser {
     @POST
     @Path("/user")
     @Produces(MediaType.APPLICATION_JSON)
     @Consumes(MediaType.APPLICATION_JSON)
   public String  sayHelloJSON(String s1){
        
     String jsonResponse=null;
     String response=null;
     User user= new User();
     LoginResponse loginResponse= new LoginResponse();
     Gson gson = new Gson();
         try {
              user=gson.fromJson(s1,User.class);
              response=UserDao.validateUser(user);
              if(response=="null"){
                  loginResponse.setError(true);
                  loginResponse.setResponse(response);
              }
              else{
                  
                  loginResponse.setError(false);
                  loginResponse.setResponse(response);
              }
              jsonResponse=gson.toJson(loginResponse);
            
         }
         catch (SQLException se) {
             loginResponse.setError(true);
             loginResponse.setResponse(se.toString());
             System.out.println(se);
             jsonResponse=gson.toJson(loginResponse);
         }
    return jsonResponse;
    }
   
//    @POST
//     @Produces(MediaType.APPLICATION_JSON)
//     public String getEmployee (){
//        
//     String jsonResponse=null;
//     
//     ObjectMapper mapper = new ObjectMapper();
//     ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//             Gson gson= new Gson();
//             
//             try{
//                 ArrayList<String> empid= UserDao.getEmp();
//              
//              jsonResponse=gson.toJson(empid);
//             }
//         
//         catch (SQLException se) {
//            
//             System.out.println(se);
//         }
//    return jsonResponse;
//    }
//     
//     
//     @POST
//     @Produces(MediaType.APPLICATION_JSON)
//     @Consumes(MediaType.APPLICATION_JSON)
//   public String  registerCashier(String s1){
//     String jsonResponse=null;
//     boolean response=false;
//     ObjectMapper mapper = new ObjectMapper();
//     User user= new User();
//     RegisterResponse registerResponse= new RegisterResponse();
//     ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//         try {
//              user = mapper.readValue(s1, User.class);
//              System.out.println("new otput="+user.getPassword());
//              response=UserDao.registerCashier(user);
//              
//              System.out.println("response from db"+response);
//              registerResponse.setError(false);
//              registerResponse.setResponse(response);
//              jsonResponse = ow.writeValueAsString(registerResponse);
//         } catch (IOException ex) {
//             registerResponse.setError(true);
//             registerResponse.setResponse(false);
//             System.out.println(ex);
//         }
//         catch (SQLException se) {
//             registerResponse.setError(true);
//             registerResponse.setResponse(false);
//             System.out.println(se);
//         }
//    return jsonResponse;
//    }
   
//     @POST
//     @Produces(MediaType.APPLICATION_JSON)
//     public String removeCashier (String userId){
//         System.out.println("userId "+userId);
//     String jsonResponse=null;
//     Gson gson= new Gson();
//     try{
//       jsonResponse = gson.toJson( UserDao.removeCashier(userId));
//          }
//         catch (SQLException se) {
//           System.out.println(se);
//         }
//    return jsonResponse;
//    }
//   
    
//    @POST
//     @Produces(MediaType.APPLICATION_JSON)
//     public String getAllData (String userId){
//         
//     String jsonResponse=null;
//     Gson gson= new Gson();
//     try{
//          HashMap<String,String> allData=UserDao.getAllData(userId.trim());
//          jsonResponse = gson.toJson(allData);
//          }
//         catch (SQLException se) {
//           System.out.println(se);
//         }
//    return jsonResponse;
//    }
//    
//    
//     @POST
//     @Path("/user")
//     @Produces(MediaType.APPLICATION_JSON)
//     public String getAllData (){
//         //System.out.println("It is working well"); 
//     String jsonResponse=null;
//     Gson gson= new Gson();
////     try{
//          User user= new User();
//          user.setPassword("admin43");
//          user.setUserType("cashier");
//          user.setUserid("neetesh@gmail.com");
//          jsonResponse = gson.toJson(user);
////          }
////         catch (SQLException se) {
////           System.out.println(se);
////         }
//    return jsonResponse;
//    }
    
  }
