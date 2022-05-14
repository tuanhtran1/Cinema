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
@Table(name="ghe")
public class ghe {
	@Id
	@GeneratedValue
	@Column(name="ma_ghe")
     private Integer ma_ghe;
	@Column(name="vi_tri_day")
     private String vi_tri_day;
	@Column(name="vi_tri_trong")
     private String vi_tri_trong;
	@ManyToOne
	@JoinColumn(name="ma_lg")
     private loai_ghe loai_ghe;
	@ManyToOne
	@JoinColumn(name="ma_pc")
     private phong_chieu phong_chieu;
	@OneToMany(mappedBy = "ghe",fetch = FetchType.EAGER)
	private Collection<ve> ve;
	
	public Collection<ve> getVe() {
		return ve;
	}
	public void setVe(Collection<ve> ve) {
		this.ve = ve;
	}
	public Integer getMa_ghe() {
		return ma_ghe;
	}
	public void setMa_ghe(Integer ma_ghe) {
		this.ma_ghe = ma_ghe;
	}
	public String getVi_tri_day() {
		return vi_tri_day;
	}
	public void setVi_tri_day(String vi_tri_day) {
		this.vi_tri_day = vi_tri_day;
	}
	public String getVi_tri_trong() {
		return vi_tri_trong;
	}
	public void setVi_tri_trong(String vi_tri_trong) {
		this.vi_tri_trong = vi_tri_trong;
	}
	public loai_ghe getLoai_ghe() {
		return loai_ghe;
	}
	public void setLoai_ghe(loai_ghe loai_ghe) {
		this.loai_ghe = loai_ghe;
	}
	public phong_chieu getPhong_chieu() {
		return phong_chieu;
	}
	public void setPhong_chieu(phong_chieu phong_chieu) {
		this.phong_chieu = phong_chieu;
	}
	
	
     
}
