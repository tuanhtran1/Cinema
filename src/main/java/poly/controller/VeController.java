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

import ptithcm.Entity.ghe;
import ptithcm.Entity.suat_chieu;
import ptithcm.Entity.ve;

@Controller
@Transactional
@RequestMapping("site/")
public class VeController {
	@Autowired
	SessionFactory factory;
   @RequestMapping("ve")
   public String index(ModelMap model) {
	   List<ve> list=this.getves();
	   model.addAttribute("ves",list);
	   return "site/admin/ve";
   }
   @RequestMapping("insertve")
   public String insert(ModelMap model) {
	   model.addAttribute("ve",new ve());
	   return "site/admin/addve";
   }
   @RequestMapping(value = "insertve",method = RequestMethod.POST)
   public String insertve(ModelMap model,@ModelAttribute("ve") ve ve) {
	   Session session=factory.openSession();
	   Transaction t=session.beginTransaction();
	   try {
		session.save(ve);
		t.commit();
		model.addAttribute("message","them thanh cong");
	} catch (Exception e) {
		// TODO: handle exception
		t.rollback();
		model.addAttribute("message","them that bai");
	}
	   List<ve> list=this.getves();
	   model.addAttribute("ves",list);
	   return "site/admin/ve";
   }
   @RequestMapping(value = "ve/{ma_ve}",params  ="linkDelete")
   public String delete(ModelMap model,@ModelAttribute("ve") ve ve,@PathVariable("ma_ve") Integer ma_ve) {
	   Integer check=this.deleteve(ve);
	   if(check==1) {
		   model.addAttribute("message","xoa thanh cong");
	   }else {
		   model.addAttribute("message","xoa that bai");
	   }
	   List<ve> list=this.getves();
	   model.addAttribute("ves",list);
	   return "site/admin/ve";
   }
   @RequestMapping(value = "ve/{ma_ve}.htm" ,params = "linkEdit")
   public String edit(ModelMap model,@ModelAttribute("ve") ve ve,@PathVariable("ma_ve") Integer ma_ve) {
	   model.addAttribute("ve",this.getve(ma_ve));
	   return "site/admin/editve";
   }
   @RequestMapping(value = "updateve",params = "btnEdit")
   public String updateve(ModelMap model,@ModelAttribute("ve") ve ve) {
	   Session session=factory.openSession();
	   Transaction t=session.beginTransaction();
	   try {
		   session.update(ve);
		   t.commit();
		   model.addAttribute("message","update thanh cong");
	} catch (Exception e) {
		// TODO: handle exception
		t.rollback();
		model.addAttribute("message","update that bai");
	}
	   List<ve> list=this.getves();
	   model.addAttribute("ves",list);
	   return "site/admin/ve";
   }
   public ve getve(Integer ma_ve) {
	   Session session=factory.getCurrentSession();
	   String hql="from ve where ma_ve =:ma_ve";
	   Query query=session.createQuery(hql);
	   query.setParameter("ma_ve", ma_ve);
	   ve list=(ve) query.list().get(0);
	   return list;
   }
   
   public Integer deleteve(ve ve) {
	   Session session=factory.openSession();
	   Transaction t=session.beginTransaction();
	   try {
		session.delete(ve);
		t.commit();
	} catch (Exception e) {
		// TODO: handle exception
		t.rollback();
		return 0;
	}
	   return 1;
   }
   
   @ModelAttribute("suatchieusel")
   public List<suat_chieu> getscs() {
	   Session session=factory.getCurrentSession();
	   String hql="from suat_chieu";
	   Query query=session.createQuery(hql);
	   List<suat_chieu> list=query.list();
	   return list;
   }
   @ModelAttribute("ghesel")
   public List<ghe> getghe(){
	   Session session=factory.getCurrentSession();
	   String hql="from ghe";
	   Query query=session.createQuery(hql);
	   List<ghe> list=query.list();
	   return list;
   }
   public List<ve> getves(){
	   Session session=factory.getCurrentSession();
	   String hql="from ve";
	   Query query=session.createQuery(hql);
	   List<ve> list=query.list();
	   return list;
   }
}
