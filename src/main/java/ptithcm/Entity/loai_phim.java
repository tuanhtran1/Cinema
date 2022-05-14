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
@Table(name="loai_phim")
public class loai_phim {
	@Id
	@GeneratedValue
	@Column(name="ma_loai_phim")
    private Integer ma_loai_phim;
	@Column(name="ten_loai_phim")
   private String ten_loai_phim;
	@OneToMany(mappedBy = "loai_phim",fetch = FetchType.EAGER)
	private Collection<phim> phim;
	public Integer getMa_loai_phim() {
		return ma_loai_phim;
	}
	public void setMa_loai_phim(Integer ma_loai_phim) {
		this.ma_loai_phim = ma_loai_phim;
	}
	public String getTen_loai_phim() {
		return ten_loai_phim;
	}
	public void setTen_loai_phim(String ten_loai_phim) {
		this.ten_loai_phim = ten_loai_phim;
	}
	public Collection<phim> getPhim() {
		return phim;
	}
	public void setPhim(Collection<phim> phim) {
		this.phim = phim;
	}
	
  
}
