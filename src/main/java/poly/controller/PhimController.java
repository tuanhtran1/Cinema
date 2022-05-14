package poly.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.Entity.loai_phim;
import ptithcm.Entity.phim;

@Controller
@RequestMapping("site/")
@Transactional
public class PhimController {
     @Autowired
     SessionFactory factory;
     @RequestMapping("phim")
     public String indexphim(ModelMap model) {
    	 List<phim> list=this.getphims();
    	 model.addAttribute("phims",list);
    	 return "site/admin/phim";
     }
     public List<phim> getphims(){
    	 Session session=factory.getCurrentSession();
    	 String hql="From phim ";
    	 Query query =session.createQuery(hql);
    	 List<phim> list=query.list();
    	 return list;
     }
     @RequestMapping(value = "insertphim",method = RequestMethod.GET)
     public String insert(ModelMap model) {
    	 model.addAttribute("phim",new phim());
    	 return "site/admin/addphim";
     }
     public Integer addphim(phim phim) {
    	 Session session=factory.openSession();
    	 Transaction t=session.beginTransaction();
    	 try {
			session.save(phim);
			t.commit();
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			return 0;
		}
    	 return 1;
     }
     @RequestMapping(value = "insertphim",method = RequestMethod.POST)
     public String insertphim(ModelMap model,@ModelAttribute("phim") phim phim) {
    	 if(phim.getTen()=="") {
    		 model.addAttribute("message","Vui long nhap ten");
    	 }else if(phim.getTen() !="") {
    		 Integer check=this.addphim(phim);
    		 if(check ==1) {
    			 model.addAttribute("message","them thanh cong");
    		 }else {
    			 model.addAttribute("message","them that bai");
    		 }
    	 }
    	 return "site/admin/addphim";
     }
     
     @RequestMapping(value = "phim/{ma_phim}.htm",params = "linkDelete")
     public String delete(ModelMap model,@ModelAttribute("phim") phim phim,@PathVariable("ma_phim") Integer ma_phim) {
    	 Integer check=this.deletephim(phim);
    	 if(check==1) {
    		 model.addAttribute("message","xoa thanh cong");
    	 }else {
    		 model.addAttribute("message","xoa that bai");
    	 }
    	 List<phim> phim1=this.getphims();
    	 model.addAttribute("phims",phim1);
    	 return "site/admin/phim";
     }
     @RequestMapping(value = "phim/{ma_phim}.htm",params = "linkEdit")
     public String edit(ModelMap model,@ModelAttribute("phim") phim phim,@PathVariable("ma_phim") Integer ma_phim) {
    	model.addAttribute("phim",this.getphim(ma_phim));
    	 return "site/admin/editphim";
     }
     @RequestMapping(value = "updatephim",params = "btnEdit")
     public String update(ModelMap model,@ModelAttribute("phim") phim phim) {
    	 Session session=factory.openSession();
    	 Transaction t=session.beginTransaction();
    	 try {
			session.update(phim);
			t.commit();
			model.addAttribute("message","update thanh cong");
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			model.addAttribute("message","update that bai");
		}
    	 List<phim> phim2=this.getphims();
    	 model.addAttribute("phims",phim2);
    	 return "site/admin/phim";
     }
     
     public phim getphim(Integer ma_phim) {
    	 Session session=factory.getCurrentSession();
    	 String hql="from phim where ma_phim =:ma_phim";
    	 Query query=session.createQuery(hql);
    	 query.setParameter("ma_phim", ma_phim);
    	 phim list=(phim) query.list().get(0);
    	 return list;
     }
     @ModelAttribute("loaiphimsel")
     public List<loai_phim> getloaiphim(){
    	 Session session=factory.getCurrentSession();
    	 String hql="From loai_phim";
    	 Query query =session.createQuery(hql);
    	 List<loai_phim> list=query.list();
    	 return list;
     }
     public Integer deletephim(phim phim) {
    	 Session session=factory.openSession();
    	 Transaction t=session.beginTransaction();
    	 try {
			session.delete(phim);
			t.commit();
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			return 0;
		}
    	 return 1;
    	 
     }
}
