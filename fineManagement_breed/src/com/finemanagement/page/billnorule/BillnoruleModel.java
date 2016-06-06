package com.finemanagement.page.billnorule;

import com.base.page.BasePage;

public class BillnoruleModel extends BasePage {

	private String billnorule_id;

	private String line_no;

	private String line_type;

	private String line_format;

	private String init_value;

	private String code;

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBillnorule_id() {
		return billnorule_id;
	}

	public void setBillnorule_id(String billnorule_id) {
		this.billnorule_id = billnorule_id;
	}

	public String getLine_no() {
		return line_no;
	}

	public void setLine_no(String line_no) {
		this.line_no = line_no;
	}

	public String getLine_type() {
		return line_type;
	}

	public void setLine_type(String line_type) {
		this.line_type = line_type;
	}

	public String getLine_format() {
		return line_format;
	}

	public void setLine_format(String line_format) {
		this.line_format = line_format;
	}

	public String getInit_value() {
		return init_value;
	}

	public void setInit_value(String init_value) {
		this.init_value = init_value;
	}

}
