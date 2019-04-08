package com.concurrent.producerconsumer;
/**
 * 时间:2019年3月6日
 * @author pefuxc
 *
 */
public class Food {

	private String aFoodName;
	private String aFoodEffect;

	public String getaFoodName() {
		return aFoodName;
	}

	public void setaFoodName(String aFoodName) {
		this.aFoodName = aFoodName;
	}

	public String getaFoodEffect() {
		return aFoodEffect;
	}

	public void setaFoodEffect(String aFoodEffect) {
		this.aFoodEffect = aFoodEffect;
	}

	public Food(String aFoodName, String aFoodEffect) {
		this.aFoodName = aFoodName;
		this.aFoodEffect = aFoodEffect;
	}


}
