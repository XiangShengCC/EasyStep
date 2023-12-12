package com.work.easystep2.DTO;

import com.work.easystep2.model.VenderInformation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VenderInformationDTO {

	private String venderIntroduce;

	private String venderWorkmonth;

	private String venderStay;

	private String workMans;

	private String venderWorktime;
	
	public VenderInformationDTO() {
		
	}
	public VenderInformationDTO(VenderInformation vi) {
		this.venderIntroduce = vi.getVenderIntroduce();
		this.venderWorkmonth = vi.getVenderWorkmonth();
		this.venderStay = vi.getVenderStay();
		this.workMans = vi.getWorkMans();
		this.venderWorktime = vi.getVenderWorktime();
	}
}
