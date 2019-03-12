///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package restpost;
//
////import com.fasterxml.jackson.databind.ObjectMapper;
////import com.fasterxml.jackson.databind.ObjectWriter;
//import dto.UserDao;
//import java.io.IOException;
//import java.sql.SQLException;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import models.LoginResponse;
//import models.User;
//
///**
// *
// * @author neete
// */
//@Path("employees")
//public class Employees {
//    
//    
//    @POST
//     @Produces(MediaType.APPLICATION_JSON)
//     @Consumes(MediaType.APPLICATION_JSON)
//   public String  sayHelloJSON(String s1){
//        
//     String jsonResponse=null;
//     String response=null;
//     ObjectMapper mapper = new ObjectMapper();
//     User user= new User();
//     LoginResponse loginResponse= new LoginResponse();
//     ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//         try {
//              user = mapper.readValue(s1, User.class);
//              System.out.println("new otput="+user);
//              response=UserDao.validateUser(user);
//              System.out.println("response from db"+response);
//              loginResponse.setError(false);
//              loginResponse.setResponse(response);
//              jsonResponse = ow.writeValueAsString(loginResponse);
//         } catch (IOException ex) {
//             loginResponse.setError(true);
//             loginResponse.setResponse(ex.toString());
//             System.out.println(ex);
//         }
//         catch (SQLException se) {
//             loginResponse.setError(true);
//             loginResponse.setResponse(se.toString());
//             System.out.println(se);
//         }
//    return jsonResponse;
//    }
//    
//}
