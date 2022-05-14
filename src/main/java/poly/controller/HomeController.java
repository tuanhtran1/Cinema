package poly.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("site/")
public class HomeController {
   @RequestMapping("index")
   public String indexhome() {
	   return "site/index";
   }
   @RequestMapping("redirect")
	public String logout(HttpSession ss) {
		System.out.println("logout");
		ss.removeAttribute("khach_hang");
		return "redirect:index.htm";
	}
   
//   @RequestMapping("admin")
//   public String index() {
//	   return "site/admin/index";
//   }
}
