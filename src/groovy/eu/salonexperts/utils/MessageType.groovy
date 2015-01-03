package eu.salonexperts.utils

enum MessageType {
	
	ERROR,
	SUCCESS,
	WARNING,
	INFO;
	
	public String toString() {
		return name().toLowerCase();
	}
}
