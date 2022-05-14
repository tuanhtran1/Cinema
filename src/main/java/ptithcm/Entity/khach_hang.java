package ptithcm.Entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="khach_hang")
public class khach_hang {
	@Id
	@GeneratedValue
	@Column(name="ma_kh")
   private int ma_kh;
	@Column(name="ho_ten")
   private String ho_ten;
	@Column(name="so_cmnd")
   private String so_cmnd;
	@Column(name="so_dien_thoai")
   private String so_dien_thoai;
	@Column(name="email")
   private String email;
	@Column(name="dia_chi")
   private String dia_chi;
	@Column(name="ngay_dang_ky")
   private String ngay_dang_ky;
	@Column(name="ngay_sinh")
   private String ngay_sinh;
	@Column(name="gioi_tinh")
   private String gioi_tinh;
	@Column(name="mat_khau")
   private String mat_khau;
   @OneToMany(mappedBy = "khach_hang",fetch = FetchType.EAGER)
   private Collection<ve> ve;


public Collection<ve> getVe() {
	return ve;
}

public void setVe(Collection<ve> ve) {
	this.ve = ve;
}

public khach_hang() {
	super();
}

public khach_hang(String ho_ten, String so_cmnd, String so_dien_thoai, String email, String dia_chi,
		String ngay_dang_ky, String ngay_sinh, String gioi_tinh, String mat_khau, String ma_loai_kh) {
	super();
	this.ho_ten = ho_ten;
	this.so_cmnd = so_cmnd;
	this.so_dien_thoai = so_dien_thoai;
	this.email = email;
	this.dia_chi = dia_chi;
	this.ngay_dang_ky = ngay_dang_ky;
	this.ngay_sinh = ngay_sinh;
	this.gioi_tinh = gioi_tinh;
	this.mat_khau = mat_khau;
	
}

public khach_hang(String ho_ten, String mat_khau) {
	super();
	this.ho_ten = ho_ten;
	this.mat_khau = mat_khau;
}

public int getMa_kh() {
	return ma_kh;
}
public void setMa_kh(int ma_kh) {
	this.ma_kh = ma_kh;
}
public String getHo_ten() {
	return ho_ten;
}
public void setHo_ten(String ho_ten) {
	this.ho_ten = ho_ten;
}
public String getSo_cmnd() {
	return so_cmnd;
}
public void setSo_cmnd(String so_cmnd) {
	this.so_cmnd = so_cmnd;
}
public String getSo_dien_thoai() {
	return so_dien_thoai;
}
public void setSo_dien_thoai(String so_dien_thoai) {
	this.so_dien_thoai = so_dien_thoai;
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
public String getNgay_dang_ky() {
	return ngay_dang_ky;
}
public void setNgay_dang_ky(String ngay_dang_ky) {
	this.ngay_dang_ky = ngay_dang_ky;
}
public String getNgay_sinh() {
	return ngay_sinh;
}
public void setNgay_sinh(String ngay_sinh) {
	this.ngay_sinh = ngay_sinh;
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


   
}
