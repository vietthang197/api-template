package vn.neo.api.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer status;
	private String message;
	private Object data;
	
	public ApiResponseDto() {
		
	}
	
	public ApiResponseDto(Object data) {
		this.data = data;
		this.status = 1;
		this.message = "success";
	}
}
