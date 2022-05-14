package poly.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javassist.expr.NewArray;
import ptithcm.Entity.ghe;
import ptithcm.Entity.phim;
import ptithcm.Entity.phong_chieu;
import ptithcm.Entity.suat_chieu;
import ptithcm.Entity.ve;

@Controller
@RequestMapping("site/")
@Transactional
public class MoviesController {
	
	
	@Autowired
	SessionFactory factory;
	static ve ve1;
	static ghe ghetemp;
    @RequestMapping("movies")
    public String index(ModelMap model) {
    	model.addAttribute("phims",this.getphims());
    	return "site/movies";
    }
    public List<phim> getphims(){
    	Session session=factory.getCurrentSession();
    	String hql="From phim";
    	Query query=session.createQuery(hql);
    	List<phim> list=query.list();
    	return list;
    }
    
    
    
    @RequestMapping("ticket_booking")
    public String ticket(ModelMap model) {
    	return "site/ticket_booking";
    }
    @RequestMapping(value = "suat_chieus/{ma_phim}.htm",params = "linkEdit")
    public String index1(ModelMap model,@PathVariable("ma_phim") Integer ma_phim,HttpSession session1) {
    	model.addAttribute("suat_chieus",new suat_chieu());
    	Session session=factory.getCurrentSession();
//    	String hql="SELECT sc.ngay_chieu,sc.phim.ma_phim FROM suat_chieu sc where sc.phim.ma_phim="+ma_phim+"group by sc.phim.ma_phim,sc.ngay_chieu";
    	String hql="SELECT distinct sc.ngay_chieu,sc.phim.ma_phim FROM suat_chieu sc where sc.phim.ma_phim="+ma_phim;
    	Query query=session.createQuery(hql);
    	List<Object[]> list=query.list();
    	System.out.println(list);
    	System.out.println("hung");
    	model.addAttribute("suatchieus2",list);
    	session1.setAttribute("maphim", ma_phim);
//    	model.addAttribute("suatchieus1",this.getscs(ma_phim));
    	return "site/index1";
    }
    
//    @RequestMapping(value = "phong_chieus/{ma_phim}.htm",params = "linkEdit")
//    public String index2(ModelMap model,@PathVariable("ma_phim") Integer ma_phim) {
//    	model.addAttribute("phong_chieus",new phong_chieu());
//    	model.addAttribute("phongchieus1",);
//    	return "site/chonphongchieu";
//    }
    
    
    
