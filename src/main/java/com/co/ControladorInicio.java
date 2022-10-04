//PERFORMANCE
package com.co;
import com.co.DAO.OyenteDAO;
import com.co.pojo.Oyente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorInicio {
    
         //despues de crear mi Dao, debo inyectar mi clase al controlador.  //para inyectar a nuestra vista loginadmin, le damos Autowired: voy a usar mi propia clase
    @Autowired
    //instancia de clase:
    private OyenteDAO oyenteDao;
        
    //Muestre desde la posicion o raiz absoluta de la página :
    @GetMapping("/")
    public String inicio(){
        return "index";
    }
    
     //Cuando pida mostrar inicio de sesion va a hacer: 
    //para abrir la pagina 
    @GetMapping("/login")
      public String iniciosesion(){
        return "iniciosesion";
    }
     
        @GetMapping("/register")
      public String registro(){
        return "register";
    }
      
      //mapeo al login admin para que cuando bingrese muestre la pagina loginadmin
          @GetMapping("/loginadmin")
      public String loginamdin(Model model){
           //creo una variable u objeto oyentes
          //findall: listar
          var oyentes = oyenteDao.findAll();
          //va a compartir todos sus atributos: 
          model.addAttribute("oyentes", oyentes);
          //esto lo comparto con el loginadmin
        return "loginadmin";
    }
      
        //Mapeo para mostrar la pagina de formulario de guardar 
      @GetMapping("/crear")
      //llamo desde login del admin 
      public String crear(){
          return "crear";
      }
      
   //para guardar y actualizar los datos del usuario
      @PostMapping("/guardar")
      //ModelAttribute: para recuperar el modelo de Cleinte
      public String guardar(@ModelAttribute Oyente oyentes){
      //cuando el guarde guarde en la base de datos y re direccione para decir que el usuario se duargo correctanemten
      //ClienteDAO: podemos utuilizar los metodos del crud repository, ahora vamos a usar guardar 
      oyenteDao.save(oyentes);
        return "redirect:loginadmin";
      }
      
      
        @GetMapping("/editar/{username}")
        //recibo una variable id cliente
        public String editar(@PathVariable("username") String username, Model model){
            var oyentes= oyenteDao.findById(username);
            model.addAttribute("oyentes",oyentes);
            return "modificar1";
        }
        
        @GetMapping("/eliminar/{username}")
        //recibo una variable id username
        public String eliminar(@PathVariable("username") String username){
            oyenteDao.deleteById(username);
            return "redirect:/loginadmin";
        }
      
}
