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
@Table(name="loai_ghe")
public class loai_ghe {
	@Id
	@GeneratedValue
	@Column(name="ma_lg")
   private Integer ma_lg;
	@Column(name="ten_loai_ghe")
   private String ten_loai_ghe;
	@Column(name="gia_ghe")
   private String gia_ghe;
	@OneToMany(mappedBy = "loai_ghe",fetch = FetchType.EAGER)
   private Collection<ghe> ghe;
public Integer getMa_lg() {
	return ma_lg;
}
public void setMa_lg(Integer ma_lg) {
	this.ma_lg = ma_lg;
}
public String getTen_loai_ghe() {
	return ten_loai_ghe;
}
public void setTen_loai_ghe(String ten_loai_ghe) {
	this.ten_loai_ghe = ten_loai_ghe;
}
public String getGia_ghe() {
	return gia_ghe;
}
public void setGia_ghe(String gia_ghe) {
	this.gia_ghe = gia_ghe;
}
public Collection<ghe> getGhe() {
	return ghe;
}
public void setGhe(Collection<ghe> ghe) {
	this.ghe = ghe;
}
   
}