    @RequestMapping(value = "movies1",method = RequestMethod.POST)
    public String edit(ModelMap model,@ModelAttribute("suat_chieus") suat_chieu suat_chieus,HttpSession session) {
//   	model.addAttribute("suat_chieus",this.getsc(ma_phim));
//   	model.addAttribute("masuatchieu",this.getsc(ma_phim).getMa_sc());
//   	model.addAttribute("suatchieus1",this.getscs(ma_phim));
//    	model.addAttribute("masuatchieus",suat_chieus.getMa_sc());
    	session.setAttribute("ngaychieu",suat_chieus.getNgay_chieu());
//    	model.addAttribute("ghe",new ghe());
   	    System.out.println(suat_chieus.getNgay_chieu());
   	    Session session3=factory.getCurrentSession();
   	    String hql="SELECT DISTINCT sc.gio_bat_dau_gio_ket_thuc,sc.ngay_chieu from suat_chieu sc where sc.ngay_chieu =:ngay_chieu and sc.phim.ma_phim =:ma_phim";
   	    Query query=session3.createQuery(hql);
   	    query.setParameter("ngay_chieu", suat_chieus.getNgay_chieu());
   	    query.setParameter("ma_phim", suat_chieus.getPhim().getMa_phim());
   	    List<Object[]> list=query.list();
   	    model.addAttribute("suatchieus3",list);
   	   return "site/choncachieu";
    }
    @RequestMapping(value = "movies3",method = RequestMethod.POST)
    public String edit2(ModelMap model,@ModelAttribute("suat_chieus") suat_chieu suat_chieus,HttpSession session) {
    	session.setAttribute("cachieu", suat_chieus.getGio_bat_dau_gio_ket_thuc());
    	System.out.println(suat_chieus.getNgay_chieu());
    	Session session3=factory.getCurrentSession();
    	String hql="SELECT DISTINCT sc.phong_chieu.ma_pc,sc.gio_bat_dau_gio_ket_thuc from suat_chieu sc where sc.gio_bat_dau_gio_ket_thuc =:cachieu and sc.ngay_chieu =:ngay_chieu";
    	Query query=session3.createQuery(hql);
    	query.setParameter("ngay_chieu", suat_chieus.getNgay_chieu());
    	query.setParameter("cachieu", suat_chieus.getGio_bat_dau_gio_ket_thuc());
    	List<Object[]> list=query.list();
    	model.addAttribute("suatchieus4",list);
    	return "site/chonphongchieu";
    }
    @RequestMapping(value = "movies4",method = RequestMethod.POST)
    public String edit3(ModelMap model,@ModelAttribute("suat_chieus") suat_chieu suat_chieus,HttpSession session) {
    	model.addAttribute("ghe",new ghe());
    	session.setAttribute("phongchieu", suat_chieus.getPhong_chieu().getMa_pc());
    	System.out.println(suat_chieus.getPhong_chieu().getMa_pc());
    	System.out.println(suat_chieus.getPhim().getMa_phim());
    	System.out.println(suat_chieus.getGio_bat_dau_gio_ket_thuc());
    	System.out.println(suat_chieus.getNgay_chieu());
    	Session session3=factory.getCurrentSession();
    	Session session4=factory.getCurrentSession();
    	String hql="From suat_chieu sc where sc.phim.ma_phim =:ma_phim and sc.gio_bat_dau_gio_ket_thuc =:cachieu and sc.ngay_chieu =:ngay_chieu and sc.phong_chieu.ma_pc =:mapc ";
//    	String hql1="From ghe g where g.phong_chieu.ma_pc =:mapc2";
//    	Query query2=session4.createQuery(hql1);
    	Query query=session3.createQuery(hql);
//    	query2.setParameter("mapc2", suat_chieus.getPhong_chieu().getMa_pc());
    	query.setParameter("ma_phim", suat_chieus.getPhim().getMa_phim());
    	query.setParameter("cachieu", suat_chieus.getGio_bat_dau_gio_ket_thuc());
    	query.setParameter("ngay_chieu", suat_chieus.getNgay_chieu());
    	query.setParameter("mapc", suat_chieus.getPhong_chieu().getMa_pc());
    	suat_chieu list=(suat_chieu) query.list().get(0);
//    	List<ghe> list1=query.list();
    	session.setAttribute("suatchieus6",list);
    	model.addAttribute("suatchieus5",this.getghe2(suat_chieus.getPhong_chieu().getMa_pc()));
    	System.out.println(this.getghe2(suat_chieus.getPhong_chieu().getMa_pc()));
    	List<ghe> listpos=new ArrayList<>();
    	listpos=this.getghe2(suat_chieus.getPhong_chieu().getMa_pc());
        System.out.println(listpos);
    	model.addAttribute("ghes1",listpos);
    	return "site/chonchongoi";
    }
    
