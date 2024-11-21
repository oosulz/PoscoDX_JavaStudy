package tv;

import java.nio.channels.Channel;

public class TV {

	private int channel;
	private int volume;
	private boolean status;

	public TV(int i, int j, boolean b) {
		this.channel = i;
		this.volume = j;
		this.status = b;
	}

	public void status() {
		if (status) {
			System.out.println("TV[channel=" + channel + ", volume=" + volume + ", power= on]");
		} else {
			System.out.println("TV[channel=" + channel + ", volume=" + volume + ", power= off]");
		}
		
	}

	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public boolean isStatus() {
		return status;
	}

	public void power(boolean on) {
		this.status = on;
	}

	public void channel(int channel) {
		// 모듈러 연산으로 변경
		if (channel > 255) {
			channel = 1;
		}
		else if (channel < 1) {
			channel = 255;
		}

		this.channel = channel;
	}

	public void channel(boolean up) {
		// 모듈러 연산으로 변경
		int tmp = 0;
		if (up == true) {
			tmp = channel + 1;
			if (tmp > 255) {
				tmp = 1;
			}
		} else {
			tmp = channel - 1;
			if (tmp < 1) {
				tmp = 255;
			}
		}
		this.channel = tmp;
	}
	

	public void volume(int volume) {
		// 모듈러 연산으로 변경
		if (volume > 100) {
			volume = 0;
		}
		else if (volume < 0) {
			volume = 100;
		}
		this.volume = volume;
	}

	public void volume(boolean up) {
		// 모듈러 연산으로 변경
		int tmp = 0;
		if (up == true) {
			tmp = volume + 1;
			if (tmp > 100) {
				tmp = 0;
			}
		} else {
			tmp = volume - 1;
			if (tmp < 0) {
				tmp = 100;
			}
		}
		this.volume = tmp;
	}
}
