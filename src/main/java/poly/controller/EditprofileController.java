package poly.controller;

import java.util.List;
import java.util.Random;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.Entity.khach_hang;
import ptithcm.Entity.nhan_vien;
import ptithcm.bean.Mailer;

@Controller
@Transactional
@RequestMapping("site/")
public class EditprofileController {
    @Autowired
    SessionFactory factory;
    static khach_hang userTemp;
    @RequestMapping(value = "sign_in" ,method = RequestMethod.GET)
    public String login(ModelMap model) {
    	model.addAttribute("khach_hang",new khach_hang());
    	return "site/sign_in";
    }

    @RequestMapping(value = "sign_in",method = RequestMethod.POST)
    public String login(ModelMap model,@ModelAttribute("khach_hang") khach_hang khach_hang,HttpSession session
    		) {
    	try {
			userTemp=this.getkh(khach_hang.getHo_ten(), khach_hang.getMat_khau());
			System.out.println(this.getkh(khach_hang.getHo_ten(), khach_hang.getMat_khau()).getEmail());
			System.out.println(khach_hang.getEmail());
    		if(userTemp !=null) {
    			session.setAttribute("khach_hangs", this.getkh(khach_hang.getHo_ten(), khach_hang.getMat_khau()));
    			System.out.println(userTemp.getEmail());
    		}
		    return "site/index";
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message","accout do not exits");
			return "site/sign_in";
		}
    }
    public khach_hang getkh(String username,String passsword) {
    	Session currentSession=factory.getCurrentSession();
    	String hql="from khach_hang where ho_ten =:username and mat_khau =:password";
    	Query query=currentSession.createQuery(hql);
    	query.setParameter("username", username);
    	query.setParameter("password", passsword);
    	khach_hang kh=(khach_hang) query.list().get(0);
    	return kh;
    }
    @RequestMapping(value = "edit_profile")
    public String editProfile(ModelMap model,@ModelAttribute("khach_hangs") khach_hang khach_hangs) {
    	khach_hang kh=this.getkh(userTemp.getHo_ten(),userTemp.getMat_khau());
    	model.addAttribute("khach_hangs",kh);
    	return "site/edit_profile";
    }
    @RequestMapping(value = "edit_profile",params = "btnEdit")
    public String edit(ModelMap model,@ModelAttribute("khach_hangs") khach_hang khach_hangs,@RequestParam("passwordInput") String passwordInput) {
    	try { 
    		
    		if(passwordInput.equals(userTemp.getMat_khau())) {
    			khach_hangs.setMat_khau(passwordInput);
    			Integer check=this.updatekh(khach_hangs);
        		if(check==1) {
        			model.addAttribute("message","update thanh cong");
        		}else {
        			model.addAttribute("message","update that bai");
        		}
    		}
		} catch (Exception e) {
			// TODO: handle exception
			return "site/edit_profile";
		}
    	return "site/edit_profile";
    }
    public Integer updatekh(khach_hang kh) {
    	Session session=factory.openSession();
    	Transaction t=session.beginTransaction();
    	try {
			 session.update(kh);
			 t.commit();
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			return 0;
		}finally {
			session.close();
		}
    	return 1;
    }
    @RequestMapping(value = "changePassword")
    public String changePassword1(ModelMap model,@ModelAttribute("khach_hangs") khach_hang khach_hang) {
    	return "site/changePassword";
    }
    @RequestMapping(value = "changePassword",params = "btnChange",method = RequestMethod.POST)
    public String changePassword(ModelMap model,@ModelAttribute("khach_hangs") khach_hang khach_hangs,
    		@RequestParam(value = "current",required = false) String password,@RequestParam(value = "password1",required = false) String password1) {
    	try {
			if(password=="") {
				model.addAttribute("messagep","lam on nhap password");
			}else if(password1=="") {
				model.addAttribute("messagep","lam on nhap password moi");
			}else if(userTemp.getMat_khau().equals(password)) {
				if(khach_hangs.getMat_khau().equals(password1)) {
					khach_hangs.setMa_kh(userTemp.getMa_kh());
					khach_hangs.setHo_ten(userTemp.getHo_ten());
					khach_hangs.setSo_cmnd(userTemp.getSo_cmnd());
					khach_hangs.setSo_dien_thoai(userTemp.getSo_dien_thoai());
					khach_hangs.setEmail(userTemp.getEmail());
					khach_hangs.setDia_chi(userTemp.getDia_chi());
					khach_hangs.setNgay_dang_ky(userTemp.getNgay_dang_ky());
					khach_hangs.setNgay_sinh(userTemp.getNgay_sinh());
					khach_hangs.setGioi_tinh(userTemp.getGioi_tinh());
					Integer check=this.updatekh(khach_hangs);
					if(check==1) {
						model.addAttribute("messagep","update success");
					}else {
						model.addAttribute("messagep","update that bai");
					}
				}else {
					model.addAttribute("messagep","confirm password does not match");
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("messagep","update failed");
		}
    	return "site/changePassword";
    }
    @Autowired
    Mailer mailer;
    static String codeTemp;
    @RequestMapping(value = "forgotPassword",params = "sendcode")
    public String send(ModelMap model ,@ModelAttribute("khach_hang") khach_hang khach_hang) {
    	String to =khach_hang.getEmail();
    	String from="DreamHome";
    	String subject="Validation code";
    	Random rd = new Random();
		Integer number1 = rd.nextInt(1000);
		String body=Integer.toString(number1);
		codeTemp = body;
    	try {
			mailer.send(from, to, subject, body);
			model.addAttribute("message","Code send");
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message","Code send Failed");
		}
    	return "site/forgotPassword";
    }
    @RequestMapping(value = "forgotPassword")
    public String forgot(ModelMap model,@ModelAttribute("khach_hang") khach_hang khach_hang) {
    	return "site/forgotPassword";
    }
    public khach_hang getkh1(String username,String email) {
    	Session session=factory.getCurrentSession();
    	String hql="from khach_hang where ho_ten =:username and email =:email";
    	Query query=session.createQuery(hql);
    	query.setParameter("username", username);
    	query.setParameter("email", email);
    	khach_hang kh=(khach_hang) query.list().get(0);
    	return kh;
    	
    }
    @RequestMapping(value = "forgotPassword",params = "change",method = RequestMethod.POST)
    public String forgot1(ModelMap model,@ModelAttribute("khach_hang") khach_hang khach_hang,
    		@RequestParam("confirm") String password,@ModelAttribute("ho_ten") String ho_ten,
    		@ModelAttribute("email") String email,@RequestParam("code") String code) {
    	try {
			if(khach_hang.getHo_ten()=="") {
				model.addAttribute("message","vui long nhap username");
			}else if(khach_hang.getEmail()=="") {
				model.addAttribute("message","Vui long nhap email");
			}else if(khach_hang.getHo_ten() !="" && khach_hang.getEmail() !="") {
				userTemp=this.getkh1(ho_ten, email);
				khach_hang.setMa_kh(userTemp.getMa_kh());
				khach_hang.setHo_ten(userTemp.getHo_ten());
				khach_hang.setEmail(userTemp.getEmail());
				if(khach_hang.getMat_khau() =="") {
					model.addAttribute("message","vui long nhap mat khau moi");
				}else {
					if(code.equals(codeTemp)) {
						if(khach_hang.getMat_khau().equals(password)) {
							Integer check=this.updatekh(khach_hang);
							if(check==1) {
								model.addAttribute("message","thay doi thanh cong");
							}else {
								model.addAttribute("message","thay doi that bai");
							}
						}else {
							model.addAttribute("message","xac nhan password ko dung");
						}
					}else {
						model.addAttribute("message","Code invalid");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message","username and email do not match");
			return "site/forgotPassword";
		}
    	return "site/forgotPassword";
    }
    @RequestMapping(value = "sign_up",method = RequestMethod.GET)
    public String signup(ModelMap model) {
    	model.addAttribute("khach_hang",new khach_hang());
    	return "site/sign_in";
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
		}finally {
			session.close();
		}
    	return 1;
    }
    @RequestMapping(value = "sign_up",params = "btnAdd")
    public String insert(ModelMap model,@ModelAttribute("khach_hang") khach_hang khach_hang) {
    	if(khach_hang.getHo_ten()=="") {
    		model.addAttribute("message","vui long nhap username");
    	}else if(khach_hang.getMat_khau()=="") {
    		model.addAttribute("message","Vui long nhap password");
    	}else if(khach_hang.getEmail()=="") {
    		model.addAttribute("message","vui long nhap email");
    	}else if(khach_hang.getHo_ten() !="" && khach_hang.getMat_khau() !="" && khach_hang.getEmail() !="") {
    		
    			Integer check=this.addkh(khach_hang);
    			if(check ==1) {
    				model.addAttribute("message","dang ky thanh cong");
    			}else {
    				model.addAttribute("message","dang ky that bai");
    			}
    	}
    	return "site/sign_in";
    }
    
    
}
