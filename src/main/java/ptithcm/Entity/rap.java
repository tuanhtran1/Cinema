package ptithcm.Entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="rap")
public class rap {
	@Id
	@GeneratedValue
	@Column(name="ma_rap")
   private Integer ma_rap;
	@Column(name="ten_rap")
   private String ten_rap;
	@Column(name="dia_chi")
   private String dia_chi;
	@OneToMany(mappedBy = "rap",fetch = FetchType.EAGER)
	private Collection<phong_chieu> phong_chieu;
	public Integer getMa_rap() {
		return ma_rap;
	}
	public void setMa_rap(Integer ma_rap) {
		this.ma_rap = ma_rap;
	}
	public String getTen_rap() {
		return ten_rap;
	}
	public void setTen_rap(String ten_rap) {
		this.ten_rap = ten_rap;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public Collection<phong_chieu> getPhong_chieu() {
		return phong_chieu;
	}
	public void setPhong_chieu(Collection<phong_chieu> phong_chieu) {
		this.phong_chieu = phong_chieu;
	}
	
   
}
