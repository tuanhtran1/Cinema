package ptithcm.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="nhan_vien")
public class nhan_vien {
	@Id
	@GeneratedValue
	@Column(name="ma_nv")
     private Integer ma_nv;
	@Column(name="ho_ten")
     private String ho_ten;
	@Column(name="so_dien_thoai")
     private String so_dien_thoai;
	@Column(name="so_cmnd")
     private String so_cmnd;
	@Column(name="email")
     private String email;
	@Column(name="dia_chi")
     private String dia_chi;
	@Column(name="ngay_vao_lam")
     private String ngay_vao_lam;
	@Column(name="gioi_tinh")
     private String gioi_tinh;
	@Column(name="mat_khau")
     private String mat_khau;
	@ManyToOne
	@JoinColumn(name="ma_vai_tro")
     private vai_tro vai_tro;
	
	public nhan_vien(Integer ma_nv, String ho_ten, String so_dien_thoai, String so_cmnd, String email, String dia_chi,
			String ngay_vao_lam, String gioi_tinh, String mat_khau, ptithcm.Entity.vai_tro vai_tro) {
		super();
		this.ma_nv = ma_nv;
		this.ho_ten = ho_ten;
		this.so_dien_thoai = so_dien_thoai;
		this.so_cmnd = so_cmnd;
		this.email = email;
		this.dia_chi = dia_chi;
		this.ngay_vao_lam = ngay_vao_lam;
		this.gioi_tinh = gioi_tinh;
		this.mat_khau = mat_khau;
		this.vai_tro = vai_tro;
	}
	public nhan_vien() {
		super();
	}
	public nhan_vien(String ho_ten, String mat_khau) {
		super();
		this.ho_ten = ho_ten;
		this.mat_khau = mat_khau;
	}
	public Integer getMa_nv() {
		return ma_nv;
	}
	public void setMa_nv(Integer ma_nv) {
		this.ma_nv = ma_nv;
	}
	public String getHo_ten() {
		return ho_ten;
	}
	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}
	public String getSo_dien_thoai() {
		return so_dien_thoai;
	}
	public void setSo_dien_thoai(String so_dien_thoai) {
		this.so_dien_thoai = so_dien_thoai;
	}
	public String getSo_cmnd() {
		return so_cmnd;
	}
	public void setSo_cmnd(String so_cmnd) {
		this.so_cmnd = so_cmnd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public String getNgay_vao_lam() {
		return ngay_vao_lam;
	}
	public void setNgay_vao_lam(String ngay_vao_lam) {
		this.ngay_vao_lam = ngay_vao_lam;
	}
	public String getGioi_tinh() {
		return gioi_tinh;
	}
	public void setGioi_tinh(String gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}
	public String getMat_khau() {
		return mat_khau;
	}
	public void setMat_khau(String mat_khau) {
		this.mat_khau = mat_khau;
	}
	public vai_tro getVai_tro() {
		return vai_tro;
	}
	public void setVai_tro(vai_tro vai_tro) {
		this.vai_tro = vai_tro;
	}
     
}
