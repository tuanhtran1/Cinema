package ptithcm.Entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="phim")
public class phim {
	@Id
	@GeneratedValue
	@Column(name="ma_phim")
   private Integer ma_phim;
	@Column(name="ten")
   private String ten;
	@Column(name="thoi_luong")
   private String thoi_luong;
	@Column(name="gioi_han_tuoi")
   private String gioi_han_tuoi;
	@Column(name="ngay_cong_chieu")
   private String ngay_cong_chieu;
	@Column(name="ngon_ngu")
   private String ngon_ngu;
	@Column(name="dien_vien")
   private String dien_vien;
	@Column(name="quoc_gia")
   private String quoc_gia;
	@Column(name="nha_san_xuat")
   private String nha_san_xuat;
	@Column(name="tom_tat")
   private String tom_tat;
	@ManyToOne
	@JoinColumn(name="ma_loai_phim")
    private loai_phim loai_phim;
	
	@OneToMany(mappedBy = "phim")
	private Collection<suat_chieu> suat_chieu;
	
	public Collection<suat_chieu> getSuat_chieu() {
		return suat_chieu;
	}
	public void setSuat_chieu(Collection<suat_chieu> suat_chieu) {
		this.suat_chieu = suat_chieu;
	}
	public Integer getMa_phim() {
		return ma_phim;
	}
	public void setMa_phim(Integer ma_phim) {
		this.ma_phim = ma_phim;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getThoi_luong() {
		return thoi_luong;
	}
	public void setThoi_luong(String thoi_luong) {
		this.thoi_luong = thoi_luong;
	}
	public String getGioi_han_tuoi() {
		return gioi_han_tuoi;
	}
	public void setGioi_han_tuoi(String gioi_han_tuoi) {
		this.gioi_han_tuoi = gioi_han_tuoi;
	}
	public String getNgay_cong_chieu() {
		return ngay_cong_chieu;
	}
	public void setNgay_cong_chieu(String ngay_cong_chieu) {
		this.ngay_cong_chieu = ngay_cong_chieu;
	}
	public String getNgon_ngu() {
		return ngon_ngu;
	}
	public void setNgon_ngu(String ngon_ngu) {
		this.ngon_ngu = ngon_ngu;
	}
	public String getDien_vien() {
		return dien_vien;
	}
	public void setDien_vien(String dien_vien) {
		this.dien_vien = dien_vien;
	}
	public String getQuoc_gia() {
		return quoc_gia;
	}
	public void setQuoc_gia(String quoc_gia) {
		this.quoc_gia = quoc_gia;
	}
	public String getNha_san_xuat() {
		return nha_san_xuat;
	}
	public void setNha_san_xuat(String nha_san_xuat) {
		this.nha_san_xuat = nha_san_xuat;
	}
	public String getTom_tat() {
		return tom_tat;
	}
	public void setTom_tat(String tom_tat) {
		this.tom_tat = tom_tat;
	}
	public loai_phim getLoai_phim() {
		return loai_phim;
	}
	public void setLoai_phim(loai_phim loai_phim) {
		this.loai_phim = loai_phim;
	}
	
	
	
}
