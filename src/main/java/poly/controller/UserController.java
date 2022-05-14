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


import ptithcm.Entity.khach_hang;
import ptithcm.Entity.nhan_vien;

@Controller
@RequestMapping("site")
@Transactional
public class UserController {
	@Autowired
	SessionFactory factory;
   @RequestMapping("user")
   public String index(ModelMap model,@ModelAttribute("khach_hang") khach_hang khach_hang) {
	   List<khach_hang> kh1=this.getkhs();
	   model.addAttribute("khach_hangs", kh1);
	   return "site/admin/user";
   }
   public List<khach_hang> getkhs(){
	   Session session=factory.getCurrentSession();
	   String hql="From khach_hang";
	   Query query=session.createQuery(hql);
	   List<khach_hang> list=query.list();
	   return list;
   }
   @RequestMapping(value = "insertuser",method = RequestMethod.GET)
   public String insert(ModelMap model) {
	   model.addAttribute("khach_hang",new khach_hang());
	   return "site/admin/adduser";
   }
   public Integer addkh(khach_hang kh) {
	   Session session=factory.openSession();
	   Transaction t=session.beginTransaction();
	   try {
		   session.save(kh);
		   t.commit();
		   
	} catch (Exception e) {
		// TODO: handle exception
		t.rollback();
		return 0;
	}
	   return 1;
   }
   @RequestMapping(value = "insertuser" ,method = RequestMethod.POST)
   public String insert(ModelMap model,@ModelAttribute("khach_hang") khach_hang khach_hang) {
	   if(khach_hang.getHo_ten()=="") {
		   model.addAttribute("message","vui long nhap username");
	   }else if(khach_hang.getMat_khau()=="") {
		   model.addAttribute("message","Vui long nhap password");
	   }else if(khach_hang.getHo_ten() !="" && khach_hang.getMat_khau() !="") {
		   Integer check=this.addkh(khach_hang);
		   if(check ==1) {
			   model.addAttribute("message","them thanh cong");
		   }else {
			   model.addAttribute("message","them that bai");
		   }
	   }
	   return "site/admin/adduser";
   }
   @RequestMapping(value = "user/{ma_kh}.htm",params = "linkDelete")
	public String delete(ModelMap model,@ModelAttribute("khach_hang") khach_hang khach_khang,@PathVariable("ma_kh") Integer ma_kh) {
//		Session session=factory.openSession();
//		Transaction t=session.beginTransaction();
//		try {
//			session.delete(this.getkh1(ma_kh));
//			t.commit();
//			model.addAttribute("message","xoa thanh cong");
//		} catch (Exception e) {
//			// TODO: handle exception
//			t.rollback();
//			model.addAttribute("message","xoa that bai");
//		}finally {
//			session.close();
//		}
	   Integer check=this.deletekh(khach_khang);
	   if(check==1) {
		   model.addAttribute("message","xoa thanh cong");
	   }else {
		   model.addAttribute("message","xoa that bai");
	   }
		List<khach_hang> khach_hang2=this.getkhs();
		model.addAttribute("khach_hangs",khach_hang2);
		return "site/admin/user";
	}
   public Integer deletekh(khach_hang kh) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(kh);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
   @RequestMapping(value = "user/{ma_kh}.htm",params = "linkEdit")
	public String update(ModelMap model,@ModelAttribute("khach_hang") khach_hang khach_hang,@PathVariable("ma_kh") Integer ma_kh) {
		model.addAttribute("khach_hang",this.getkh1(ma_kh));
		return "site/admin/edituser";
	}
	@RequestMapping(value = "updateuser",params = "btnEdit")
	public String update(ModelMap model,@ModelAttribute("khach_hang") khach_hang khach_hang) {
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		try {
			session.update(khach_hang);
			t.commit();
			model.addAttribute("message","update thanh cong");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message","update  that bai");
			// TODO: handle exception
		}finally {
			session.close();
		}
		List<khach_hang> khach_hang2=this.getkhs();
		model.addAttribute("khach_hangs",khach_hang2);
		return "site/admin/user";
	}
   public khach_hang getkh1(Integer ma_kh) {
	   Session session=factory.getCurrentSession();
	   String hql="From khach_hang where ma_kh =:ma_kh";
	   Query query=session.createQuery(hql);
	   query.setParameter("ma_kh", ma_kh);
	   khach_hang kh1=(khach_hang) query.list().get(0);
	   return kh1;
   }
}
