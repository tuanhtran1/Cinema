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

import ptithcm.Entity.phong_chieu;
import ptithcm.Entity.rap;

@Transactional
@Controller
@RequestMapping("site/")
public class PhongchieuController {
   @Autowired
   SessionFactory factory;
   @RequestMapping("phongchieu")
   public String index(ModelMap model) {
	   model.addAttribute("phong_chieus",this.getpcs());
	   return "site/admin/phongchieu";
   }
   public List<phong_chieu> getpcs(){
	   Session session=factory.getCurrentSession();
	   String hql="from phong_chieu";
	   Query query=session.createQuery(hql);
	   List<phong_chieu> list=query.list();
	   return list;
   }
   @RequestMapping(value = "insertphongchieu",method = RequestMethod.GET)
   public String insert(ModelMap model) {
	   model.addAttribute("phong_chieu",new phong_chieu());
	   return "site/admin/addphongchieu";
   }
   public Integer addpcs(phong_chieu pc) {
	   Session session=factory.openSession();
	   Transaction t=session.beginTransaction();
	   try {
		   session.save(pc);
		   t.commit();
	} catch (Exception e) {
		// TODO: handle exception
		t.rollback();
		return 0;
	}
	   return 1;
   }
   @RequestMapping(value = "insertphongchieu",method = RequestMethod.POST)
   public String insertpc(ModelMap model,@ModelAttribute("phong_chieu") phong_chieu phong_chieu ) {
	   if(phong_chieu.getTen_pc()=="") {
		   model.addAttribute("message","vui long nhap ten pc");
	   }else if (phong_chieu.getTen_pc() != ""){
		   Integer check=this.addpcs(phong_chieu);
		   if(check==1) {
			   model.addAttribute("message","them thanh cong");
		   }else {
			   model.addAttribute("message","them that bai");
		   }
		   
	   }
	   return "site/admin/addphongchieu";
   }
   public Integer deletepc(phong_chieu pc) {
	   Session session=factory.openSession();
	   Transaction t=session.beginTransaction();
	   try {
		session.delete(pc);
		t.commit();
	} catch (Exception e) {
		// TODO: handle exception
		t.rollback();
		return 0;
	}
	   return 1;
   }
   @RequestMapping(value = "phongchieu/{ma_pc}.htm",params = "linkDelete")
   public String deletepc(ModelMap model,@ModelAttribute("phong_chieu") phong_chieu phong_chieu,@PathVariable("ma_pc") Integer ma_pc) {
	   Integer check=this.deletepc(phong_chieu);
	   if(check==1) {
		   model.addAttribute("message","xoa thanh cong");
	   }else {
		   model.addAttribute("message","xoa that bai");
	   }
	   List<phong_chieu> list=this.getpcs();
	   model.addAttribute("phong_chieus",list);
	   return "site/admin/phongchieu";
   }
   @RequestMapping(value = "phongchieu/{ma_pc}.htm",params = "linkEdit")
   public String edit(ModelMap model,@ModelAttribute("phong_chieu") phong_chieu phong_chieu,@PathVariable("ma_pc") Integer ma_pc) {
	   model.addAttribute("phong_chieu",this.getpc(ma_pc));
	   return "site/admin/editphongchieu";
   }
   @RequestMapping(value = "updatepc",params = "btnEdit")
   public String updatepc(ModelMap model,@ModelAttribute("phong_chieu") phong_chieu phong_chieu) {
	   Session session=factory.openSession();
	   Transaction t=session.beginTransaction();
	   try {
		 session.update(phong_chieu);
		 t.commit();
		 model.addAttribute("message","update thanh cong");
	} catch (Exception e) {
		// TODO: handle exception
		t.rollback();
		model.addAttribute("message","update that bai");
	}
	   List<phong_chieu> list1=this.getpcs();
	   model.addAttribute("phong_chieus",list1);
	   return "site/admin/phongchieu";
   }
   
   public phong_chieu getpc(Integer ma_pc) {
	   Session session=factory.getCurrentSession();
	   String hql="From phong_chieu where ma_pc =:ma_pc";
	   Query query=session.createQuery(hql);
	   query.setParameter("ma_pc", ma_pc);
	   phong_chieu list=(phong_chieu) query.list().get(0);
	   return list;
   }
   @ModelAttribute("rapsel")
   public List<rap> getrap(){
	   Session session=factory.getCurrentSession();
	   String hql="From rap";
	   Query query=session.createQuery(hql);
	   List<rap> list=query.list();
	   return list;
   }
}
