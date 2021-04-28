package tv;

public class TV {
	private int channel; // 1 ~ 255 넘어가면 1로 초기화
	private int volume; // 0 ~ 100
	private boolean power;
	
	public TV(){
	}
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	public void power(boolean on) {
		if(on) {
			power = true;
		} else {
			power = false;
		}
	}
	public void channel(boolean up) {
		if(up) {
			channel++;
			if (channel > 255) channel = 1; 
		}else {
			channel--;
			if (channel < 1) channel = 255;
		}
	}
	public void channel(int channel) {
		this.channel = channel;
		if (channel > 255) this.channel = 255;
		else if (channel < 1) this.channel = 1;
	}
	public void volume(boolean up) {
		if(up) {
			volume++;
			if (volume > 100) volume = 1; 
		}else {
			volume--;
			if (volume < 0) volume = 100;
		}
	}
	public void volume(int volume) {
		this.volume = volume;
		if (volume > 100) this.volume = 100;
		else if (volume < 0) this.volume = 0;
	}
	
	public void status() {
		System.out.println("TV[power=" + power + ", channel=" + channel + ", volume=" + volume + "]");
	}
}