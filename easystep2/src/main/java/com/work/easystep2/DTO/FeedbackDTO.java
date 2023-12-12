package com.work.easystep2.DTO;

import java.util.Date;

import com.work.easystep2.model.VenderFeedback;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackDTO {
	
	private String venderName;
	
	private String travelerName;
	
	private Date writeDate;
	
	private Integer score;
	
	private String feedback;
	
	private String travelerPhoto;

	public FeedbackDTO(VenderFeedback v) {
		this.writeDate = v.getWriteDate();
		this.score = v.getScore();
		this.feedback = v.getFeedback();
	}
	public FeedbackDTO() {
		
	}
}