    @RequestMapping(value = "movies2",method = RequestMethod.POST)
    public String edit2(ModelMap model,@ModelAttribute("ghe") ghe ghe,HttpSession session) {
    	try {
			ghetemp =this.getghe(ghe.getMa_ghe());
			System.out.println(ghetemp.getVi_tri_day());
			System.out.println(ghetemp.getLoai_ghe().getMa_lg());
			System.out.println(ghetemp.getPhong_chieu().getMa_pc());
			if(ghetemp !=null) {
				session.setAttribute("maghe", ghe.getMa_ghe());
				ghe.setMa_ghe(ghetemp.getMa_ghe());
				ghe.setVi_tri_day(ghetemp.getVi_tri_day());
				ghe.setVi_tri_trong("0");
				ghe.setLoai_ghe(ghetemp.getLoai_ghe());
				ghe.setPhong_chieu(ghetemp.getPhong_chieu());
				Integer check=this.updateghe1(ghe);
				if(check==1) {
					model.addAttribute("message","thanh cong");
				}else {
					model.addAttribute("message","that bai");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	System.out.println(ghe.getMa_ghe());
    	model.addAttribute("ve1",new ve());
    	return "site/index2";
    }
    public ghe getghe(Integer ma_ghe) {
    	Session session=factory.getCurrentSession();
    	String hql="from ghe where ma_ghe =:ma_ghe";
    	Query query=session.createQuery(hql);
    	query.setParameter("ma_ghe", ma_ghe);
    	ghe list=(ghe) query.list().get(0);
    	return list;
    	
    }
    public Integer updateghe1(ghe ghe) {
    	Session session=factory.openSession();
    	Transaction t=session.beginTransaction();
    	try {
			session.update(ghe);
			t.commit();
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			return 0;
		}
    	return 1;
    }
//    @RequestMapping(value = "insertve1/{masuatchieu}.htm",params = "linkEdit1")
//    public String insertve1(ModelMap model,@PathVariable("masuatchieu") Integer masuatchieu) {
//    	model.addAttribute("masuatchieus",masuatchieu);
//    	model.addAttribute("ve1",new ve());
//    	return "site/index2";
//    }
    @RequestMapping(value = "insertve1",method = RequestMethod.POST)
    public String insert(ModelMap model,@ModelAttribute("ve1") ve ve1) {
    	Session session=factory.openSession();
    	Transaction t=session.beginTransaction();
    	try {
    		ve1.setNgay_ban(new Date().toString());
//    		ve1.getGhe().setVi_tri_trong("ko");
//    		ve1.getGhe().setVi_tri_trong(null);
			session.save(ve1);
			System.out.println(ve1.getGhe().toString());
			t.commit();
			model.addAttribute("message","them thanh cong");
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			model.addAttribute("message","them that bai");
		}
    	return "site/index2";
    }
    
    public phim getphim(Integer ma_phim) {
   	 Session session=factory.getCurrentSession();
   	 String hql="from phim where ma_phim =:ma_phim";
   	 Query query=session.createQuery(hql);
   	 query.setParameter("ma_phim", ma_phim);
   	 phim list=(phim) query.list().get(0);
   	 return list;
    }
    public suat_chieu getsc(Integer ma_phim) {
    	Session session=factory.getCurrentSession();
    	String hql="from suat_chieu where ma_phim =:ma_phim";
    	Query query=session.createQuery(hql);
    	query.setParameter("ma_phim", ma_phim);
    	suat_chieu list=(suat_chieu) query.list().get(0);
    	return list;
    }
//    @ModelAttribute("suatchieusel")
//    public List<suat_chieu> getscs(Integer ma_phim) {
// 	   Session session=factory.getCurrentSession();
//// 	   Criteria ctr=session.createCriteria(suat_chieu.class,"sc");
// 	   //String hql="FROM suat_chieu WHERE ma_phim =:ma_phim  ";
// 	   String hql="SELECT distinct sc.phong_chieu FROM suat_chieu sc WHERE ma_phim = "+ 1;
// 	   System.out.println(hql);
// 	   List<Integer> listInt = new ArrayList<>();
// 	   
// 	  
//// 	   ctr.add(Restrictions.eq("sc.gio_bat_dau_gio_ket_thuc","ca_1"));
//// 	  ctr.setProjection(Projections.distinct(Projections.property("sc.ma_sc")));
//// 	   ctr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//// 	   List<suat_chieu> list=ctr.list();
//// 	   String hql=" from suat_chieu  where ma_phim =:ma_phim";
// 	   Query query=session.createQuery(hql);
//// 	   query.setParameter("ma_phim", ma_phim);
//// 	   List<suat_chieu> list=query.list();
// 	   listInt = query.list();
// 	
// 	   for(Integer item: listInt)
// 	   {
// 		   System.out.println(item);
// 	   }
//// 	   String hql="from suat_chieu ";
//// 	   Query query=session.createQuery(hql);
//// 	   List<suat_chieu> list=query.list();
// 	   return null;
//    }
    @ModelAttribute("phimsel")
    public List<phim> getphimss(){
//    	Session session=factory.getCurrentSession();
//    	String hql="From phim";
//    	Query query=session.createQuery(hql);
//    	List<phim> list=query.list();
    	Session session=factory.getCurrentSession();
    	Criteria ctr=session.createCriteria(phim.class);
    	List<phim> list=ctr.list();
    	return list;
    }
    @ModelAttribute("ghesel")
    public List<ghe> getghe2(Integer mapc2){
 	   Session session=factory.getCurrentSession();
 	   String hql="from ghe g where g.phong_chieu.ma_pc =:mapc2";
 	   Query query=session.createQuery(hql);
 	   query.setParameter("mapc2", mapc2);
// 	   query.setParameter("vitritrong", "1");
 	   List<ghe> list=query.list();
 	   return list;
    }
//    public Integer updateghe(ghe ghe) {
//    	Session session=factory.openSession();
//    	Transaction t=session.beginTransaction();
//    	try {
//			session.update(ghe);
//			t.commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//			t.rollback();
//			return 0;
//		}finally {
//			session.close();
//		}
//    	return 1;
//    }
}
