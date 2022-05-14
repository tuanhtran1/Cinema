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
@Table(name="vai_tro")
public class vai_tro {
	@Id
	@GeneratedValue
	@Column(name="ma_vai_tro")
   private Integer ma_vai_tro;
	@Column(name="vai_tro")
   private String vai_tro;
	@OneToMany(mappedBy = "vai_tro",fetch = FetchType.EAGER)
   private Collection<nhan_vien> nhan_vien;
public Integer getMa_vai_tro() {
	return ma_vai_tro;
}
public void setMa_vai_tro(Integer ma_vai_tro) {
	this.ma_vai_tro = ma_vai_tro;
}
public String getVai_tro() {
	return vai_tro;
}
public void setVai_tro(String vai_tro) {
	this.vai_tro = vai_tro;
}
public Collection<nhan_vien> getNhan_vien() {
	return nhan_vien;
}
public void setNhan_vien(Collection<nhan_vien> nhan_vien) {
	this.nhan_vien = nhan_vien;
}
   
}
