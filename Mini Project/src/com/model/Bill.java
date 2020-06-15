package com.model;

public class Bill {
	//Total, gst, final total
	
	private double Gst;
	private double Final;
	private double total;
	public double getGst() {
		return Gst;
	}
	public void setGst(double gst) {
		Gst = gst;
	}
	public double getFinal() {
		return Final;
	}
	public void setFinal(double final1) {
		Final = final1;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
