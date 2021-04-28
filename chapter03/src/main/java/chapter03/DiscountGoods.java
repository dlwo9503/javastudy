package chapter03;

import mypackage.Goods;

public class DiscountGoods extends Goods {
	private float discountRate = 0.5f;
//	값을 그대로 표현하는걸 리터럴 이라고함
//	자바는 디폴트로 더블형을 사용함.
	
	public float getDicountPrice() {
//		protected는 자식에서 접근할 수 있다.(price)
		return price * discountRate;
	}
}
