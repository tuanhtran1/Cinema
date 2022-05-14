package ptithcm.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ve")
public class ve {
	@Id
	@GeneratedValue
	@Column(name="ma_ve")
    private Integer ma_ve;
	@Column(name="ngay_ban")
    private String ngay_ban;
	@Column(name="gia_ve")
    private String gia_ve;
	@ManyToOne
	@JoinColumn(name="ma_sc")
    private suat_chieu suat_chieu;
	@ManyToOne
	@JoinColumn(name="ma_ghe")
    private ghe ghe;
	@ManyToOne
	@JoinColumn(name="ma_kh")
    private khach_hang khach_hang;
	
	public Integer getMa_ve() {
		return ma_ve;
	}
	public void setMa_ve(Integer ma_ve) {
		this.ma_ve = ma_ve;
	}
	public String getNgay_ban() {
		return ngay_ban;
	}
	public void setNgay_ban(String ngay_ban) {
		this.ngay_ban = ngay_ban;
	}
	public String getGia_ve() {
		return gia_ve;
	}
	public void setGia_ve(String gia_ve) {
		this.gia_ve = gia_ve;
	}
	public suat_chieu getSuat_chieu() {
		return suat_chieu;
	}
	public void setSuat_chieu(suat_chieu suat_chieu) {
		this.suat_chieu = suat_chieu;
	}
	public ghe getGhe() {
		return ghe;
	}
	public void setGhe(ghe ghe) {
		this.ghe = ghe;
	}
	public khach_hang getKhach_hang() {
		return khach_hang;
	}
	public void setKhach_hang(khach_hang khach_hang) {
		this.khach_hang = khach_hang;
	}
	
}
