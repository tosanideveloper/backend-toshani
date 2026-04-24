package com.toshaniFintech.common.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class EmailReq {
	@Pattern(regexp = "^[^@ ]+@[^@ ]+\\.[^@ ]+$", message = "Enter valid email id")
	private String toEmail;
	private String ccEmailIds;

	@NotNull(message = "Subject can not be empty")
	private String subject;
	
	@NotNull(message = "Body can not be empty")
	private String body;
	
	private boolean isScheduled;
	private LocalDateTime scheduleTime;
	private String[] systemFileIds;

}
