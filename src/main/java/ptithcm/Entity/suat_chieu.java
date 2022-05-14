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
@Table(name="suat_chieu")
public class suat_chieu {
	@Id
	@GeneratedValue
	@Column(name="ma_sc")
    private Integer ma_sc;
	
	
	@Column(name="gio_bat_dau_gio_ket_thuc")
    private String gio_bat_dau_gio_ket_thuc;
	
	
	@Column(name="ngay_chieu")
    private String ngay_chieu;
	
	
	@ManyToOne
	@JoinColumn(name="ma_phim")
    private phim phim;
	
	@ManyToOne
	@JoinColumn(name="ma_pc")
	private phong_chieu phong_chieu;
	
	@OneToMany(mappedBy = "suat_chieu")
	private Collection<ve> ve;
	
	
   public phong_chieu getPhong_chieu() {
		return phong_chieu;
	}
	public void setPhong_chieu(phong_chieu phong_chieu) {
		this.phong_chieu = phong_chieu;
	}
public String getGio_bat_dau_gio_ket_thuc() {
		return gio_bat_dau_gio_ket_thuc;
	}
	public void setGio_bat_dau_gio_ket_thuc(String gio_bat_dau_gio_ket_thuc) {
		this.gio_bat_dau_gio_ket_thuc = gio_bat_dau_gio_ket_thuc;
	}
		public Collection<ve> getVe() {
		return ve;
	}
	public void setVe(Collection<ve> ve) {
		this.ve = ve;
	}
	public Integer getMa_sc() {
		return ma_sc;
	}
	public void setMa_sc(Integer ma_sc) {
		this.ma_sc = ma_sc;
	}
//	public String getGio_bat_dau() {
//		return gio_bat_dau;
//	}
//	public void setGio_bat_dau(String gio_bat_dau) {
//		this.gio_bat_dau = gio_bat_dau;
//	}
//	public String getGio_ket_thuc() {
//		return gio_ket_thuc;
//	}
//	public void setGio_ket_thuc(String gio_ket_thuc) {
//		this.gio_ket_thuc = gio_ket_thuc;
//	}
	public String getNgay_chieu() {
		return ngay_chieu;
	}
	public void setNgay_chieu(String ngay_chieu) {
		this.ngay_chieu = ngay_chieu;
	}
	public phim getPhim() {
		return phim;
	}
	public void setPhim(phim phim) {
		this.phim = phim;
	}

	
	
}
