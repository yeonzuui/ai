package com.lec.ex4_actor;
// 다형성 구현 ex
public class ActorMain {
	public static void main(String[] args) {
		Actor park = new Actor("박보검");
		park.canCatchCriminal();
		park.canSearch();
		park.outFire();
		park.saveMan();
		park.makePizza();
		park.makeSpaghetti();
		
		IPoliceMan policePark = park; // 거꾸로는 불가능
		policePark.canCatchCriminal();
		policePark.canSearch();
//		policePark.outFire();
//		policePark.saveMan();
//		policePark.makePizza();
//		policePark.makeSpaghetti();
		
		IFireFighter fighterPark = park;
//		fighterPark.canCatchCriminal();
//		fighterPark.canSearch();
		fighterPark.outFire();
		fighterPark.saveMan();
//		fighterPark.makePizza();
//		fighterPark.makeSpaghetti();
		
		IChef chefPark = park;
//		chefPark.canCatchCriminal();
//		chefPark.canSearch();
//		chefPark.outFire();
//		chefPark.saveMan();
		chefPark.makePizza();
		chefPark.makeSpaghetti();
	}
}
