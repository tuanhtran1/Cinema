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

import ptithcm.Entity.phim;
import ptithcm.Entity.phong_chieu;
import ptithcm.Entity.suat_chieu;

@Controller
@Transactional
@RequestMapping("site/")
public class SuatchieuController {
    @Autowired
    SessionFactory factory;
    @RequestMapping("suatchieu")
    public String index(ModelMap model) {
    	List<suat_chieu> list=this.getsuatchieus();
    	model.addAttribute("suat_chieus",list);
    	return "site/admin/suatchieu";
    }
    public List<suat_chieu> getsuatchieus(){
    	Session session=factory.getCurrentSession();
    	String hql="From suat_chieu";
    	Query query=session.createQuery(hql);
    	List<suat_chieu> list=query.list();
    	return list;
    }
    @RequestMapping(value = "insertsuatchieu",method = RequestMethod.GET)
    public String insertsc(ModelMap model) {
    	model.addAttribute("suat_chieu",new suat_chieu());
    	return "site/admin/addsuatchieu";
    }
    @RequestMapping(value = "insertsuatchieu",method = RequestMethod.POST)
    public String insert(ModelMap model,@ModelAttribute("suat_chieu") suat_chieu suat_chieu) {
    	Session session=factory.openSession();
    	Transaction t=session.beginTransaction();
    	try {
			session.save(suat_chieu);
			t.commit();
			model.addAttribute("message","them thanh cong");
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			model.addAttribute("message","them that bai");
		}
    	List<suat_chieu> list=this.getsuatchieus();
    	model.addAttribute("suat_chieus",list);
    	return "site/admin/suatchieu";
    }
    @ModelAttribute("phimsel")
    public List<phim> getphims(){
    	Session session=factory.getCurrentSession();
    	String hql="From phim";
    	Query query=session.createQuery(hql);
    	List<phim> list=query.list();
    	return list;
    }
    @ModelAttribute("phongsel")
    public List<phong_chieu> getphongchieu(){
    	Session session=factory.getCurrentSession();
    	String hql="from phong_chieu";
    	Query query=session.createQuery(hql);
    	List<phong_chieu> list=query.list();
    	return list;
    }
    @RequestMapping(value = "suatchieu/{ma_sc}.htm",params = "linkDelete")
    public String delete(ModelMap model,@ModelAttribute("suat_chieu") suat_chieu suat_chieu,@PathVariable("ma_sc") Integer ma_sc) {
    	Integer check=this.Delete(suat_chieu);
    	if(check==1) {
    		model.addAttribute("message","delete thanh cong");
    	}else {
    		model.addAttribute("message","delete that bai");
    	}
    	List<suat_chieu> list=this.getsuatchieus();
    	model.addAttribute("suat_chieus",list);
    	return "site/admin/suatchieu";
    }
    @RequestMapping(value = "suatchieu/{ma_sc}.htm",params = "linkEdit")
    public String edit(ModelMap model,@ModelAttribute("suat_chieu") suat_chieu suat_chieu,@PathVariable("ma_sc") Integer ma_sc) {
    	
    	model.addAttribute("suat_chieu",this.getsc(ma_sc));
    	return "site/admin/editsuatchieu";
    }
    @RequestMapping(value = "updatesc",params = "btnEdit")
    public String update(ModelMap model,@ModelAttribute("suat_chieu") suat_chieu suat_chieu) {
    	Session session=factory.openSession();
    	Transaction t=session.beginTransaction();
    	try {
			session.update(suat_chieu);
			t.commit();
			model.addAttribute("message","update thanh cong");
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message","upte that bai");
		}
    	List<suat_chieu> list=this.getsuatchieus();
    	model.addAttribute("suat_chieus",list);
    	return "site/admin/suatchieu";
    }
    public suat_chieu getsc(Integer ma_sc) {
    	Session session=factory.getCurrentSession();
    	String hql="from suat_chieu where ma_sc =:ma_sc";
    	Query query=session.createQuery(hql);
    	query.setParameter("ma_sc", ma_sc);
    	suat_chieu list=(suat_chieu) query.list().get(0);
    	return list;
    }
    public Integer Delete(suat_chieu sc) {
    	Session session=factory.openSession();
    	Transaction t=session.beginTransaction();
    	try {
			session.delete(sc);
			t.commit();
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			return 0;
		}
    	return 1;
    }
    
}
