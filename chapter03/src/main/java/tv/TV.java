package tv;

public class TV {
	private int channel; // 1 ~ 255 넘어가면 1로 초기
	private int volume; // 1 ~ 100
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
	}
	public void volume(boolean up) {
		if(up) {
			volume++;
		}else {
			volume--;
		}
	}
	public void volume(int volume) {
		this.volume = volume;
	}
	
	public void status() {
		System.out.println("TV[power=on, channel=11, volume=30]");
	}
}