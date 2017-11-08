
package com.mrd.service;//package statement
//import statements
import com.mrd.entity.Restaurant;
import com.mrd.repository.RestaurantsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */

@Service
public class RestaurantService {
 
    @Autowired
    private RestaurantsRepository restaurantsRepository;

   private Object index(){
       return restaurantsRepository.findAll();
   }
 
    /*delete resturant from database*/
    public void delete(Restaurant restaurant){
       restaurantsRepository.delete(restaurant);
    }
    
    public Restaurant save(Restaurant restaurant){
        return restaurantsRepository.save(restaurant);
    }
          
//    public List<Restaurant> getAllRestaurants(String name){
//        List <Restaurant> allrestaurants = new ArrayList<>();
//       return allrestaurants;
//    }
    

    public List<Restaurant> findAll() {
      return restaurantsRepository.findAll();
    }
    
    /* Getting single category based on id*/
//     public Restaurant get(Long restaurant_id) {
//        return  restaurantsRepository.get(restaurant_id);
//}

      public List<Restaurant> getAllRestaurants(){
        List<Restaurant> u = new ArrayList<>();
        restaurantsRepository.findAll().forEach(u::add);
        return u;
    }
    
        public Restaurant login(String email,String password){
        Restaurant partner =  null;
        String status = null;
          List<Restaurant> p = getAllRestaurants();
          for(int i = 0;i< p.size();i++){
              if(p.get(i).getEmail().equals(email) && p.get(i).getPassword().equals(password)){
                  status = "LoggedIn";
                  partner = p.get(i);
                  break;
              }else{
                  status = "Invalid Credentials";
              }
          }
          return partner;
    }
    
    

}
