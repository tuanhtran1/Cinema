package poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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


import ptithcm.Entity.nhan_vien;
import ptithcm.Entity.vai_tro;
@Transactional
@Controller
@RequestMapping("site/")
public class AdminController {
	@Autowired
	SessionFactory factory;
	static nhan_vien nhanvienTemp;
	@RequestMapping("login")
    public String login(ModelMap model,@ModelAttribute("nhan_viens") nhan_vien nhan_viens) {
//		model.addAttribute("nhan_vien",new nhan_vien());
		return "site/admin/login";
	}
//	@RequestMapping(value = "login",method = RequestMethod.POST)
//	public String login(ModelMap model,@ModelAttribute("nhan_viens") nhan_vien nhan_viens,HttpSession session) {
//		try {
//			nhanvienTemp =this.getnv(nhan_viens.getHo_ten(), nhan_viens.getMat_khau());
//			if(nhanvienTemp !=null) {
//				session.setAttribute("nhan_viens", this.getnv(nhan_viens.getHo_ten(), nhan_viens.getMat_khau()));
//			}
//			return "site/admin/index";
//		} catch (Exception e) {
//			// TODO: handle exception
//			model.addAttribute("message","tai khoan ko ton tai");
//			return "site/admin/login";
//		}
//	}
	@RequestMapping(value = "login",method = RequestMethod.POST)
	public String login(ModelMap model,@ModelAttribute("nhan_viens") nhan_vien nhan_viens,HttpSession session,HttpServletRequest request) {
		try {
			nhanvienTemp =this.getnv(nhan_viens.getHo_ten(), nhan_viens.getMat_khau());
			if(nhanvienTemp !=null) {
				session.setAttribute("nhan_vienss", this.getnv(nhan_viens.getHo_ten(), nhan_viens.getMat_khau())); 
				model.addAttribute("nhan_viens1",this.getnv(nhan_viens.getHo_ten(), nhan_viens.getMat_khau()));
				System.out.println(nhanvienTemp.getEmail());
			}
			return "site/admin/index";
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message","tai khoan ko ton tai");
			return "site/admin/login";
		}
	}
	
	public nhan_vien getnv(String username,String password) {
		Session session=factory.getCurrentSession();
		String hql="From nhan_vien where ho_ten =:username and mat_khau =:password";
		Query query=session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);
		nhan_vien nv=(nhan_vien) query.list().get(0);
		return nv;
	}
	
	public List<nhan_vien> getnvs(){
		Session session=factory.getCurrentSession();
		String hql="From nhan_vien ";
		Query query=session.createQuery(hql);
		List<nhan_vien> list=query.list();
		return list;
	}
	 @RequestMapping("redirect1")
		public String logout(HttpSession ss) {
			System.out.println("logoutnv");
			ss.removeAttribute("nhan_vien");
			return "redirect:login.htm";
	}
	
	@ModelAttribute("vaitrosel")
	public List<vai_tro> getvaitro(){
		Session session=factory.getCurrentSession();
		String hql="From vai_tro ";
		Query query=session.createQuery(hql);
		List<vai_tro> list=query.list();
		return list;
	}
	public Integer addnv(nhan_vien nv) {
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		try {
			session.save(nv);
			t.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			return 0;
		}
		return 1;
	}
	@RequestMapping(value = "insertad",method = RequestMethod.GET)
	public String insertad(ModelMap model) {
		model.addAttribute("nhan_vien",new nhan_vien());
		return "site/admin/addadmin";
	}
	@RequestMapping(value = "insertad",method = RequestMethod.POST)
	public String inserted(ModelMap model,@ModelAttribute("nhan_vien") nhan_vien nhan_vien) {
		if(nhan_vien.getHo_ten()=="") {
			model.addAttribute("message","Vui long nhap username");
		}else if(nhan_vien.getMat_khau()=="") {
			model.addAttribute("message","Vui long nhap mat khau");
		}else if(nhan_vien.getHo_ten() !="" && nhan_vien.getMat_khau() !="") {
			Integer check=this.addnv(nhan_vien);
			if(check==1) {
				model.addAttribute("message","them thanh cong");
			}else {
				model.addAttribute("message","them that bai");
			}
					
		}
		return "site/admin/addadmin";
	}
	@RequestMapping("admin")
	public String admin(ModelMap model,@ModelAttribute("nhan_vien") nhan_vien nhan_vien) {
		List<nhan_vien> nhan_vien1=this.getnvs();
		model.addAttribute("nhan_viens",nhan_vien1);
		return "site/admin/admin";
	}
	@RequestMapping(value = "admin/{ma_nv}.htm",params = "linkEdit")
	public String update(ModelMap model,@ModelAttribute("nhan_vien") nhan_vien nhan_vien,@PathVariable("ma_nv") Integer ma_nv) {
		model.addAttribute("nhan_vien",this.getnv1(ma_nv));
		return "site/admin/editadmin";
	}
	@RequestMapping(value = "update",params = "btnEdit")
	public String update(ModelMap model,@ModelAttribute("nhan_vien") nhan_vien nhan_vien) {
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		try {
			session.update(nhan_vien);
			t.commit();
			model.addAttribute("message","update thanh cong");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message","update  that bai");
			// TODO: handle exception
		}finally {
			session.close();
		}
		List<nhan_vien> nhan_vien2=this.getnvs();
		model.addAttribute("nhan_viens",nhan_vien2);
		return "site/admin/admin";
	}
	
	@RequestMapping(value = "admin/{ma_nv}.htm",params = "linkDelete")
	public String delete(ModelMap model,@ModelAttribute("nhan_vien") nhan_vien nhan_vien,@PathVariable("ma_nv") Integer ma_nv) {
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		try {
			session.delete(this.getnv1(ma_nv));
			t.commit();
			model.addAttribute("message","xoa thanh cong");
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			model.addAttribute("message","xoa that bai");
		}finally {
			session.close();
		}
		List<nhan_vien> nhan_vien2=this.getnvs();
		model.addAttribute("nhan_viens",nhan_vien2);
		return "site/admin/admin";
	}
	public nhan_vien getnv1(Integer ma_nv) {
		Session session=factory.getCurrentSession();
		String hql="from nhan_vien where ma_nv =:ma_nv";
		Query query=session.createQuery(hql);
		query.setParameter("ma_nv", ma_nv);
		nhan_vien list=(nhan_vien) query.list().get(0);
		return list;
		
	}
	
}
