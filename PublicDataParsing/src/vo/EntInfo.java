package vo;

public class EntInfo {
	private String seq;
	private String entIdx;
	private String wkplNm;
	private String dataCrtYm;
	private String bzowrRgstNo;
	private String wkplRoadNmDtlAddr;
	private String wkplJnngStcd;
	private String wkplStylDvcd;
	private String ldongAddrMgplDgCd;
	private String ldongAddrMgplSgguCd;
	private String ldongAddrMgplSgguEmdCd;

	public EntInfo() {}
	
	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getEntIdx() {
		return entIdx;
	}

	public void setEntIdx(String entIdx) {
		this.entIdx = entIdx;
	}

	public String getWkplNm() {
		return wkplNm;
	}

	public void setWkplNm(String wkplNm) {
		this.wkplNm = wkplNm;
	}

	public String getDataCrtYm() {
		return dataCrtYm;
	}

	public void setDataCrtYm(String dataCrtYm) {
		this.dataCrtYm = dataCrtYm;
	}

	public String getBzowrRgstNo() {
		return bzowrRgstNo;
	}

	public void setBzowrRgstNo(String bzowrRgstNo) {
		this.bzowrRgstNo = bzowrRgstNo;
	}

	public String getWkplRoadNmDtlAddr() {
		return wkplRoadNmDtlAddr;
	}

	public void setWkplRoadNmDtlAddr(String wkplRoadNmDtlAddr) {
		this.wkplRoadNmDtlAddr = wkplRoadNmDtlAddr;
	}

	public String getWkplJnngStcd() {
		return wkplJnngStcd;
	}

	public void setWkplJnngStcd(String wkplJnngStcd) {
		this.wkplJnngStcd = wkplJnngStcd;
	}

	public String getWkplStylDvcd() {
		return wkplStylDvcd;
	}

	public void setWkplStylDvcd(String wkplStylDvcd) {
		this.wkplStylDvcd = wkplStylDvcd;
	}

	public String getLdongAddrMgplDgCd() {
		return ldongAddrMgplDgCd;
	}

	public void setLdongAddrMgplDgCd(String ldongAddrMgplDgCd) {
		this.ldongAddrMgplDgCd = ldongAddrMgplDgCd;
	}

	public String getLdongAddrMgplSgguCd() {
		return ldongAddrMgplSgguCd;
	}

	public void setLdongAddrMgplSgguCd(String ldongAddrMgplSgguCd) {
		this.ldongAddrMgplSgguCd = ldongAddrMgplSgguCd;
	}

	public String getLdongAddrMgplSgguEmdCd() {
		return ldongAddrMgplSgguEmdCd;
	}

	public void setLdongAddrMgplSgguEmdCd(String ldongAddrMgplSgguEmdCd) {
		this.ldongAddrMgplSgguEmdCd = ldongAddrMgplSgguEmdCd;
	}

	@Override
	public String toString() {
		return "EntInfo [seq=" + seq + ", entIdx=" + entIdx + ", wkplNm=" + wkplNm + ", dataCrtYm=" + dataCrtYm
				+ ", bzowrRgstNo=" + bzowrRgstNo + ", wkplRoadNmDtlAddr=" + wkplRoadNmDtlAddr + ", wkplJnngStcd="
				+ wkplJnngStcd + ", wkplStylDvcd=" + wkplStylDvcd + ", ldongAddrMgplDgCd=" + ldongAddrMgplDgCd
				+ ", ldongAddrMgplSgguCd=" + ldongAddrMgplSgguCd + ", ldongAddrMgplSgguEmdCd=" + ldongAddrMgplSgguEmdCd
				+ "]";
	}

}
