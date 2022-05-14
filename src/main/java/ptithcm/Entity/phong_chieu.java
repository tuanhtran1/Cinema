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
@Table(name="phong_chieu")
public class phong_chieu {
	@Id
	@GeneratedValue
	@Column(name="ma_pc")
    private Integer ma_pc;
	@Column(name="ten_pc")
    private String ten_pc;
	@Column(name="so_day_ghe")
    private String so_day_ghe;
	@Column(name="so_luong_ghe")
    private Integer so_luong_ghe;
	@Column(name="mo_ta")
    private String mo_ta;
	@ManyToOne
	@JoinColumn(name="ma_rap")
    private rap rap;
	
	@OneToMany(mappedBy = "phong_chieu")
	private Collection<ghe> ghe;
	
	@OneToMany(mappedBy = "phong_chieu")
	private Collection<suat_chieu> suat_chieu;
    
	public Collection<suat_chieu> getSuat_chieu() {
		return suat_chieu;
	}
	public void setSuat_chieu(Collection<suat_chieu> suat_chieu) {
		this.suat_chieu = suat_chieu;
	}
	
	public Collection<ghe> getGhe() {
		return ghe;
	}
	public void setGhe(Collection<ghe> ghe) {
		this.ghe = ghe;
	}
	public phong_chieu() {
		super();
	}
	public Integer getMa_pc() {
		return ma_pc;
	}
	public void setMa_pc(Integer ma_pc) {
		this.ma_pc = ma_pc;
	}
	public String getTen_pc() {
		return ten_pc;
	}
	public void setTen_pc(String ten_pc) {
		this.ten_pc = ten_pc;
	}
	public String getSo_day_ghe() {
		return so_day_ghe;
	}
	public void setSo_day_ghe(String so_day_ghe) {
		this.so_day_ghe = so_day_ghe;
	}
	public Integer getSo_luong_ghe() {
		return so_luong_ghe;
	}
	public void setSo_luong_ghe(Integer so_luong_ghe) {
		this.so_luong_ghe = so_luong_ghe;
	}
	public String getMo_ta() {
		return mo_ta;
	}
	public void setMo_ta(String mo_ta) {
		this.mo_ta = mo_ta;
	}
	public rap getRap() {
		return rap;
	}
	public void setRap(rap rap) {
		this.rap = rap;
	}
	
}
